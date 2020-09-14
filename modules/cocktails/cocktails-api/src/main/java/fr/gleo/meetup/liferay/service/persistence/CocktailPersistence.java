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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fr.gleo.meetup.liferay.exception.NoSuchCocktailException;
import fr.gleo.meetup.liferay.model.Cocktail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cocktail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CocktailUtil
 * @generated
 */
@ProviderType
public interface CocktailPersistence extends BasePersistence<Cocktail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CocktailUtil} to access the cocktail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cocktails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocktails
	 */
	public java.util.List<Cocktail> findByUuid(String uuid);

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
	public java.util.List<Cocktail> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Cocktail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

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
	public java.util.List<Cocktail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

	/**
	 * Returns the cocktails before and after the current cocktail in the ordered set where uuid = &#63;.
	 *
	 * @param cocktailId the primary key of the current cocktail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public Cocktail[] findByUuid_PrevAndNext(
			long cocktailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Removes all the cocktails where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cocktails where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocktails
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocktailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByUUID_G(String uuid, long groupId)
		throws NoSuchCocktailException;

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cocktail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the cocktail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocktail that was removed
	 */
	public Cocktail removeByUUID_G(String uuid, long groupId)
		throws NoSuchCocktailException;

	/**
	 * Returns the number of cocktails where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocktails
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocktails
	 */
	public java.util.List<Cocktail> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

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
	public java.util.List<Cocktail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the first cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the last cocktail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

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
	public Cocktail[] findByUuid_C_PrevAndNext(
			long cocktailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Removes all the cocktails where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cocktails where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocktails
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cocktails where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching cocktails
	 */
	public java.util.List<Cocktail> findByGroupId(long groupId);

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
	public java.util.List<Cocktail> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Cocktail> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

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
	public java.util.List<Cocktail> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the first cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

	/**
	 * Returns the last cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail
	 * @throws NoSuchCocktailException if a matching cocktail could not be found
	 */
	public Cocktail findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Returns the last cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocktail, or <code>null</code> if a matching cocktail could not be found
	 */
	public Cocktail fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

	/**
	 * Returns the cocktails before and after the current cocktail in the ordered set where groupId = &#63;.
	 *
	 * @param cocktailId the primary key of the current cocktail
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public Cocktail[] findByGroupId_PrevAndNext(
			long cocktailId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
				orderByComparator)
		throws NoSuchCocktailException;

	/**
	 * Removes all the cocktails where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of cocktails where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching cocktails
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the cocktail in the entity cache if it is enabled.
	 *
	 * @param cocktail the cocktail
	 */
	public void cacheResult(Cocktail cocktail);

	/**
	 * Caches the cocktails in the entity cache if it is enabled.
	 *
	 * @param cocktails the cocktails
	 */
	public void cacheResult(java.util.List<Cocktail> cocktails);

	/**
	 * Creates a new cocktail with the primary key. Does not add the cocktail to the database.
	 *
	 * @param cocktailId the primary key for the new cocktail
	 * @return the new cocktail
	 */
	public Cocktail create(long cocktailId);

	/**
	 * Removes the cocktail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail that was removed
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public Cocktail remove(long cocktailId) throws NoSuchCocktailException;

	public Cocktail updateImpl(Cocktail cocktail);

	/**
	 * Returns the cocktail with the primary key or throws a <code>NoSuchCocktailException</code> if it could not be found.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail
	 * @throws NoSuchCocktailException if a cocktail with the primary key could not be found
	 */
	public Cocktail findByPrimaryKey(long cocktailId)
		throws NoSuchCocktailException;

	/**
	 * Returns the cocktail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocktailId the primary key of the cocktail
	 * @return the cocktail, or <code>null</code> if a cocktail with the primary key could not be found
	 */
	public Cocktail fetchByPrimaryKey(long cocktailId);

	/**
	 * Returns all the cocktails.
	 *
	 * @return the cocktails
	 */
	public java.util.List<Cocktail> findAll();

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
	public java.util.List<Cocktail> findAll(int start, int end);

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
	public java.util.List<Cocktail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator);

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
	public java.util.List<Cocktail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocktail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cocktails from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cocktails.
	 *
	 * @return the number of cocktails
	 */
	public int countAll();

}