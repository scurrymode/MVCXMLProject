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
				// 리플렉션 = 클래스 정보를 읽어서 제어
				// 메소드, 생성자, 멤버변수, 생성자의 매개변수를 접근 가능
				
				map.put(id, obj);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
