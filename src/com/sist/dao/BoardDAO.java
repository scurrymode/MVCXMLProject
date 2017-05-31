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
	
	//게시판 보여주기
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
	
	//총 페이지 구하기
	public int boardTotalPage(){
		int total=0;
		SqlSession session = null;
		try{
			session=ssf.openSession();
			total = session.selectOne("boardTotalPage");
		}catch(Exception e){
			System.out.println("boardTotalPage(): "+e.getMessage());
		}finally{
			session.close();
		}
		
		return total;
	}
	
	//내용보기
	public static BoardVO boardContentData(int no){
		BoardVO vo = new BoardVO();
		SqlSession session = null;
		try{
			session=ssf.openSession();
			session.update("boardHitIncrement", no);
			session.commit();
			vo=session.selectOne("boardContentData", no);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close(); //ConnectionPool 반환
		}
		return vo;
	}
	
	//새글추가하기
	public static void boardInsert(BoardVO vo){
		SqlSession session = null;
		try{
			session = ssf.openSession(true);
			session.insert("boardInsert", vo);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	//답변올리기
	
	//수정하기
	
	//삭제하기
	
	//찾기

}
