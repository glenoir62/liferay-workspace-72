package fr.gleo.liferay.meetup.ws.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
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
import java.util.List;
import java.util.stream.Collectors;

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
	private CompanyService companyService;

	@Reference
	private CocktailLocalService cocktailLocalService;

	@Override
	public void deleteCocktail(@NotNull Long cocktailId) throws Exception {
		LOGGER.info("deleteCocktail");
		cocktailLocalService.deleteCocktail(cocktailId);

		super.deleteCocktail(cocktailId);
	}

	@Override
	public Cocktail getCocktail(@NotNull Long cocktailId) throws Exception {
		LOGGER.info("Get Cocktail test = " + cocktailId);
		return _toCocktailDTO(cocktailLocalService.getCocktail(cocktailId));
	}

	@Override
	public Cocktail postSiteCocktail(@NotNull Long siteId, Cocktail cocktail) throws Exception {
		LOGGER.info("postSiteCocktail ");


		long companyId = PortalUtil.getDefaultCompanyId();
		Company company = companyService.getCompanyById(companyId);
		long userId = company.getDefaultUser().getUserId();
		long groupId = siteId;

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);

		return _toCocktailDTO(cocktailLocalService.addCocktail(groupId, cocktail.getName(), cocktail.getDescription(), cocktail.getImage(), serviceContext));
	}

	@Override
	public Cocktail putCocktail(@NotNull Long cocktailId, Cocktail cocktail) throws Exception {
		LOGGER.info("putCocktail " + cocktail);

		return _toCocktailDTO(cocktailLocalService.updateCocktail(cocktailId, cocktail.getName(), cocktail.getDescription(), cocktail.getImage(), null));
	}

	@Override
	public Page<Cocktail> getSiteCocktailsPage(@NotNull Long siteId, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		LOGGER.info("Get Site Cocktails Page = " + siteId);

		List<Cocktail> cocktails = cocktailLocalService.getCocktailsByGroupId(siteId)
				.stream()
				.map(cocktail -> _toCocktailDTO(cocktail))
				.collect(Collectors.toList());

		return Page.of(cocktails);
	}

	private Cocktail _toCocktailDTO(fr.gleo.meetup.liferay.model.Cocktail cocktail) {

		if (cocktail == null) {
			return null;
		}

		return new Cocktail() {
			{
				name = cocktail.getName();
				createDate = cocktail.getCreateDate();
				image = cocktail.getImage();
				id = cocktail.getCocktailId();
				description = cocktail.getDescription();
			}
		};
	}
}