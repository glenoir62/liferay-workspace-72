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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Cocktail service. Represents a row in the &quot;Cocktail_Cocktail&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see CocktailModel
 * @generated
 */
@ImplementationClassName("fr.gleo.meetup.liferay.model.impl.CocktailImpl")
@ProviderType
public interface Cocktail extends CocktailModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>fr.gleo.meetup.liferay.model.impl.CocktailImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Cocktail, Long> COCKTAIL_ID_ACCESSOR =
		new Accessor<Cocktail, Long>() {

			@Override
			public Long get(Cocktail cocktail) {
				return cocktail.getCocktailId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Cocktail> getTypeClass() {
				return Cocktail.class;
			}

		};

}