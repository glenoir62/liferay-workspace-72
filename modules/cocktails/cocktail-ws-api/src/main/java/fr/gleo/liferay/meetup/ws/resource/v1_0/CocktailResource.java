package fr.gleo.liferay.meetup.ws.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import fr.gleo.liferay.meetup.ws.dto.v1_0.Cocktail;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/cocktails/v1.0
 *
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
public interface CocktailResource {

	public void deleteCocktail(Long cocktailId) throws Exception;

	public Cocktail getCocktail(Long cocktailId) throws Exception;

	public Cocktail putCocktail(Long cocktailId, Cocktail cocktail)
		throws Exception;

	public Page<Cocktail> getSiteCocktailsPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception;

	public Cocktail postSiteCocktail(Long siteId, Cocktail cocktail)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}