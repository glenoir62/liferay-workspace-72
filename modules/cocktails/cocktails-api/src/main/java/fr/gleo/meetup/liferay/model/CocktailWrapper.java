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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cocktail}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see Cocktail
 * @generated
 */
public class CocktailWrapper
	extends BaseModelWrapper<Cocktail>
	implements Cocktail, ModelWrapper<Cocktail> {

	public CocktailWrapper(Cocktail cocktail) {
		super(cocktail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cocktailId", getCocktailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("image", getImage());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cocktailId = (Long)attributes.get("cocktailId");

		if (cocktailId != null) {
			setCocktailId(cocktailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the cocktail ID of this cocktail.
	 *
	 * @return the cocktail ID of this cocktail
	 */
	@Override
	public long getCocktailId() {
		return model.getCocktailId();
	}

	/**
	 * Returns the company ID of this cocktail.
	 *
	 * @return the company ID of this cocktail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this cocktail.
	 *
	 * @return the create date of this cocktail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this cocktail.
	 *
	 * @return the description of this cocktail
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this cocktail.
	 *
	 * @return the group ID of this cocktail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image of this cocktail.
	 *
	 * @return the image of this cocktail
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the modified date of this cocktail.
	 *
	 * @return the modified date of this cocktail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this cocktail.
	 *
	 * @return the name of this cocktail
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cocktail.
	 *
	 * @return the primary key of this cocktail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this cocktail.
	 *
	 * @return the user ID of this cocktail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cocktail.
	 *
	 * @return the user name of this cocktail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cocktail.
	 *
	 * @return the user uuid of this cocktail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this cocktail.
	 *
	 * @return the uuid of this cocktail
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cocktail ID of this cocktail.
	 *
	 * @param cocktailId the cocktail ID of this cocktail
	 */
	@Override
	public void setCocktailId(long cocktailId) {
		model.setCocktailId(cocktailId);
	}

	/**
	 * Sets the company ID of this cocktail.
	 *
	 * @param companyId the company ID of this cocktail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cocktail.
	 *
	 * @param createDate the create date of this cocktail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this cocktail.
	 *
	 * @param description the description of this cocktail
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this cocktail.
	 *
	 * @param groupId the group ID of this cocktail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image of this cocktail.
	 *
	 * @param image the image of this cocktail
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the modified date of this cocktail.
	 *
	 * @param modifiedDate the modified date of this cocktail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this cocktail.
	 *
	 * @param name the name of this cocktail
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cocktail.
	 *
	 * @param primaryKey the primary key of this cocktail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this cocktail.
	 *
	 * @param userId the user ID of this cocktail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cocktail.
	 *
	 * @param userName the user name of this cocktail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cocktail.
	 *
	 * @param userUuid the user uuid of this cocktail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this cocktail.
	 *
	 * @param uuid the uuid of this cocktail
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CocktailWrapper wrap(Cocktail cocktail) {
		return new CocktailWrapper(cocktail);
	}

}