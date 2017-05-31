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
	public static void replyInsert(int pno, BoardVO vo){		
		//pno에 해당하는 gi, gs, gt 가져오기
		//sql (*) 이미 답변이 달려있을때, 새로운 답변이 달리면, 답변 중 맨 위에 올라와야하는데(최신), oracle은 값이 같으면 먼저 등록한 애가 위에 나오기 때문에 엉킴 나머지 애들의 gs를 다 하나씩 올린다.
		//insert gi는 같게, gs+1, gt+1한다.
		//pno 해당하는 놈의 depth 증가
		
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
	
	//수정하기
	public static BoardVO boardUpdateData(int no){
		BoardVO vo = new BoardVO();
		SqlSession session = null;
		try{
			session=ssf.openSession();
			vo=session.selectOne("boardUpdateData", no);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close(); //ConnectionPool 반환
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
	
	//삭제하기
	
	//찾기

}
