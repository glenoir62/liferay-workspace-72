package fr.gleo.meetups.cocktails.portlet.portlet;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import fr.gleo.meetup.cocktail.client.api.CocktailService;
import fr.gleo.meetup.cocktail.client.model.PageCocktail;
import fr.gleo.meetups.cocktails.portlet.constants.CocktailsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * @author guillaumelenoir
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Cocktails",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CocktailsPortletKeys.COCKTAILS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CocktailsPortlet extends MVCPortlet {

	@Reference
	private CocktailService cocktailService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PageCocktail pageCocktail = cocktailService.getSiteCocktailsPage(themeDisplay.getSiteGroupId(), null,null,null,null,null);

		if(Validator.isNotNull(pageCocktail) && pageCocktail.getItems().size() > 0) {
			renderRequest.setAttribute("pageCocktails" , pageCocktail.getItems());
		}

		super.doView(renderRequest, renderResponse);
	}
}