package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class UpdateModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String no = req.getParameter("no");
		String page = req.getParameter("page");
		
		
		//DAO
		BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		req.setAttribute("vo", vo);
		req.setAttribute("page", page);
		
		return "board/update.jsp";
	}

}
