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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Cocktail. This utility wraps
 * <code>fr.gleo.meetup.liferay.service.impl.CocktailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Guillaume Lenoir
 * @see CocktailLocalService
 * @generated
 */
public class CocktailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>fr.gleo.meetup.liferay.service.impl.CocktailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cocktail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was added
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail addCocktail(
		fr.gleo.meetup.liferay.model.Cocktail cocktail) {

		return getService().addCocktail(cocktail);
	}

	/**
	 * Creates a new cocktail with the primary key. Does not add the cocktail to the database.
	 *
	 * @param cocktailId the primary key for the new cocktail
	 * @return the new cocktail
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail createCocktail(
		long cocktailId) {

		return getService().createCocktail(cocktailId);
	}

	/**
	 * Deletes the cocktail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was removed
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail deleteCocktail(
		fr.gleo.meetup.liferay.model.Cocktail cocktail) {

		return getService().deleteCocktail(cocktail);
	}

	/**
	 * Deletes the cocktail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail that was removed
	 * @throws PortalException if a cocktail with the primary key could not be found
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail deleteCocktail(
			long cocktailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCocktail(cocktailId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static fr.gleo.meetup.liferay.model.Cocktail fetchCocktail(
		long cocktailId) {

		return getService().fetchCocktail(cocktailId);
	}

	/**
	 * Returns the cocktail matching the UUID and group.
	 *
	 * @param uuid the cocktail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail
		fetchCocktailByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCocktailByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cocktail with the primary key.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail
	 * @throws PortalException if a cocktail with the primary key could not be found
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail getCocktail(
			long cocktailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCocktail(cocktailId);
	}

	/**
	 * Returns the cocktail matching the UUID and group.
	 *
	 * @param uuid the cocktail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocktail
	 * @throws PortalException if a matching cocktail could not be found
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail
			getCocktailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCocktailByUuidAndGroupId(uuid, groupId);
	}

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
	public static java.util.List<fr.gleo.meetup.liferay.model.Cocktail>
		getCocktails(int start, int end) {

		return getService().getCocktails(start, end);
	}

	/**
	 * Returns all the cocktails matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocktails
	 * @param companyId the primary key of the company
	 * @return the matching cocktails, or an empty list if no matches were found
	 */
	public static java.util.List<fr.gleo.meetup.liferay.model.Cocktail>
		getCocktailsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCocktailsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<fr.gleo.meetup.liferay.model.Cocktail>
		getCocktailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.gleo.meetup.liferay.model.Cocktail> orderByComparator) {

		return getService().getCocktailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cocktails.
	 *
	 * @return the number of cocktails
	 */
	public static int getCocktailsCount() {
		return getService().getCocktailsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cocktail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cocktail the cocktail
	 * @return the cocktail that was updated
	 */
	public static fr.gleo.meetup.liferay.model.Cocktail updateCocktail(
		fr.gleo.meetup.liferay.model.Cocktail cocktail) {

		return getService().updateCocktail(cocktail);
	}

	public static CocktailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CocktailLocalService, CocktailLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CocktailLocalService.class);

		ServiceTracker<CocktailLocalService, CocktailLocalService>
			serviceTracker =
				new ServiceTracker<CocktailLocalService, CocktailLocalService>(
					bundle.getBundleContext(), CocktailLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}