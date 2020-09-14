package fr.gleo.liferay.meetup.ws.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import fr.gleo.liferay.meetup.ws.internal.graphql.mutation.v1_0.Mutation;
import fr.gleo.liferay.meetup.ws.internal.graphql.query.v1_0.Query;
import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCocktailResourceComponentServiceObjects(
			_cocktailResourceComponentServiceObjects);

		Query.setCocktailResourceComponentServiceObjects(
			_cocktailResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/cocktails-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CocktailResource>
		_cocktailResourceComponentServiceObjects;

}