package service;

import java.util.ArrayList;

import beans.NoticeVO;
import jakarta.servlet.http.HttpServletRequest;
import repositories.NoticeDAO;
import repositories.NoticeDAOImpl;
import util.Criteria;

public class NoticeServiceImpl implements NoticeService {

	NoticeDAO dao = new NoticeDAOImpl();
	
	@Override
	public boolean noticeWrite(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void noticeList(HttpServletRequest request) {
		// 페이징 처리된 게시물 목록을 리스트 반환
		// 사용자가 요청한 페이지 번호
		int page = 1;
		// 요청한 페이지 번호가 존재하면 요청 페이지 번호 변경
		// 요청한 페이지 번호가 없으면 1page 출력
		String pageNum = request.getParameter("page");
		if (pageNum != null) {
			page = Integer.parseInt(pageNum);
		}
		
		Criteria cri = new Criteria(page, 10); // page, 10개씩
		
		ArrayList<NoticeVO> list = dao.noticeList(cri);
		request.setAttribute("list", list);
	}

	@Override
	public void noticeDetail(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean noticeUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean noticeDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
