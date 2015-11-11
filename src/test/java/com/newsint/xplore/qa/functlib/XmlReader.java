package com.newsint.xplore.qa.functlib;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 30/05/13
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class XmlReader {

    public static String readXMLFile(String Parenttag, String tag){

        String directory = System.getProperty("user.dir");
        String filepath = directory+"/src/test/resources/cucumber/xplore/java/resources/Properties.xml";
        String keyValue = "";
        try{
            File xmlFile = new File(filepath);
            //System.out.print("the File path is :"+filepath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document xmlDoc = dBuilder.parse(xmlFile);

            xmlDoc.getDocumentElement().normalize();
            System.out.println("Root element of the File is :"+ xmlDoc.getDocumentElement().getNodeName());
            NodeList nodes = xmlDoc.getElementsByTagName(Parenttag);
            for (int i = 0; i<nodes.getLength(); i++){
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Edition :"+ getValue(tag, element));
                    keyValue = getValue(tag, element);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return keyValue;

    }


    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }


}



