package fr.gleo.liferay.meetup.ws.internal.resource.v1_0;

import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Guillaume Lenoir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/cocktail.properties",
	scope = ServiceScope.PROTOTYPE, service = CocktailResource.class
)
public class CocktailResourceImpl extends BaseCocktailResourceImpl {
}