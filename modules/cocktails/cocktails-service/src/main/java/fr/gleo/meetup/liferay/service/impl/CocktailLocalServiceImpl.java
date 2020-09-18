/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package fr.gleo.meetup.liferay.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import fr.gleo.meetup.liferay.model.Cocktail;
import fr.gleo.meetup.liferay.service.base.CocktailLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * The implementation of the cocktail local service.Oœ
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>fr.gleo.meetup.liferay.service.CocktailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CocktailLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=fr.gleo.meetup.liferay.model.Cocktail",
	service = AopService.class
)
public class CocktailLocalServiceImpl extends CocktailLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>fr.gleo.meetup.liferay.service.CocktailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>fr.gleo.meetup.liferay.service.CocktailLocalServiceUtil</code>.
	 */

	/**
	 * Adds an cocktail.
	 *
	 * @param groupId
	 * @param name
	 * @param description
	 * @param image
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
			type = IndexableType.REINDEX
	)
	public Cocktail addCocktail(
			long groupId, String name, String description, String image, ServiceContext serviceContext)
			throws PortalException {

		// Validate cocktail parameters.

		// CocktailValidator.validate(titleMap, description);

		// Get group and same time validate that it exists.

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the cocktail.

		long cocktailId =
				counterLocalService.increment(Cocktail.class.getName());

		// Create cocktail.

		Cocktail cocktail = createCocktail(cocktailId);

		// Fill the cocktail

		cocktail.setCompanyId(group.getCompanyId());
		cocktail.setGroupId(groupId);
		cocktail.setUserId(userId);
		cocktail.setName(name);
		cocktail.setDescription(description);
		cocktail.setUserName(user.getScreenName());

		cocktail.setCreateDate(serviceContext.getCreateDate(new Date()));
		cocktail.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		// Persist cocktail.

		cocktail = super.addCocktail(cocktail);

		// Add permission resources.

		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;

/*		resourceLocalService.addResources(
				group.getCompanyId(), groupId, userId, Cocktail.class.getName(),
				cocktail.getCocktailId(), portletActions, addGroupPermissions,
				addGuestPermissions);*/


		// Update asset.

		//updateAsset(cocktail, serviceContext);

		// Start workflow instance and return the cocktail.

		//return startWorkflowInstance(userId, cocktail, serviceContext);


		return cocktail;

	}

	/**
	 *
	 * @param groupId
	 * @return
	 */
	public java.util.List<Cocktail>  getCocktailsByGroupId (
			long groupId) {
		return  cocktailPersistence.findByGroupId(groupId);
	}




/*	private void updateAsset(
			Cocktail cocktail, ServiceContext serviceContext)
			throws PortalException {

		assetEntryLocalService.updateEntry(
				serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				cocktail.getCreateDate(), cocktail.getModifiedDate(),
				Cocktail.class.getName(), cocktail.getCocktailId(),
				cocktail.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				cocktail.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML,
				cocktail.getTitle(serviceContext.getLocale()),
				cocktail.getDescription(), null, null, null, 0, 0,
				serviceContext.getAssetPriority());
	}*/


/*	protected Cocktail startWorkflowInstance(
			long userId, Cocktail cocktail, ServiceContext serviceContext)
			throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();

		String userPortraitURL = "";
		String userURL = "";

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL =
					user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
				WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
				cocktail.getCompanyId(), cocktail.getGroupId(), userId,
				Cocktail.class.getName(), cocktail.getCocktailId(),
				cocktail, serviceContext, workflowContext);
	}*/

/*	public Cocktail updateStatus(
			long userId, long cocktailId, int status,
			ServiceContext serviceContext)
			throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Cocktail cocktail = getCocktail(cocktailId);

		cocktail.setStatus(status);
		cocktail.setStatusByUserId(userId);
		cocktail.setStatusByUserName(user.getFullName());
		cocktail.setStatusDate(new Date());

		cocktailPersistence.update(cocktail);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(
					Cocktail.class.getName(), cocktailId, true);

		}
		else {

			assetEntryLocalService.updateVisible(
					Cocktail.class.getName(), cocktailId, false);
		}

		return cocktail;
	}*/

	/**
	 * Updates cocktail.
	 *
	 * @param cocktailId
	 * @param name
	 * @param description
	 * @param image
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
			type = IndexableType.REINDEX
	)
	public Cocktail updateCocktail(
			long cocktailId, String name, String description, String image, ServiceContext serviceContext)
			throws PortalException {

		// Validate cocktail values
		//CocktailValidator.validate(titleMap, description);

		// Get Cocktail

		Cocktail cocktail = getCocktail(cocktailId);

		// Update the changes to cocktail

		cocktail.setModifiedDate(new Date());
		cocktail.setName(name);
		cocktail.setDescription(description);
		cocktail.setImage(image);
		cocktail = super.updateCocktail(cocktail);

		//updateAsset(cocktail, serviceContext);

		return cocktail;
	}

	@Indexable(
			type = IndexableType.DELETE
	)
	public Cocktail deleteCocktail(long cocktailId)
			throws PortalException {

		Cocktail cocktail = getCocktail(cocktailId);

		return deleteCocktail(cocktail);
	}

	/**
	 * Deletes cocktail.
	 *
	 * @param cocktail
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
			type = IndexableType.DELETE
	)
	public Cocktail deleteCocktail(Cocktail cocktail) {

		/*
		// Delete permission resources.
		resourceLocalService.deleteResource(
				cocktail, ResourceConstants.SCOPE_INDIVIDUAL);

		// Delete asset data.
		assetEntryLocalService.deleteEntry(
				Cocktail.class.getName(), cocktail.getCocktailId());

		// Delete workflow instance.
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				cocktail.getCompanyId(), cocktail.getGroupId(),
				Cocktail.class.getName(), cocktail.getCocktailId());
		*/

		// Delete the Cocktail
		return super.deleteCocktail(cocktail);
	}

	public int getCocktailsCountByGroupId(long groupId) {

		return cocktailPersistence.countByGroupId(groupId);
	}

	/**
	 * Adds an cocktail (silenced)
	 *
	 * This is an example how to "silence" generated method.
	 *
	 * @param cocktail
	 * @return
	 */
	@Override
	public Cocktail addCocktail(Cocktail cocktail) {

		throw new UnsupportedOperationException(
				"please use instead addCocktail(Cocktail, ServiceContext)");
	}
}