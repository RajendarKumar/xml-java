/**
 * 
 */
package com.raj.coverter.service.impl;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.raj.coverter.service.api.IJaxBInitializer;
import com.raj.pojo.Address;
import com.raj.pojo.Customer;



/**
 * @author Rajendar Kumar
 *
 */
public class AddressConverterServiceImplTest {

	private static String xml =  null;
	private static AddressConverterServiceImpl serviceImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IJaxBInitializer jaxbContext = new JaxBInitializerServiceImpl();
		jaxbContext.setClassesToBeBound(Customer.class, Address.class);
		serviceImpl = new AddressConverterServiceImpl(jaxbContext);
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><address><pNum>123, 2nd floor</pNum><cityName>New Delhi</cityName><cityCode>ABC</cityCode></address>";
	}

	@Test
	public void test() throws JAXBException {
		Address  address = serviceImpl.Unmarshall(xml);
		Assert.assertNotNull(address);
	}

}
