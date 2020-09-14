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

package fr.gleo.meetup.liferay.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import fr.gleo.meetup.liferay.model.Cocktail;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Cocktail. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Guillaume Lenoir
 * @see CocktailLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CocktailLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CocktailLocalServiceUtil} to access the cocktail local service. Add custom service methods to <code>fr.gleo.meetup.liferay.service.impl.CocktailLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the cocktail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Cocktail addCocktail(Cocktail cocktail);

	/**
	 * Creates a new cocktail with the primary key. Does not add the cocktail to the database.
	 *
	 * @param cocktailId the primary key for the new cocktail
	 * @return the new cocktail
	 */
	@Transactional(enabled = false)
	public Cocktail createCocktail(long cocktailId);

	/**
	 * Deletes the cocktail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Cocktail deleteCocktail(Cocktail cocktail);

	/**
	 * Deletes the cocktail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail that was removed
	 * @throws PortalException if a cocktail with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Cocktail deleteCocktail(long cocktailId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fr.gleo.meetup.liferay.model.impl.CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fr.gleo.meetup.liferay.model.impl.CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cocktail fetchCocktail(long cocktailId);

	/**
	 * Returns the cocktail matching the UUID and group.
	 *
	 * @param uuid the cocktail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cocktail fetchCocktailByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the cocktail with the primary key.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail
	 * @throws PortalException if a cocktail with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cocktail getCocktail(long cocktailId) throws PortalException;

	/**
	 * Returns the cocktail matching the UUID and group.
	 *
	 * @param uuid the cocktail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocktail
	 * @throws PortalException if a matching cocktail could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cocktail getCocktailByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the cocktails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fr.gleo.meetup.liferay.model.impl.CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @return the range of cocktails
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cocktail> getCocktails(int start, int end);

	/**
	 * Returns all the cocktails matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocktails
	 * @param companyId the primary key of the company
	 * @return the matching cocktails, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cocktail> getCocktailsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of cocktails matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocktails
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cocktails, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cocktail> getCocktailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocktail> orderByComparator);

	/**
	 * Returns the number of cocktails.
	 *
	 * @return the number of cocktails
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCocktailsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the cocktail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Cocktail updateCocktail(Cocktail cocktail);

}