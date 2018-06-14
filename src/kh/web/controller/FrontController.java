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
		//  ---------------- FrontEnd 연결  ------------------------
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
	//  ---------------- FrontEnd 연결  끝 ------------------------
		
		MessagesDAO msgDao = new MessagesDAO();
		boolean isRedirect = true;
		String dst = "null";

		if(command.equals("/input.do")) {
		//  ---------------- FrontEnd 에서 보내주는 값 받기  ------------------------
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String message = request.getParameter("message");
		
		//  ------------------ DB insert 연결  ------------------------
			MessagesDTO msgDto = new MessagesDTO(id,name,message);
			System.out.println(msgDto.getMessage_id() + " : " + msgDto.getName() + " : " + msgDto.getMessage() );
			int result = msgDao.insertData(msgDto);
			
			
			//  ---------------- DB 연결 끝 ------------------------
			
			//  ---------------- FrontEnd 값 보내주는 코드  ------------------------
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
		// -------------- sendRdirect // forward 둘 중에 어떤 거를 쓸지 결정 하는 코드
		if(isRedirect) {
			response.sendRedirect(dst);
			// ----------- sendRdirect : 하나의 값을 공유 안해도 될 경우
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(dst);
			// ----------- forward : 하나의 값을 공유 해야 할 경우
			rd.forward(request, response);
		}
	}catch(Exception e){e.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
