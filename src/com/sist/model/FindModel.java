package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
public class FindModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("EUC-KR");
		String fs= req.getParameter("fs");
		String ss = req.getParameter("ss");
		Map map = new HashMap();
		map.put("ss", ss);
		map.put("fs", fs);
		List<BoardVO> list = BoardDAO.boardFindData(map);
		
		req.setAttribute("list", list);
		req.setAttribute("length", list.size()); //검색 결과가 없으면, 없다고 해줘야 하니깐~!
		
		return "board/find.jsp";
	}

}
