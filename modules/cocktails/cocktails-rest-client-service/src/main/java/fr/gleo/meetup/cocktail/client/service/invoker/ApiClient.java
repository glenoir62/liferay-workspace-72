package fr.gleo.meetup.cocktail.client.service.invoker;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import fr.gleo.meetup.cocktail.client.service.invoker.auth.ApiKeyAuth;
import fr.gleo.meetup.cocktail.client.service.invoker.auth.HttpBasicAuth;
import fr.gleo.meetup.cocktail.client.service.invoker.auth.OAuth;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest.AuthenticationRequestBuilder;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest.TokenRequestBuilder;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import fr.gleo.meetup.cocktail.client.service.invoker.auth.HttpBearerAuth;
import fr.gleo.meetup.cocktail.client.service.invoker.auth.OAuthFlow;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiClient {

  private Map<String, Interceptor> apiAuthorizations;
  private OkHttpClient.Builder okBuilder;
  private Retrofit.Builder adapterBuilder;
  private JSON json;
  private OkHttpClient okHttpClient;

  public ApiClient() {
    apiAuthorizations = new LinkedHashMap<String, Interceptor>();
    okBuilder = new OkHttpClient.Builder();
  }

  public ApiClient(OkHttpClient client){
    apiAuthorizations = new LinkedHashMap<String, Interceptor>();
    okHttpClient = client;
  }

  /**
   * Helper constructor for single basic auth or password oauth2
   * @param authName Authentication name
   * @param username Username
   * @param password Password
   */
  public ApiClient(String authName, String username, String password) {
    this();

      Interceptor auth;
      if ("ApiKeyAuth".equals(authName)) {

        auth = new ApiKeyAuth("header", "X-API-Key");
      } else if ("BasicAuth".equals(authName)) {

        auth = new HttpBasicAuth();

      } else if ("BearerAuth".equals(authName)) {

        auth = new HttpBearerAuth("bearer");

      } else if ("OAuth2".equals(authName)) {

        auth = new OAuth(OAuthFlow.application, "",
                "http://localhost:8080/o/oauth2/token",
                "Liferay.Cocktails.everything Liferay.Cocktails.everything.write Liferay.Cocktails.everything.read",
                username,
                password );
      } else {
        throw new RuntimeException("auth name \"" + authName + "\" not found in available auth names");
      }

      addAuthorization(authName, auth);


    this.setCredentials(username,  password);
  }

  public void createDefaultAdapter() {
    json = new JSON();

    String baseUrl = "";
    if (!baseUrl.endsWith("/"))
      baseUrl = baseUrl + "/";

    adapterBuilder = new Retrofit
      .Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(ScalarsConverterFactory.create())
      .addConverterFactory(GsonCustomConverterFactory.create(json.getGson()));
  }

  public <S> S createService(Class<S> serviceClass) {
    if (okHttpClient != null) {
        return adapterBuilder.client(okHttpClient).build().create(serviceClass);
    } else {
        return adapterBuilder.client(okBuilder.build()).build().create(serviceClass);
    }
  }

  public ApiClient setDateFormat(DateFormat dateFormat) {
    this.json.setDateFormat(dateFormat);
    return this;
  }

  public ApiClient setSqlDateFormat(DateFormat dateFormat) {
    this.json.setSqlDateFormat(dateFormat);
    return this;
  }

  public ApiClient setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
    this.json.setOffsetDateTimeFormat(dateFormat);
    return this;
  }

  public ApiClient setLocalDateFormat(DateTimeFormatter dateFormat) {
    this.json.setLocalDateFormat(dateFormat);
    return this;
  }


  /**
   * Helper method to configure the first api key found
   * @param apiKey API key
   * @return ApiClient
   */
  public ApiClient setApiKey(String apiKey) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof ApiKeyAuth) {
        ApiKeyAuth keyAuth = (ApiKeyAuth) apiAuthorization;
        keyAuth.setApiKey(apiKey);
        return this;
      }
    }
    return this;
  }

  /**
   * Helper method to set token for the first Http Bearer authentication found.
   * @param bearerToken Bearer token
   * @return ApiClient
   */
  public ApiClient setBearerToken(String bearerToken) {
    for (Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof HttpBearerAuth) {
        ((HttpBearerAuth) apiAuthorization).setBearerToken(bearerToken);
        return this;
      }
    }
    return this;
  }

  /**
   * Helper method to configure the username/password for basic auth or password oauth
   * @param username Username
   * @param password Password
   * @return ApiClient
   */
  public ApiClient setCredentials(String username, String password) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof HttpBasicAuth) {
        HttpBasicAuth basicAuth = (HttpBasicAuth) apiAuthorization;
        basicAuth.setCredentials(username, password);
        return this;
      }
      if (apiAuthorization instanceof OAuth) {
        //OAuth oauth = (OAuth) apiAuthorization;
        //oauth.getTokenRequestBuilder().setUsername(username).setPassword(password);
        OAuth oauth = (OAuth) apiAuthorization;
        oauth.getTokenRequestBuilder().setUsername(username).setPassword(password);
        return this;
      }
    }
    return this;
  }

  /**
   * Helper method to configure the token endpoint of the first oauth found in the apiAuthorizations (there should be only one)
   * @return Token request builder
   */
  public TokenRequestBuilder getTokenEndPoint() {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof OAuth) {
        OAuth oauth = (OAuth) apiAuthorization;
        return oauth.getTokenRequestBuilder();
      }
    }
    return null;
  }

  /**
   * Helper method to configure authorization endpoint of the first oauth found in the apiAuthorizations (there should be only one)
   * @return Authentication request builder
   */
  public AuthenticationRequestBuilder getAuthorizationEndPoint() {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof OAuth) {
        OAuth oauth = (OAuth) apiAuthorization;
        return oauth.getAuthenticationRequestBuilder();
      }
    }
    return null;
  }

  /**
   * Helper method to pre-set the oauth access token of the first oauth found in the apiAuthorizations (there should be only one)
   * @param accessToken Access token
   * @return ApiClient
   */
  public ApiClient setAccessToken(String accessToken) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof OAuth) {
        OAuth oauth = (OAuth) apiAuthorization;
        oauth.setAccessToken(accessToken);
        return this;
      }
    }
    return this;
  }

  /**
   * Helper method to configure the oauth accessCode/implicit flow parameters
   * @param clientId Client ID
   * @param clientSecret Client secret
   * @param redirectURI Redirect URI
   * @return ApiClient
   */
  public ApiClient configureAuthorizationFlow(String clientId, String clientSecret, String redirectURI) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof OAuth) {
        OAuth oauth = (OAuth) apiAuthorization;
        oauth.getTokenRequestBuilder()
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .setRedirectURI(redirectURI);
        oauth.getAuthenticationRequestBuilder()
          .setClientId(clientId)
          .setRedirectURI(redirectURI);
        return this;
      }
    }
    return this;
  }

  /**
   * Configures a listener which is notified when a new access token is received.
   * @param accessTokenListener Access token listener
   * @return ApiClient
   */
  public ApiClient registerAccessTokenListener(OAuth.AccessTokenListener accessTokenListener) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      if (apiAuthorization instanceof OAuth) {
        OAuth oauth = (OAuth) apiAuthorization;
        oauth.registerAccessTokenListener(accessTokenListener);
        return this;
      }
    }
    return this;
  }

  /**
   * Adds an authorization to be used by the client
   * @param authName Authentication name
   * @param authorization Authorization interceptor
   * @return ApiClient
   */
  public ApiClient addAuthorization(String authName, Interceptor authorization) {
    if (apiAuthorizations.containsKey(authName)) {
      throw new RuntimeException("auth name \"" + authName + "\" already in api authorizations");
    }
    apiAuthorizations.put(authName, authorization);
    if(okBuilder == null){
        throw new RuntimeException("The ApiClient was created with a built OkHttpClient so it's not possible to add an authorization interceptor to it");
    }
    okBuilder.addInterceptor(authorization);

    return this;
  }

  public Map<String, Interceptor> getApiAuthorizations() {
    return apiAuthorizations;
  }

  public ApiClient setApiAuthorizations(Map<String, Interceptor> apiAuthorizations) {
    this.apiAuthorizations = apiAuthorizations;
    return this;
  }

  public Retrofit.Builder getAdapterBuilder() {
    return adapterBuilder;
  }

  public ApiClient setAdapterBuilder(Retrofit.Builder adapterBuilder) {
    this.adapterBuilder = adapterBuilder;
    return this;
  }

  public OkHttpClient.Builder getOkBuilder() {
    return okBuilder;
  }

  public void addAuthsToOkBuilder(OkHttpClient.Builder okBuilder) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      okBuilder.addInterceptor(apiAuthorization);
    }
  }

  /**
   * Clones the okBuilder given in parameter, adds the auth interceptors and uses it to configure the Retrofit
   * @param okClient An instance of OK HTTP client
   */
  public void configureFromOkclient(OkHttpClient okClient) {
    this.okBuilder = okClient.newBuilder();
    addAuthsToOkBuilder(this.okBuilder);
  }
}

/**
 * This wrapper is to take care of this case:
 * when the deserialization fails due to JsonParseException and the
 * expected type is String, then just return the body string.
 */
class GsonResponseBodyConverterToString<T> implements Converter<ResponseBody, T> {
  private final Gson gson;
  private final Type type;

  GsonResponseBodyConverterToString(Gson gson, Type type) {
    this.gson = gson;
    this.type = type;
  }

  @Override public T convert(ResponseBody value) throws IOException {
    String returned = value.string();
    try {
      return gson.fromJson(returned, type);
    }
    catch (JsonParseException e) {
      return (T) returned;
    }
  }
}
