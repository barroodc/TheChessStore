package com.solvd.onlinestore.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DOMParser {
    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);


   /* public static void main(String[] args){
        try {
            File file = new File("src/main/resources/xmlFiles/entityXMLS/domtest.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("DomTest");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    LOGGER.info("id: " + element.getAttribute("id"));
                    LOGGER.info("\nELEMENTS :");
                    LOGGER.info("HusbandName :" + element.getElementsByTagName("HusbandName").item(0).getTextContent());
                    LOGGER.info("WifeName :" + element.getElementsByTagName("WifeName").item(0).getTextContent());
                    LOGGER.info("MarriageStatus :" + element.getElementsByTagName("MarriageStatus").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
    */
}
