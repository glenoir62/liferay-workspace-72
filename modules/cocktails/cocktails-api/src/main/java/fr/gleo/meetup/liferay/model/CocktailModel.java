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

package fr.gleo.meetup.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Cocktail service. Represents a row in the &quot;Cocktail_Cocktail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>fr.gleo.meetup.liferay.model.impl.CocktailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>fr.gleo.meetup.liferay.model.impl.CocktailImpl</code>.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see Cocktail
 * @generated
 */
@ProviderType
public interface CocktailModel
	extends BaseModel<Cocktail>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cocktail model instance should use the {@link Cocktail} interface instead.
	 */

	/**
	 * Returns the primary key of this cocktail.
	 *
	 * @return the primary key of this cocktail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cocktail.
	 *
	 * @param primaryKey the primary key of this cocktail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this cocktail.
	 *
	 * @return the uuid of this cocktail
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this cocktail.
	 *
	 * @param uuid the uuid of this cocktail
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the cocktail ID of this cocktail.
	 *
	 * @return the cocktail ID of this cocktail
	 */
	public long getCocktailId();

	/**
	 * Sets the cocktail ID of this cocktail.
	 *
	 * @param cocktailId the cocktail ID of this cocktail
	 */
	public void setCocktailId(long cocktailId);

	/**
	 * Returns the group ID of this cocktail.
	 *
	 * @return the group ID of this cocktail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cocktail.
	 *
	 * @param groupId the group ID of this cocktail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cocktail.
	 *
	 * @return the company ID of this cocktail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cocktail.
	 *
	 * @param companyId the company ID of this cocktail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cocktail.
	 *
	 * @return the user ID of this cocktail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cocktail.
	 *
	 * @param userId the user ID of this cocktail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cocktail.
	 *
	 * @return the user uuid of this cocktail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cocktail.
	 *
	 * @param userUuid the user uuid of this cocktail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cocktail.
	 *
	 * @return the user name of this cocktail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cocktail.
	 *
	 * @param userName the user name of this cocktail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cocktail.
	 *
	 * @return the create date of this cocktail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cocktail.
	 *
	 * @param createDate the create date of this cocktail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cocktail.
	 *
	 * @return the modified date of this cocktail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cocktail.
	 *
	 * @param modifiedDate the modified date of this cocktail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this cocktail.
	 *
	 * @return the name of this cocktail
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this cocktail.
	 *
	 * @param name the name of this cocktail
	 */
	public void setName(String name);

	/**
	 * Returns the image of this cocktail.
	 *
	 * @return the image of this cocktail
	 */
	@AutoEscape
	public String getImage();

	/**
	 * Sets the image of this cocktail.
	 *
	 * @param image the image of this cocktail
	 */
	public void setImage(String image);

	/**
	 * Returns the description of this cocktail.
	 *
	 * @return the description of this cocktail
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this cocktail.
	 *
	 * @param description the description of this cocktail
	 */
	public void setDescription(String description);

}