package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

public class ListModel implements Model {

	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String page = req.getParameter("page");
		if(page==null){
			page="1";
		}
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (curpage*rowSize)-(rowSize-1);
		int end= curpage*rowSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.boardListData(map);
		req.setAttribute("list", list);
		
		return "/board/list.jsp";
	}

}
