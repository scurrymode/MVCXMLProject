package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;

public class InsertOkModel implements Model {

	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//post 방식은 항상 해줘야 한다.
		req.setCharacterEncoding("EUC-KR");
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String pwd = req.getParameter("pwd");
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		//DAO연결  (static)줬기 때문에 그냥 접근 가능 
		BoardDAO.boardInsert(vo);
		
		
		
		return "list.do"; //board 붙이면 안된다.
	}

}
