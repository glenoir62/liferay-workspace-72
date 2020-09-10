package fr.gleo.liferay.meetup.ws.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import fr.gleo.liferay.meetup.ws.dto.v1_0.Cocktail;
import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseCocktailResourceImpl implements CocktailResource {

	@Override
	@DELETE
	@Operation(description = "delete cocktailId")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "cocktailId")}
	)
	@Path("/cocktails/{cocktailId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cocktail")})
	public void deleteCocktail(
			@NotNull @Parameter(hidden = true) @PathParam("cocktailId") Long
				cocktailId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "get cocktailId")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "cocktailId")}
	)
	@Path("/cocktails/{cocktailId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cocktail")})
	public Cocktail getCocktail(
			@NotNull @Parameter(hidden = true) @PathParam("cocktailId") Long
				cocktailId)
		throws Exception {

		return new Cocktail();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "put cocktailId")
	@PUT
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "cocktailId")}
	)
	@Path("/cocktails/{cocktailId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cocktail")})
	public Cocktail putCocktail(
			@NotNull @Parameter(hidden = true) @PathParam("cocktailId") Long
				cocktailId,
			Cocktail cocktail)
		throws Exception {

		return new Cocktail();
	}

	@Override
	@GET
	@Operation(description = "get cocktails by site id")
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "siteId"),
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/sites/{siteId}/cocktails")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cocktail")})
	public Page<Cocktail> getSiteCocktailsPage(
			@NotNull @Parameter(hidden = true) @PathParam("siteId") Long siteId,
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "post cocktails by site id")
	@POST
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "siteId")})
	@Path("/sites/{siteId}/cocktails")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cocktail")})
	public Cocktail postSiteCocktail(
			@NotNull @Parameter(hidden = true) @PathParam("siteId") Long siteId,
			Cocktail cocktail)
		throws Exception {

		return new Cocktail();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Cocktail cocktail, Cocktail existingCocktail) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}