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
	public static void replyInsert(int pno, BoardVO vo){		
		//pno�� �ش��ϴ� gi, gs, gt ��������
		//sql (*) �̹� �亯�� �޷�������, ���ο� �亯�� �޸���, �亯 �� �� ���� �ö�;��ϴµ�(�ֽ�), oracle�� ���� ������ ���� ����� �ְ� ���� ������ ������ ��Ŵ ������ �ֵ��� gs�� �� �ϳ��� �ø���.
		//insert gi�� ����, gs+1, gt+1�Ѵ�.
		//pno �ش��ϴ� ���� depth ����
		
		SqlSession session = null;
		try{
			session=ssf.openSession();
			BoardVO pvo = session.selectOne("boardGroupInfoData", pno);
			session.update("boardGroupStepIncrement", pvo);
			
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			session.insert("boardReplyInsert", vo); 
			session.update("baordDepthIncrement", pno);
			session.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.rollback();
		}finally{
			session.close();
		}
	}
	
	//�����ϱ�
	public static BoardVO boardUpdateData(int no){
		BoardVO vo = new BoardVO();
		SqlSession session = null;
		try{
			session=ssf.openSession();
			vo=session.selectOne("boardUpdateData", no);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close(); //ConnectionPool ��ȯ
		}
		return vo;
	}
	
	public static boolean boardUpdate(BoardVO vo){
		boolean bCheck=false;
		SqlSession session =null;
		try{
			session=ssf.openSession();
			String db_pwd = session.selectOne("boardGetPwd", vo.getNo());
			if(db_pwd.equals(vo.getPwd())){
				bCheck=true;
				session.update("boardUpdate", vo);
				session.commit();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		
		return bCheck;
		
	}
	
	//�����ϱ�
	
	//ã��

}
