package com.raj.coverter.service.api;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public interface IJaxBInitializer{

	void setClassesToBeBound(@SuppressWarnings("rawtypes") Class... clazz);
	JAXBContext initJAXBContext() throws JAXBException;
}
