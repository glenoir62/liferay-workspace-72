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

package fr.gleo.meetup.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fr.gleo.meetup.liferay.model.Cocktail;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cocktail service. This utility wraps <code>fr.gleo.meetup.liferay.service.persistence.impl.CocktailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CocktailPersistence
 * @generated
 */
public class CocktailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Cocktail cocktail) {
		getPersistence().clearCache(cocktail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Cocktail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cocktail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cocktail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cocktail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cocktail update(Cocktail cocktail) {
		return getPersistence().update(cocktail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cocktail update(
		Cocktail cocktail, ServiceContext serviceContext) {

		return getPersistence().update(cocktail, serviceContext);
	}

	/**
	 * Returns all the cocktails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocktails
	 */
	public static List<Cocktail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cocktails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @return the range of matching cocktails
	 */
	public static List<Cocktail> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cocktails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocktails where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocktail> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByUuid_First(
			String uuid, OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUuid_First(
		String uuid, OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByUuid_Last(
			String uuid, OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUuid_Last(
		String uuid, OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cocktails before and after the current cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param cocktailId the primary key of the current cocktail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public static Cocktail[] findByUuid_PrevAndNext(
			long cocktailId, String uuid,
			OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_PrevAndNext(
			cocktailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cocktails where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cocktails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocktails
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocktailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByUUID_G(String uuid, long groupId)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cocktail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocktail that was removed
	 */
	public static Cocktail removeByUUID_G(String uuid, long groupId)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cocktails where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocktails
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocktails
	 */
	public static List<Cocktail> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @return the range of matching cocktails
	 */
	public static List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocktail> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cocktails before and after the current cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cocktailId the primary key of the current cocktail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public static Cocktail[] findByUuid_C_PrevAndNext(
			long cocktailId, String uuid, long companyId,
			OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cocktailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cocktails where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocktails
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cocktails where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching cocktails
	 */
	public static List<Cocktail> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the cocktails where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @return the range of matching cocktails
	 */
	public static List<Cocktail> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocktails where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocktails where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocktails
	 */
	public static List<Cocktail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Cocktail> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByGroupId_First(
			long groupId, OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByGroupId_First(
		long groupId, OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public static Cocktail findByGroupId_Last(
			long groupId, OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public static Cocktail fetchByGroupId_Last(
		long groupId, OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the cocktails before and after the current cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param cocktailId the primary key of the current cocktail
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public static Cocktail[] findByGroupId_PrevAndNext(
			long cocktailId, long groupId,
			OrderByComparator<Cocktail> orderByComparator)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByGroupId_PrevAndNext(
			cocktailId, groupId, orderByComparator);
	}

	/**
	 * Removes all the cocktails where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of cocktails where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching cocktails
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the cocktail in the entity cache if it is enabled.
	 *
	 * @param cocktail the cocktail
	 */
	public static void cacheResult(Cocktail cocktail) {
		getPersistence().cacheResult(cocktail);
	}

	/**
	 * Caches the cocktails in the entity cache if it is enabled.
	 *
	 * @param cocktails the cocktails
	 */
	public static void cacheResult(List<Cocktail> cocktails) {
		getPersistence().cacheResult(cocktails);
	}

	/**
	 * Creates a new cocktail with the primary key. Does not add the cocktail to the database.
	 *
	 * @param cocktailId the primary key for the new cocktail
	 * @return the new cocktail
	 */
	public static Cocktail create(long cocktailId) {
		return getPersistence().create(cocktailId);
	}

	/**
	 * Removes the cocktail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail that was removed
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public static Cocktail remove(long cocktailId)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().remove(cocktailId);
	}

	public static Cocktail updateImpl(Cocktail cocktail) {
		return getPersistence().updateImpl(cocktail);
	}

	/**
	 * Returns the cocktail with the primary key or throws a <code>NoSuchCocktailException</code> if it could not be found.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public static Cocktail findByPrimaryKey(long cocktailId)
		throws fr.gleo.meetup.liferay.exception.NoSuchCocktailException {

		return getPersistence().findByPrimaryKey(cocktailId);
	}

	/**
	 * Returns the cocktail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail, or <code>null</code> if a cocktail with the primary key could not be found
	 */
	public static Cocktail fetchByPrimaryKey(long cocktailId) {
		return getPersistence().fetchByPrimaryKey(cocktailId);
	}

	/**
	 * Returns all the cocktails.
	 *
	 * @return the cocktails
	 */
	public static List<Cocktail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cocktails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @return the range of cocktails
	 */
	public static List<Cocktail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cocktails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cocktails
	 */
	public static List<Cocktail> findAll(
		int start, int end, OrderByComparator<Cocktail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocktails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocktailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocktails
	 * @param end the upper bound of the range of cocktails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cocktails
	 */
	public static List<Cocktail> findAll(
		int start, int end, OrderByComparator<Cocktail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cocktails from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cocktails.
	 *
	 * @return the number of cocktails
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CocktailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CocktailPersistence, CocktailPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CocktailPersistence.class);

		ServiceTracker<CocktailPersistence, CocktailPersistence>
			serviceTracker =
				new ServiceTracker<CocktailPersistence, CocktailPersistence>(
					bundle.getBundleContext(), CocktailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}