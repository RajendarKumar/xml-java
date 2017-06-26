package com.raj.coverter.service.impl;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.raj.coverter.service.api.IJaxBInitializer;
import com.raj.pojo.Address;
import com.raj.pojo.Customer;

public class CustomerConverterServiceImplTest {
	private static String xml =  null;
	private static String xmlDiffFromObj =  null;
	private static String invalidXml =  null;
	private static CustomerConverterServiceImpl serviceImpl;
	@BeforeClass
	public static void setUp() throws JAXBException{
		IJaxBInitializer jaxbContext = new JaxBInitializerServiceImpl();
		jaxbContext.setClassesToBeBound(Customer.class);
		serviceImpl = new CustomerConverterServiceImpl(jaxbContext);
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><custNum>1234</custNum><custName>Rajendar Kumar</custName><parentNum>456</parentNum><address><pNum>123, 2nd floor</pNum><cityName>New Delhi</cityName><cityCode>ABC</cityCode></address></customer>";
		xmlDiffFromObj = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><custNum>12345</custNum><custName>Rajendar Kumar</custName><parentNum>456</parentNum><address><pNum>123, 2nd floor</pNum><cityName>New Delhi</cityName><cityCode>ABC</cityCode></address></customer>";
		//</custNum> missing
		invalidXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><custNum>1234<custName>Rajendar Kumar</custName><parentNum>456</parentNum><address><pNum>123, 2nd floor</pNum><cityName>New Delhi</cityName><cityCode>ABC</cityCode></address></customer>";
	}
	@Test
	public void testUnmarshallerXmlSameValues() throws JAXBException {
		Customer customer = createObject();
		Customer cust = serviceImpl.Unmarshall(xml);
		Assert.assertEquals(customer, cust);
	}
	@Test
	public void testUnmarshallerXmlDiffValues() throws JAXBException {
		Customer customer = createObject();
		Customer cust = serviceImpl.Unmarshall(xmlDiffFromObj);
		Assert.assertNotEquals(customer, cust);
	}
	@Test(expected=JAXBException.class)
	public void testUnmarshallerXmlInvalid() throws JAXBException {
		serviceImpl.Unmarshall(invalidXml);
	}
	private Customer createObject(){
		Customer customer = new Customer();
		Address address = new Address();
		address.setCityCode("ABC");
		address.setCityName("New Delhi");
		address.setpNum("123, 2nd floor");
		customer.setCustName("Rajendar Kumar");
		customer.setCustNum("1234");
		customer.setParentNum("456");
		customer.setAddress(address);
		return customer;
	}
	@Test
	public void testMarshallerReturnNotNull() throws UnsupportedEncodingException, JAXBException{
		Customer customer = createObject();
		String cust=serviceImpl.marshall(customer);
		Assert.assertNotNull(cust);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testMarshallerNullCustomer() throws UnsupportedEncodingException, JAXBException{
		String cust=serviceImpl.marshall(null);
		Assert.assertNotNull(cust);
	}
	@Test
	public void testMarshallerValidConversion() throws UnsupportedEncodingException, JAXBException{
		Customer customer = createObject();
		Customer cust = serviceImpl.Unmarshall(serviceImpl.marshall(customer));
		Assert.assertEquals(customer, cust);
	}
}
