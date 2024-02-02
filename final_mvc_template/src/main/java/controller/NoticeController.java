package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.NoticeVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import service.NoticeService;
import service.NoticeServiceImpl;
import util.FactoryUtil;

@WebServlet("*.do")
public class NoticeController extends HttpServlet {

	private static final long serialVersionUID = -4463352427568788624L;

	NoticeService ns = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 자동 로그인 요청 사용자 인지 체크
		MemberService.loginCheck(req);
		
		String command = FactoryUtil.getCommand(req);
		
		String nextPage = null;
		// 공지사항 게시판으로 이동 (공지사항 게시판에 리스트 목록 출력)
		if (command.equals("noticeList.do")) {
			ns.noticeList(req);
			nextPage = "/board/notice/notice_list.jsp";
		}
		FactoryUtil.nextPage(req, resp, nextPage);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
