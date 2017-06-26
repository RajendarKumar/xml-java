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
import com.raj.pojo.Customer;

/**
 * @author Rajendar Kumar
 *
 */
public class CustomerConverterServiceImpl implements IConverter<Customer>{

	private IJaxBInitializer jaxbContext;
	public CustomerConverterServiceImpl(IJaxBInitializer jaxbContext){
		this.jaxbContext=jaxbContext;
	}
	public Customer Unmarshall(String xml) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.initJAXBContext().createUnmarshaller();
		StringReader reader = new StringReader(xml);
		return (Customer) unmarshaller.unmarshal(reader);
	}

	@Override
	public String marshall(Customer customer) throws JAXBException, UnsupportedEncodingException {
		Marshaller marshaller = jaxbContext.initJAXBContext().createMarshaller();
		ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
		marshaller.marshal(customer,outputStream);
		return new String(outputStream.toByteArray(), System.getProperty("file.encoding"));
	}

}
