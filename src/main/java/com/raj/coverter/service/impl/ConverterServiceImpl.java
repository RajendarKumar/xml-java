/**
 * 
 */
package com.raj.coverter.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.raj.coverter.service.api.IConverter;
import com.raj.coverter.service.api.IJaxBInitializer;

/**
 * @author Rajendar Kumar
 *
 */
public class ConverterServiceImpl<T> implements IConverter<T>{

	private IJaxBInitializer jaxbContext;
	public ConverterServiceImpl(IJaxBInitializer jaxbContext){
		this.jaxbContext=jaxbContext;
	}
	@SuppressWarnings("unchecked")
	public T Unmarshall(String xml) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.initJAXBContext().createUnmarshaller();
		StringReader reader = new StringReader(xml);
		return (T) unmarshaller.unmarshal(reader);
	}

	@Override
	public String marshall(T customer) throws JAXBException, UnsupportedEncodingException {
		Marshaller marshaller = jaxbContext.initJAXBContext().createMarshaller();
		ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
		marshaller.marshal(customer,outputStream);
		return new String(outputStream.toByteArray(), System.getProperty("file.encoding"));
	}

}
