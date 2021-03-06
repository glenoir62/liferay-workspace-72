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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import fr.gleo.meetup.liferay.model.Cocktail;
import fr.gleo.meetup.liferay.model.CocktailModel;
import fr.gleo.meetup.liferay.model.CocktailSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Cocktail service. Represents a row in the &quot;Cocktail_Cocktail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CocktailModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CocktailImpl}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CocktailImpl
 * @generated
 */
@JSON(strict = true)
public class CocktailModelImpl
	extends BaseModelImpl<Cocktail> implements CocktailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cocktail model instance should use the <code>Cocktail</code> interface instead.
	 */
	public static final String TABLE_NAME = "Cocktail_Cocktail";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"cocktailId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"image", Types.CLOB},
		{"description", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cocktailId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("image", Types.CLOB);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Cocktail_Cocktail (uuid_ VARCHAR(75) null,cocktailId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,image TEXT null,description TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table Cocktail_Cocktail";

	public static final String ORDER_BY_JPQL = " ORDER BY cocktail.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Cocktail_Cocktail.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long NAME_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Cocktail toModel(CocktailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Cocktail model = new CocktailImpl();

		model.setUuid(soapModel.getUuid());
		model.setCocktailId(soapModel.getCocktailId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setImage(soapModel.getImage());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Cocktail> toModels(CocktailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Cocktail> models = new ArrayList<Cocktail>(soapModels.length);

		for (CocktailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CocktailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cocktailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCocktailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cocktailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Cocktail.class;
	}

	@Override
	public String getModelClassName() {
		return Cocktail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Cocktail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Cocktail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cocktail, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Cocktail)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Cocktail, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Cocktail, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Cocktail)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Cocktail, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Cocktail, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Cocktail>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Cocktail.class.getClassLoader(), Cocktail.class,
			ModelWrapper.class);

		try {
			Constructor<Cocktail> constructor =
				(Constructor<Cocktail>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Cocktail, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Cocktail, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Cocktail, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Cocktail, Object>>();
		Map<String, BiConsumer<Cocktail, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Cocktail, ?>>();

		attributeGetterFunctions.put("uuid", Cocktail::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Cocktail, String>)Cocktail::setUuid);
		attributeGetterFunctions.put("cocktailId", Cocktail::getCocktailId);
		attributeSetterBiConsumers.put(
			"cocktailId", (BiConsumer<Cocktail, Long>)Cocktail::setCocktailId);
		attributeGetterFunctions.put("groupId", Cocktail::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Cocktail, Long>)Cocktail::setGroupId);
		attributeGetterFunctions.put("companyId", Cocktail::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Cocktail, Long>)Cocktail::setCompanyId);
		attributeGetterFunctions.put("userId", Cocktail::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Cocktail, Long>)Cocktail::setUserId);
		attributeGetterFunctions.put("userName", Cocktail::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Cocktail, String>)Cocktail::setUserName);
		attributeGetterFunctions.put("createDate", Cocktail::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Cocktail, Date>)Cocktail::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Cocktail::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Cocktail, Date>)Cocktail::setModifiedDate);
		attributeGetterFunctions.put("name", Cocktail::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Cocktail, String>)Cocktail::setName);
		attributeGetterFunctions.put("image", Cocktail::getImage);
		attributeSetterBiConsumers.put(
			"image", (BiConsumer<Cocktail, String>)Cocktail::setImage);
		attributeGetterFunctions.put("description", Cocktail::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Cocktail, String>)Cocktail::setDescription);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCocktailId() {
		return _cocktailId;
	}

	@Override
	public void setCocktailId(long cocktailId) {
		_cocktailId = cocktailId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	@Override
	public String getImage() {
		if (_image == null) {
			return "";
		}
		else {
			return _image;
		}
	}

	@Override
	public void setImage(String image) {
		_image = image;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Cocktail.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Cocktail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Cocktail toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Cocktail>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CocktailImpl cocktailImpl = new CocktailImpl();

		cocktailImpl.setUuid(getUuid());
		cocktailImpl.setCocktailId(getCocktailId());
		cocktailImpl.setGroupId(getGroupId());
		cocktailImpl.setCompanyId(getCompanyId());
		cocktailImpl.setUserId(getUserId());
		cocktailImpl.setUserName(getUserName());
		cocktailImpl.setCreateDate(getCreateDate());
		cocktailImpl.setModifiedDate(getModifiedDate());
		cocktailImpl.setName(getName());
		cocktailImpl.setImage(getImage());
		cocktailImpl.setDescription(getDescription());

		cocktailImpl.resetOriginalValues();

		return cocktailImpl;
	}

	@Override
	public int compareTo(Cocktail cocktail) {
		int value = 0;

		value = getName().compareTo(cocktail.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cocktail)) {
			return false;
		}

		Cocktail cocktail = (Cocktail)obj;

		long primaryKey = cocktail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CocktailModelImpl cocktailModelImpl = this;

		cocktailModelImpl._originalUuid = cocktailModelImpl._uuid;

		cocktailModelImpl._originalGroupId = cocktailModelImpl._groupId;

		cocktailModelImpl._setOriginalGroupId = false;

		cocktailModelImpl._originalCompanyId = cocktailModelImpl._companyId;

		cocktailModelImpl._setOriginalCompanyId = false;

		cocktailModelImpl._setModifiedDate = false;

		cocktailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Cocktail> toCacheModel() {
		CocktailCacheModel cocktailCacheModel = new CocktailCacheModel();

		cocktailCacheModel.uuid = getUuid();

		String uuid = cocktailCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cocktailCacheModel.uuid = null;
		}

		cocktailCacheModel.cocktailId = getCocktailId();

		cocktailCacheModel.groupId = getGroupId();

		cocktailCacheModel.companyId = getCompanyId();

		cocktailCacheModel.userId = getUserId();

		cocktailCacheModel.userName = getUserName();

		String userName = cocktailCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cocktailCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cocktailCacheModel.createDate = createDate.getTime();
		}
		else {
			cocktailCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cocktailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cocktailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cocktailCacheModel.name = getName();

		String name = cocktailCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cocktailCacheModel.name = null;
		}

		cocktailCacheModel.image = getImage();

		String image = cocktailCacheModel.image;

		if ((image != null) && (image.length() == 0)) {
			cocktailCacheModel.image = null;
		}

		cocktailCacheModel.description = getDescription();

		String description = cocktailCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cocktailCacheModel.description = null;
		}

		return cocktailCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Cocktail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Cocktail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cocktail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Cocktail)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Cocktail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Cocktail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Cocktail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Cocktail)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Cocktail>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _cocktailId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _image;
	private String _description;
	private long _columnBitmask;
	private Cocktail _escapedModel;

}