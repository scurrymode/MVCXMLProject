package com.sist.controller;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler{
	public Map map = new HashMap();

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try{
			if(qName.equals("bean")){
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName =Class.forName(cls);
				Object obj = clsName.newInstance();
				// ���÷��� = Ŭ���� ������ �о ����
				// �޼ҵ�, ������, �������, �������� �Ű������� ���� ����
				
				map.put(id, obj);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
