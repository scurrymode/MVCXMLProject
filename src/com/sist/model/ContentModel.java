package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class ContentModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String no = req.getParameter("no");
		String page = req.getParameter("page");
		
		//DAO
		BoardVO vo = BoardDAO.boardContentData(Integer.parseInt(no));
		
		req.setAttribute("vo", vo);	//select 쿼리문 결과값 보내주기
		req.setAttribute("page", page); //되돌아갈 페이지
		
		return "board/content.jsp";
	}

}
