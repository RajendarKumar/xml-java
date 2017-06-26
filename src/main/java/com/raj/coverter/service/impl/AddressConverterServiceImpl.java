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
import com.raj.pojo.Address;

/**
 * @author Rajendar Kumar
 *
 */
public class AddressConverterServiceImpl implements IConverter<Address>{

	private IJaxBInitializer jaxbContext;
	public AddressConverterServiceImpl(IJaxBInitializer jaxbContext){
		this.jaxbContext=jaxbContext;
	}
	public Address Unmarshall(String xml) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.initJAXBContext().createUnmarshaller();
		StringReader reader = new StringReader(xml);
		return (Address) unmarshaller.unmarshal(reader);
	}

	@Override
	public String marshall(Address address) throws JAXBException, UnsupportedEncodingException {
		Marshaller marshaller = jaxbContext.initJAXBContext().createMarshaller();
		ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
		marshaller.marshal(address,outputStream);
		return new String(outputStream.toByteArray(), System.getProperty("file.encoding"));
	}

}
