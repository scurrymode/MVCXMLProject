package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Model;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping hm;

	public void init(ServletConfig config) throws ServletException {
		//config => web.xml ����
		String path = config.getInitParameter("xmlPath");
		hm=new HandlerMapping(path);
		System.out.println(path);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//	http://localhost/MVCXMLProject/list.do(URL)
			// 	/MVCXMLProject/list.do(URI)
			// 	/MVCXMLProject (ContextPath)
			String cmd = request.getRequestURI();
			cmd = cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));
			System.out.println(cmd);
			
			//��ûó�� Ŭ���� ã��
			Model model = hm.getBean(cmd);
			
			//��û�� ���� ó�� => ������� request�� ��´�
			String jsp = model.handlerRequest(request, response);
			
			//����� ������� �ȵǴϱ� forward
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}