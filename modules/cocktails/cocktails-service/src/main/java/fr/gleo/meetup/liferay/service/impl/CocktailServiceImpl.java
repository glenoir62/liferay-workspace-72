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

import fr.gleo.meetup.liferay.service.base.CocktailServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the cocktail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>fr.gleo.meetup.liferay.service.CocktailService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CocktailServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=cocktail",
		"json.web.service.context.path=Cocktail"
	},
	service = AopService.class
)
public class CocktailServiceImpl extends CocktailServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>fr.gleo.meetup.liferay.service.CocktailServiceUtil</code> to access the cocktail remote service.
	 */
}