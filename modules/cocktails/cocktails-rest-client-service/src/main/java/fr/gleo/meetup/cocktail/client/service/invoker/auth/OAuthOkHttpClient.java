package fr.gleo.meetup.cocktail.client.service.invoker.auth;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import okhttp3.*;
import org.apache.oltu.oauth2.client.HttpClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import org.apache.oltu.oauth2.client.response.OAuthClientResponseFactory;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;


import okhttp3.Request.Builder;


public class OAuthOkHttpClient implements HttpClient {

    private OkHttpClient client;

    private volatile String username;

    private volatile String password;

    public OAuthOkHttpClient() {
        this.client = new OkHttpClient();
    }

    public OAuthOkHttpClient(OkHttpClient client, String username, String password) {
        this.client = client;
        this.password = password;
        this.username = username;
    }

    public <T extends OAuthClientResponse> T execute(OAuthClientRequest request, Map<String, String> headers,
                                                     String requestMethod, Class<T> responseClass)
            throws OAuthSystemException, OAuthProblemException {

        MediaType mediaType = MediaType.parse("application/json");
        Request.Builder requestBuilder = new Request.Builder().url(request.getLocationUri());

        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("Content-Type")) {
                    mediaType = MediaType.parse(entry.getValue());
                } else {
                    requestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }

        RequestBody body = request.getBody() != null ? RequestBody.create(mediaType, request.getBody()) : null;
        requestBuilder.method(requestMethod, body);

        requestBuilder.header("Authorization", Credentials.basic(username, password));

        try {
            Response response = client.newCall(requestBuilder.build()).execute();
            return OAuthClientResponseFactory.createCustomResponse(
                    response.body().string(),
                    response.body().contentType().toString(),
                    response.code(),
                    responseClass);
        } catch (IOException e) {
            throw new OAuthSystemException(e);
        }
    }

    public void shutdown() {
        // Nothing to do here
    }

}
