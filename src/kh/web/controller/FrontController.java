package kh.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import kh.web.messagesDAO.MessagesDAO;
import kh.web.messagesDTO.MessagesDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		//  ---------------- FrontEnd ����  ------------------------
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
	//  ---------------- FrontEnd ����  �� ------------------------
		
		MessagesDAO msgDao = new MessagesDAO();
		boolean isRedirect = true;
		String dst = "null";

		if(command.equals("/input.do")) {
		//  ---------------- FrontEnd ���� �����ִ� �� �ޱ�  ------------------------
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String message = request.getParameter("message");
		
		//  ------------------ DB insert ����  ------------------------
			MessagesDTO msgDto = new MessagesDTO(id,name,message);
			System.out.println(msgDto.getMessage_id() + " : " + msgDto.getName() + " : " + msgDto.getMessage() );
			int result = msgDao.insertData(msgDto);
			
			
			//  ---------------- DB ���� �� ------------------------
			
			//  ---------------- FrontEnd �� �����ִ� �ڵ�  ------------------------
			request.setAttribute("insert_result", result);
			isRedirect = false;
			dst = "inputView.jsp";
			
		}
		else if(command.equals("/output.do")) {
			List<MessagesDTO> list = new ArrayList<>();
			list = msgDao.selectData();
			request.setAttribute("select_result", list);
			isRedirect = false;
			dst = "output.jsp";
		}
		// -------------- sendRdirect // forward �� �߿� � �Ÿ� ���� ���� �ϴ� �ڵ�
		if(isRedirect) {
			response.sendRedirect(dst);
			// ----------- sendRdirect : �ϳ��� ���� ���� ���ص� �� ���
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(dst);
			// ----------- forward : �ϳ��� ���� ���� �ؾ� �� ���
			rd.forward(request, response);
		}
	}catch(Exception e){e.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
