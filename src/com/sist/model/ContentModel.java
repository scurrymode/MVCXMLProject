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
		
		req.setAttribute("vo", vo);	//select ������ ����� �����ֱ�
		req.setAttribute("page", page); //�ǵ��ư� ������
		
		return "board/content.jsp";
	}

}
