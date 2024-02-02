package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.NoticeVO;
import util.Criteria;
import util.DBCPUtil;

public class NoticeDAOImpl implements NoticeDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public boolean noticeWrite(NoticeVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<NoticeVO> noticeList(Criteria cri) {
		
		String sql = "SELECT * FROM notice ORDER BY notice_num DESC limit ?, ?";
		conn = DBCPUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartRow());
			pstmt.setInt(2, cri.getPerPageNum());
			
			// TODO 여기서부터 해야함
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs, pstmt, conn);
		}
		
		return null;
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeVO noticeDetail(int notice_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean noticeDelete(int notice_num) {
		// TODO Auto-generated method stub
		return false;
	}

}
