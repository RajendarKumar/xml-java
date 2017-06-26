# xml-java
Conver XML string to plain java object using JAXBContext.

Technologies used in this article

    JDK 1.8
    Maven 3.5.0

Working with JAXB is easy, just annotate object with JAXB annotation, later use jaxbMarshaller.marshal() or jaxbMarshaller.unmarshal() to do the object / XML conversion.

No extra jaxb libraries are required if you are using JDK1.6 or above, because JAXB is bundled in JDK 1.6.

If JDK version is below 1.6 use appropriate JAXB Dependency