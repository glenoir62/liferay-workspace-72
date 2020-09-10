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

package fr.gleo.meetup.liferay.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fr.gleo.meetup.liferay.model.Cocktail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cocktail in entity cache.
 *
 * @author Guillaume Lenoir
 * @generated
 */
public class CocktailCacheModel
	implements CacheModel<Cocktail>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CocktailCacheModel)) {
			return false;
		}

		CocktailCacheModel cocktailCacheModel = (CocktailCacheModel)obj;

		if (cocktailId == cocktailCacheModel.cocktailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cocktailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cocktailId=");
		sb.append(cocktailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", image=");
		sb.append(image);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cocktail toEntityModel() {
		CocktailImpl cocktailImpl = new CocktailImpl();

		if (uuid == null) {
			cocktailImpl.setUuid("");
		}
		else {
			cocktailImpl.setUuid(uuid);
		}

		cocktailImpl.setCocktailId(cocktailId);
		cocktailImpl.setGroupId(groupId);
		cocktailImpl.setCompanyId(companyId);
		cocktailImpl.setUserId(userId);

		if (userName == null) {
			cocktailImpl.setUserName("");
		}
		else {
			cocktailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cocktailImpl.setCreateDate(null);
		}
		else {
			cocktailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cocktailImpl.setModifiedDate(null);
		}
		else {
			cocktailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			cocktailImpl.setName("");
		}
		else {
			cocktailImpl.setName(name);
		}

		if (image == null) {
			cocktailImpl.setImage("");
		}
		else {
			cocktailImpl.setImage(image);
		}

		if (description == null) {
			cocktailImpl.setDescription("");
		}
		else {
			cocktailImpl.setDescription(description);
		}

		cocktailImpl.resetOriginalValues();

		return cocktailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		cocktailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		image = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(cocktailId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long cocktailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String image;
	public String description;

}