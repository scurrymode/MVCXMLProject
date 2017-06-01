package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
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
		
		
		int totalpage=dao.boardTotalPage();
		req.setAttribute("msg", "관리자가 삭제한 게시물입니다");//삭제한건 링크가 안걸리게 해주려는 키
		req.setAttribute("list", list);
		req.setAttribute("curpage", curpage);
		req.setAttribute("totalpage", totalpage);
		req.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		
		return "/board/list.jsp";
	}

}
