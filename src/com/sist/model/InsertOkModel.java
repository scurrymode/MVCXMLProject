package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;

public class InsertOkModel implements Model {

	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//post ����� �׻� ����� �Ѵ�.
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
		
		//DAO����  (static)��� ������ �׳� ���� ���� 
		BoardDAO.boardInsert(vo);
		
		
		
		return "list.do"; //board ���̸� �ȵȴ�.
	}

}
