package fr.gleo.liferay.meetup.ws.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/cocktails",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=Liferay.Cocktails"
	},
	service = Application.class
)
@Generated("")
public class CocktailsApplication extends Application {
}