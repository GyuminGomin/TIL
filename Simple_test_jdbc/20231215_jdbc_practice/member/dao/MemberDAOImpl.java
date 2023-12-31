package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.dto.BackUpMemberDTO;
import member.dto.MemberDTO;
import utils.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// MemberVO 정보를 넘겨받아서 회원가입을 진행하고
	// 가입 완료된 회원의 정보를 검색하여 Member type으로 반환
	@Override
	public MemberDTO join(MemberDTO memberVO) {
		MemberDTO m = null;
		// 작성
		String sql = "INSERT INTO tbl_member (mName, mId, mPw, reg) VALUES (?,?,?,?)";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getmName());
			pstmt.setString(2, memberVO.getmId());
			pstmt.setString(3, memberVO.getmPw());
			memberVO.setReg(System.currentTimeMillis());
			pstmt.setLong(4, memberVO.getRealReg());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				DBUtil.close(pstmt);
				sql = "SELECT mNum, reg FROM tbl_member WHERE mId = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberVO.getmId());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					int mNum = rs.getInt(1);
					long reg = rs.getLong(2);
					memberVO.setmNum(mNum);
					memberVO.setReg(reg);
					return memberVO;
				}
			}
			// m = selectMember(memberVO.getmId(), memberVO.getmPw()); // 이건 내가 한 것

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}
		return m;
	}
	
	// 로그인 - id 와 pw 가 일치하는 사용자일시 정보 전달
	@Override
	public MemberDTO selectMember(String mId, String mPw) {
		MemberDTO member = null;
		// 작성
		String sql = "SELECT * FROM tbl_member WHERE mId = ? AND mPw = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			member = getMember(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}

		return member;
	}
	
	// 회원번호로 회원 정보 검색
	@Override
	public MemberDTO selectMember(int mNum) {
		MemberDTO member = null;
		// 작성
		String sql = "SELECT * FROM tbl_member WHERE mNum = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNum);
			rs = pstmt.executeQuery();
			member = getMember(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
		
		return member;
	}

	public MemberDTO getMember(ResultSet rs) throws SQLException {
		MemberDTO member = null;
		if (rs.next()) {
			member = new MemberDTO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getLong(5)
			);
		}
		return member;
	}

	// 기존에 동일한 아이디가 존재하는지 확인
	// true 사용가능 - 아이디가 존재하지 않으면
	// false 사용불가 - 아이디가 존재하면
	@Override
	public boolean selectMember(String mId) {
		boolean isChecked = true;
		// 작성
		String sql = "SELECT * FROM tbl_member WHERE mId = ?";
		conn = DBUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isChecked = false;
			}
		} catch (SQLException e) {
			isChecked = false; // 쿼리예외가 떠도 사용할 수 없는 아이디이므로!
		} finally {
			DBUtil.close(rs, pstmt);
		}

		return isChecked;
	}

	// 전체 회원 목록을 ArrayList에 담아서 반환
	@Override
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> members = new ArrayList<>();
		// 작성
		String sql = "SELECT * FROM tbl_member ORDER BY mNum DESC";
		conn = DBUtil.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				members.add(new MemberDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5)
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt);
		}

		return members;
	}
	
	// mNum이 일치하는 사용자의 회원이름 정보 수정
	@Override 
	public int update(MemberDTO member) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_member SET mName = ? WHERE mNum = ?";
		conn = DBUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getmName());
			pstmt.setInt(2, member.getmNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}

		return result;
	}
	
	// 회원 탈퇴 - 회원번호를 입력받아 일치하는 회원 정보 삭제
	// 탈퇴 요청이 들어온 회원 정보를 tbl_member_deleted 테이블에 등록 시킨 후 tbl_member 에서 활성 정보 삭제
	@Override
	public int delete(int mNum) {
		int result = 0;
		// 작성

		// 탈퇴 요청이 들어온 회원 번호로 백업할 회원 정보 검색
		// 삭제할 멤버 테이블에 삽입 (갑자기 정전이 일어나거나 하면 데이터가 삽입만 되고, 삭제는 안되는 경우가 생겨서 이런 방법은 좋지 않음) (어떻게 해야할까?) - 트랜잭션으로 관리
		MemberDTO backUpMember = selectMember(mNum);
		String sql = "INSERT INTO tbl_member_deleted VALUES (?, ?, ?, ?, ?, now())";
		conn = DBUtil.getConnection();

		try {
			// conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, backUpMember.getmNum());
			pstmt.setString(2, backUpMember.getmName());
			pstmt.setString(3, backUpMember.getmId());
			pstmt.setString(4, backUpMember.getmPw());
			pstmt.setLong(5, backUpMember.getRealReg());
			result = pstmt.executeUpdate();

			if (result == 1) {
				DBUtil.close(pstmt);
				sql = "DELETE FROM tbl_member WHERE mNum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mNum);
				result = pstmt.executeUpdate();
				// conn.commit(); // 전체 구문이 실행되어야 commit이 되도록 설정
			}	

		} catch (SQLException e) {
			/*
			try {
				conn.rollback(); // 정전이 일어나는 예외가 발생한다면, 다시 되돌리기
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			*/
		} finally {
			/*
			try {
				conn.setAutoCommit(true); // 마지막 AutoCommit을 원상복구 해야함
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			DBUtil.close(pstmt);
		}
		return result;
	}
	
	// 탈퇴한 회원 정보 검색
	@Override
	public ArrayList<BackUpMemberDTO> deleteMember() {
		ArrayList<BackUpMemberDTO> deletes = new ArrayList<>();
		// 작성
		String sql = "SELECT * FROM tbl_member_deleted ORDER BY deleteDate DESC";
		conn = DBUtil.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				deletes.add(new BackUpMemberDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getTimestamp(6) // java.util.Date
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt);
		}
		return deletes;
	}
	
}












