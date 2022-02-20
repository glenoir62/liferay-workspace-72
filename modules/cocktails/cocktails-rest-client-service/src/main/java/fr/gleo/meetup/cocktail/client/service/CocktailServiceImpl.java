package fr.gleo.meetup.cocktail.client.service;


import fr.gleo.meetup.cocktail.client.api.CocktailService;
import fr.gleo.meetup.cocktail.client.model.PageCocktail;
import fr.gleo.meetup.cocktail.client.service.invoker.ApiClient;
import fr.gleo.meetup.cocktail.client.service.invoker.GsonCustomConverterFactory;
import fr.gleo.meetup.cocktail.client.service.invoker.JSON;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author Guillaume Lenoir
 */
@Component(
        immediate = false,
        scope = ServiceScope.PROTOTYPE,
        service = CocktailService.class
)
@ProviderType
public class CocktailServiceImpl implements CocktailService {

    private CocktailApi cocktailApi;

    public CocktailServiceImpl() {
        ApiClient apiClient = new ApiClient( "OAuth2", "id-eb17215b-abca-e914-bef1-674644bfa5b3", "secret-eed84bfc-1cd8-466d-e21b-7e41a121dc35");
        apiClient.setCredentials("id-eb17215b-abca-e914-bef1-674644bfa5b3","secret-eed84bfc-1cd8-466d-e21b-7e41a121dc35");
        apiClient.setAdapterBuilder(new Retrofit
                .Builder()
                .baseUrl("http://localhost:8080/o/cocktails/v1.0/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonCustomConverterFactory.create(new JSON().getGson())));

        OkHttpClient.Builder builder = apiClient.getOkBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);

        cocktailApi = apiClient.createService(CocktailApi.class);
    }
    @Override
    public PageCocktail getSiteCocktailsPage(Long siteId, String filter, Integer page, Integer pageSize, String search, String sort) throws IOException {
        return cocktailApi.getSiteCocktailsPage(siteId, filter, page, pageSize, search, sort).execute().body();
    }

}