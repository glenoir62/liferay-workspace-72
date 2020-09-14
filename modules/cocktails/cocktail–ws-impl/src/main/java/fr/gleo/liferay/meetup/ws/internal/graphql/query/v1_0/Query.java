package fr.gleo.liferay.meetup.ws.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import fr.gleo.liferay.meetup.ws.dto.v1_0.Cocktail;
import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
public class Query {

	public static void setCocktailResourceComponentServiceObjects(
		ComponentServiceObjects<CocktailResource>
			cocktailResourceComponentServiceObjects) {

		_cocktailResourceComponentServiceObjects =
			cocktailResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Cocktail getCocktail(@GraphQLName("cocktailId") Long cocktailId)
		throws Exception {

		return _applyComponentServiceObjects(
			_cocktailResourceComponentServiceObjects,
			this::_populateResourceContext,
			cocktailResource -> cocktailResource.getCocktail(cocktailId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Cocktail> getSiteCocktailsPage(
			@GraphQLName("siteId") Long siteId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_cocktailResourceComponentServiceObjects,
			this::_populateResourceContext,
			cocktailResource -> {
				Page paginationPage = cocktailResource.getSiteCocktailsPage(
					siteId, search, filter, Pagination.of(pageSize, page),
					sorts);

				return paginationPage.getItems();
			});
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(CocktailResource cocktailResource)
		throws Exception {

		cocktailResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<CocktailResource>
		_cocktailResourceComponentServiceObjects;

}