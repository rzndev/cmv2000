package ru.clsoft.cmv2000;

import java.io.*;
import java.util.*;
import javax.xml.namespace.*;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;
import org.xml.sax.*;

public class ReadConfig {
    private XPath path;
    private DocumentBuilder builder;
    private Document doc;
    private List<Object> parameters = new ArrayList<>();

    private int port = 8888;
    private String ipAddress = "127.0.0.1";

    public int getPort() {
        return port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public ReadConfig() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {

        }
        XPathFactory xpfactory = XPathFactory.newInstance();
        path = xpfactory.newXPath();
    }

    private void configure(Map<String, String> opt, List<CMV2000BoleanItem> bits) {
        String registerType = opt.get("type");
        switch (registerType) {
            case "integer":
                CMV2000IntegerParameters newIntegerParameter = new CMV2000IntegerParameters();
                newIntegerParameter.setFromMap(opt);
                parameters.add(newIntegerParameter);
                break;
            case "bool":
                CMV2000BooleanParameters newBooleanParameter = new CMV2000BooleanParameters();
                newBooleanParameter.setFromMap(opt, bits);
                parameters.add(newBooleanParameter);
                break;
        }
    }

    public void run() {
        parameters.clear();
        try {
            File file = new File("init.xml");
            doc = builder.parse(file);
        } catch (IOException ex ){
            return;
        } catch (SAXException ex ) {
            return;
        }
        QName returnType = null;
        String typeName = "NUMBER";
        try {
            returnType = (QName) XPathConstants.class.getField(typeName).get(null);
        } catch (NoSuchFieldException ex) {

        } catch (IllegalAccessException ex) {

        }
        Object evalResult = null;
        try {
            evalResult = path.evaluate("/root/network/@port", doc, returnType);
        } catch (XPathExpressionException ex) {
        }
        port = ((Double)evalResult).intValue(); // !!!

        typeName = "STRING";
        try {
            returnType = (QName) XPathConstants.class.getField(typeName).get(null);
        } catch (NoSuchFieldException ex) {

        } catch (IllegalAccessException ex) {
        }

        try {
            evalResult = path.evaluate("/root/network/@ip", doc, returnType);
        } catch (XPathExpressionException ex) {
        }

        ipAddress = (String)evalResult; // !!!

        typeName = "NODESET";
        try {
            returnType = (QName) XPathConstants.class.getField(typeName).get(null);
        } catch (NoSuchFieldException ex) {

        } catch (IllegalAccessException ex) {
        }

        try {
            evalResult = path.evaluate("/root/register", doc, returnType);
        } catch (XPathExpressionException ex) {
        }

        NodeList list = (NodeList)evalResult;
        for(int i = 0; i < list.getLength(); i++) {
            int j = 0;
            Map<String, String> mapAttr = new HashMap<>();
            List<CMV2000BoleanItem> bits = new ArrayList<>();
            Node item = list.item(i);
            NamedNodeMap attribs = item.getAttributes();
            for(j = 0; j < attribs.getLength(); j++) {
                Node attrib = attribs.item(j);
                String attrName = attrib.getNodeName();
                String attrVal = attrib.getNodeValue();
                mapAttr.put(attrName, attrVal);
            }
            NodeList children = item.getChildNodes();
            for(j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if (child.getNodeName().compareTo("bit") != 0) continue;
                attribs = child.getAttributes();
                Map<String, String> mapBit = new HashMap<>();
                for(int k = 0; k < attribs.getLength(); k++) {
                    Node attrib = attribs.item(k);
                    String attrName = attrib.getNodeName();
                    String attrVal = attrib.getNodeValue();
                    mapBit.put(attrName, attrVal);
                }
                String strId = mapBit.get("id");
                String strName = mapBit.get("name");
                String strVal = mapBit.get("val");
                int id = 0;
                try {
                    id = Integer.parseInt(strId);
                } catch (NumberFormatException ex) {
                }
                int val = 0;
                try {
                    val = Integer.parseInt(strVal);
                } catch (NumberFormatException ex) {
                }
                CMV2000BoleanItem boleanItem = new CMV2000BoleanItem();
                boleanItem.setId(id);
                boleanItem.setName(strName);
                boleanItem.setVal(val != 0);
                bits.add(boleanItem);
            }
            configure(mapAttr, bits);
        }
    }
}
