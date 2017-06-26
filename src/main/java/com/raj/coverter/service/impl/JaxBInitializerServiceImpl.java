/**
 * 
 */
package com.raj.coverter.service.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.raj.coverter.service.api.IJaxBInitializer;

/**
 * @author Rajendar Kumar
 *
 */
public class JaxBInitializerServiceImpl implements IJaxBInitializer {

	@SuppressWarnings("rawtypes")
	private Class clazz[];

	@Override
	public void setClassesToBeBound(@SuppressWarnings("rawtypes") Class... clazz) {
		this.clazz = clazz;
	}

	@Override
	public JAXBContext initJAXBContext() throws JAXBException {
		JAXBContext context  = JAXBContext.newInstance(clazz);
		return context;
	}

	

}
