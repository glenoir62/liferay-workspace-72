package fr.gleo.liferay.meetup.ws.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import fr.gleo.liferay.meetup.ws.dto.v1_0.Cocktail;
import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setCocktailResourceComponentServiceObjects(
		ComponentServiceObjects<CocktailResource>
			cocktailResourceComponentServiceObjects) {

		_cocktailResourceComponentServiceObjects =
			cocktailResourceComponentServiceObjects;
	}

	@GraphQLInvokeDetached
	public void deleteCocktail(@GraphQLName("cocktailId") Long cocktailId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_cocktailResourceComponentServiceObjects,
			this::_populateResourceContext,
			cocktailResource -> cocktailResource.deleteCocktail(cocktailId));
	}

	@GraphQLInvokeDetached
	public Cocktail putCocktail(
			@GraphQLName("cocktailId") Long cocktailId,
			@GraphQLName("cocktail") Cocktail cocktail)
		throws Exception {

		return _applyComponentServiceObjects(
			_cocktailResourceComponentServiceObjects,
			this::_populateResourceContext,
			cocktailResource -> cocktailResource.putCocktail(
				cocktailId, cocktail));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Cocktail postSiteCocktail(
			@GraphQLName("siteId") Long siteId,
			@GraphQLName("cocktail") Cocktail cocktail)
		throws Exception {

		return _applyComponentServiceObjects(
			_cocktailResourceComponentServiceObjects,
			this::_populateResourceContext,
			cocktailResource -> cocktailResource.postSiteCocktail(
				siteId, cocktail));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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