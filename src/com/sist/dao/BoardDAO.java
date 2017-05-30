package com.sist.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private static SqlSessionFactory ssf;
	static{//초기화 블럭
		try{
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static List<BoardVO> boardListData(Map map) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		SqlSession session =null;
		try{
			session=ssf.openSession();
			list=session.selectList("boardListData", map);
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			session.close();
		}
		return list;
	}

}
