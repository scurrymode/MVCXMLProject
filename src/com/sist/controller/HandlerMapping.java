package com.sist.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.sist.model.Model;

public class HandlerMapping {
	private Map clsMap=new HashMap();
	public HandlerMapping(String path) {
		try{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			//WML, HTML, XML, HDML 등이 다 해결된다. 
			SAXParser sp = spf.newSAXParser();
			XMLParser xp = new XMLParser();
			sp.parse(new File(path), xp);
			clsMap = xp.map;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Model getBean(String id){
		return (Model)clsMap.get(id);
	}

}
