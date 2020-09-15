package fr.gleo.liferay.meetup.ws.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import fr.gleo.liferay.meetup.ws.dto.v1_0.Cocktail;
import fr.gleo.liferay.meetup.ws.resource.v1_0.CocktailResource;

import fr.gleo.meetup.liferay.service.CocktailLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

/**
 * @author Guillaume Lenoir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/cocktail.properties",
	scope = ServiceScope.PROTOTYPE, service = CocktailResource.class
)
public class CocktailResourceImpl extends BaseCocktailResourceImpl {

	private final static Log LOGGER = LogFactoryUtil.getLog(CocktailResourceImpl.class);

	@Reference
	private CocktailLocalService cocktailLocalService;

	@Override
	public void deleteCocktail(@NotNull Long cocktailId) throws Exception {
		LOGGER.info("deleteCocktail");
		super.deleteCocktail(cocktailId);
	}

	@Override
	public Cocktail getCocktail(@NotNull Long cocktailId) throws Exception {
		LOGGER.info("getCocktail");

		Optional<fr.gleo.meetup.liferay.model.Cocktail> optionalCocktail = Optional.ofNullable(cocktailLocalService.getCocktail(cocktailId));

		Cocktail cocktailDTO = new Cocktail();
		optionalCocktail.ifPresent(cocktail -> {
			cocktailDTO.setCreateDate(cocktail.getCreateDate());
			cocktailDTO.setDescription(cocktail.getDescription());
			cocktailDTO.setId(cocktail.getCocktailId());
		});

		return cocktailDTO;
	}

	@Override
	public Cocktail putCocktail(@NotNull Long cocktailId, Cocktail cocktail) throws Exception {
		LOGGER.info("putCocktail");
		
		return super.putCocktail(cocktailId, cocktail);
	}

	@Override
	public Page<Cocktail> getSiteCocktailsPage(@NotNull Long siteId, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		LOGGER.info("getSiteCocktailsPage");
		return super.getSiteCocktailsPage(siteId, search, filter, pagination, sorts);
	}
}