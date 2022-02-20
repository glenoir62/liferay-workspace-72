package fr.gleo.meetup.cocktail.client.service;

import retrofit2.Call;
import retrofit2.http.*;

import fr.gleo.meetup.cocktail.client.model.Cocktail;
import fr.gleo.meetup.cocktail.client.model.PageCocktail;

public interface CocktailApi {
  /**
   * 
   * delete cocktailId
   * @param cocktailId  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("cocktails/{cocktailId}")
  Call<Void> deleteCocktail(
    @retrofit2.http.Path("cocktailId") Long cocktailId
  );

  /**
   * 
   * get cocktailId
   * @param cocktailId  (required)
   * @return Call&lt;Cocktail&gt;
   */
  @GET("cocktails/{cocktailId}")
  Call<Cocktail> getCocktail(
    @retrofit2.http.Path("cocktailId") Long cocktailId
  );

  /**
   * 
   * Retrieves the Site&#39;s cocktails. Results can be paginated, filtered, searched, and sorted.
   * @param siteId  (required)
   * @param filter  (optional)
   * @param page  (optional)
   * @param pageSize  (optional)
   * @param search  (optional)
   * @param sort  (optional)
   * @return Call&lt;PageCocktail&gt;
   */
  @GET("sites/{siteId}/cocktails")
  Call<PageCocktail> getSiteCocktailsPage(
    @retrofit2.http.Path("siteId") Long siteId, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("pageSize") Integer pageSize, @retrofit2.http.Query("search") String search, @retrofit2.http.Query("sort") String sort
  );

  /**
   * 
   * post cocktails by site id
   * @param siteId  (required)
   * @param cocktail  (optional)
   * @return Call&lt;Cocktail&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("sites/{siteId}/cocktails")
  Call<Cocktail> postSiteCocktail(
    @retrofit2.http.Path("siteId") Long siteId, @retrofit2.http.Body Cocktail cocktail
  );

  /**
   * 
   * put cocktailId
   * @param cocktailId  (required)
   * @param cocktail  (optional)
   * @return Call&lt;Cocktail&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("cocktails/{cocktailId}")
  Call<Cocktail> putCocktail(
    @retrofit2.http.Path("cocktailId") Long cocktailId, @retrofit2.http.Body Cocktail cocktail
  );

}
