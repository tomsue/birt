
/*******************************************************************************
 * Copyright (c) 2013 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/
package org.eclipse.birt.report.data.oda.pojo.impl;

import org.eclipse.birt.report.data.oda.pojo.testutil.PojoQueryCreator;
import org.eclipse.datatools.connectivity.oda.IParameterMetaData;
import org.eclipse.datatools.connectivity.oda.OdaException;

import org.eclipse.birt.report.data.oda.pojo.api.Constants;
import org.eclipse.birt.report.data.oda.pojo.impl.Driver;
import org.eclipse.birt.report.data.oda.pojo.impl.Query;
import org.eclipse.birt.report.data.oda.pojo.querymodel.PojoQuery;
import org.eclipse.birt.report.data.oda.pojo.util.PojoQueryWriter;

import junit.framework.TestCase;


/**
 * 
 */

public class QueryTest extends TestCase
{

	@SuppressWarnings("nls")
	public void testGetParameterMetaData( ) throws OdaException
	{
		PojoQuery pq = PojoQueryCreator.createWithParameters( );
		Query q = new Query( null );
		q.prepare( PojoQueryWriter.write( pq ) );
		IParameterMetaData pmd = q.getParameterMetaData( );
		assertEquals( 2, pmd.getParameterCount( ) );
		assertEquals( "id", pmd.getParameterName( 1 ) );
		assertEquals( "sex", pmd.getParameterName( 2 ) );
		assertEquals( Driver.getNativeDataTypeCode( Constants.ODA_TYPE_Integer ), 
				pmd.getParameterType( 1 ) );
		assertEquals( Driver.getNativeDataTypeCode( Constants.ODA_TYPE_Boolean ), 
				pmd.getParameterType( 2 ) );

	}

}