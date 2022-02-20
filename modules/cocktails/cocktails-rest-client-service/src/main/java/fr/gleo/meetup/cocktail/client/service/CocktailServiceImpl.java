package fr.gleo.meetup.cocktail.client.service;


import fr.gleo.meetup.cocktail.client.api.CocktailService;
import fr.gleo.meetup.cocktail.client.model.PageCocktail;
import fr.gleo.meetup.cocktail.client.service.invoker.ApiClient;
import okhttp3.OkHttpClient;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

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
        ApiClient apiClient = new ApiClient();
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