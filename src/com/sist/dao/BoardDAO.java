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
	static{//�ʱ�ȭ ��
		try{
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//�Խ��� �����ֱ�
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
	
	//�� ������ ���ϱ�
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
	
	//���뺸��
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
			session.close(); //ConnectionPool ��ȯ
		}
		return vo;
	}
	
	//�����߰��ϱ�
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
	
	//�亯�ø���
	
	//�����ϱ�
	
	//�����ϱ�
	
	//ã��

}
