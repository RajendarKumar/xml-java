/**
 * 
 */
package com.raj.coverter.service.api;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

/**
 * @author Rajendar Kumar
 *
 */
public interface ICustomerConverter<T>{

	/**
	 * <p>Accepts valid xml and converts it back to java object.<p>
	 * @param xml
	 * @return T
	 * @throws JAXBException
	 */
	T Unmarshall(String xml) throws JAXBException;
	/**
	 * <p>Accepts object and converts back to xml.<p>
	 * @param t
	 * @return xml
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
	String marshall(T t) throws JAXBException, UnsupportedEncodingException;
}
