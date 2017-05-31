package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class UpdateOkModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String pwd = req.getParameter("pwd");
		String no = req.getParameter("no");
		String page = req.getParameter("page");
		
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		//DAO연결  (static)줬기 때문에 그냥 접근 가능 
		boolean bCheck=BoardDAO.boardUpdate(vo);
		req.setAttribute("bCheck", bCheck);
		req.setAttribute("no", no);
		req.setAttribute("page", page);
		
		return "board/update_ok.jsp";
	}

}
