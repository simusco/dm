package com.moma.dawnlove.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {//
	
	public static void main(String[] args) {
		
		List<FrameAdaper> frames = new XMLParser().loadData("D:\\bazhaF.xml");
		for(int i=0;i<frames.size();i++){
			System.out.println(frames.get(i));
		}
		
	}
	
	public List<FrameAdaper> loadData(String xmlFilePath){
		List<FrameAdaper> af = new ArrayList<FrameAdaper>();
		
		List<Frame> frames = parse(xmlFilePath);
		for(int i=0;i<frames.size();i++){
			af.add(new FrameAdaper(frames.get(i)));
		}
		
		return af;
	}
	
	public List<Frame> parse(String xmlFilePath) {

		List<Frame> frames = new ArrayList<Frame>();
		try {
			InputStream is = new FileInputStream(xmlFilePath);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			Element element = document.getDocumentElement();

			NodeList nodes = element.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);// frames
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					if (node.getNodeName().equals("dict")) {
						NodeList nodes2 = node.getChildNodes();//
						for (int j = 0; j < nodes2.getLength(); j++) {
							Node node2 = nodes2.item(j);
							if (node2.getNodeType() == Node.ELEMENT_NODE) {
								String xx = node2.getChildNodes().item(0).getNodeValue();
								if ("frames".equals(xx)) {
									Node oo = node2.getNextSibling();
									while (oo.getNodeType() != Node.ELEMENT_NODE) {
										oo = oo.getNextSibling();
									}

									frames = frame(oo);
								}
							}
						}

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		
		return frames;

	}

	List<Frame> frame(Node node2) {
		List<Frame> frames = new ArrayList<Frame>();
		NodeList frameNode = node2.getChildNodes();
		
		for (int i = 0; i < frameNode.getLength(); i++) {
			Node node = frameNode.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (node.getNodeName().equals("key")) {
					Frame frame = new Frame();
					frame.setKey(node.getFirstChild().getNodeValue());
					
					Node oo = node.getNextSibling();
					while (oo.getNodeType() != Node.ELEMENT_NODE) {
						oo = oo.getNextSibling();
					}
					
					frame(frame, oo);
					frames.add(frame);
				}
			}
		}
		
		return frames;
	}

	void frame(Frame frame, Node oo) {
		
		NodeList frameNode = oo.getChildNodes();

		for (int i = 0; i < frameNode.getLength(); i++) {
			Node node = frameNode.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (node.getNodeName().equals("key")) {
					Node oo2 = node.getNextSibling();
					while (oo2.getNodeType() != Node.ELEMENT_NODE) {
						oo2 = oo2.getNextSibling();
					}
					
					//key, type, value
					setBeanValue(frame, node.getFirstChild().getNodeValue(), getValue(oo2.getNodeName(), oo2));
				}
			}
		}
		
	}

	String getValue(String nodeName, Node oo2) {
		String value = "";
		if("array".equals(nodeName)){
			NodeList chidren = oo2.getChildNodes();
			for(int i=0;i<chidren.getLength();i++){
				Node aliase = chidren.item(i);
				if(aliase.getNodeType() == Node.ELEMENT_NODE){
					value += aliase.getFirstChild().getNodeValue() + ",";
				}
			}
		}else{
			Node node = oo2.getFirstChild();
			if(node == null){
				value = oo2.getNodeName();
			}else{
				value = node.getNodeValue();
			}
		}
		return value;
	}
	

	void setBeanValue(Object obj, String name, String value){
		
		try {
			String setMethodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
			//System.out.println(setMethodName);
			Method method = Frame.class.getMethod(setMethodName, String.class);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
