package dao;

import java.sql.*;
import java.util.*;

import util.JDBCUtil;
import vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	MemberVO m = null;
	String sql = null;
	Connection conn = JDBCUtil.getConnection(); 
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	@Override
	public List<MemberVO> selectMemberList() {
		// DB에 있는 데이터 받아오기 위한 변수 선언
		List<MemberVO> memberList = new ArrayList<>();
		
		sql = "SELECT * FROM test_member";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String pass = rs.getString(3); 
				String name = rs.getString(4);
				String addr = rs.getString(5);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				int age = rs.getInt(8);
				
				m = new MemberVO(num, id, pass, name, addr, phone, gender, age);
				memberList.add(m);
			}
		} catch (SQLException e) {
			System.out.println("sql 쿼리 실패");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt);
		}
		return memberList; // application ServletContext에 저장할 리스트
	}
	
	@Override
	public void join(MemberVO member) {
		
		// 회원정보 삽입
		sql = "INSERT INTO test_member VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());
			pstmt.setInt(7, member.getAge());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql 쿼리 실패");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		// 회원이 존재하면 반환, 존재하지 않으면 null
		MemberVO m = null;
		
		// 회원 정보 확인
		sql = "SELECT * FROM test_member WHERE id=? AND pass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			rs = pstmt.executeQuery();
			
			// 존재하는 회원은 있거나 없거나 이기에
			if (rs.next()) {
				// 존재하는 회원이 있다면,
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String pass = rs.getString(3);
				String name = rs.getString(4);
				String addr = rs.getString(5);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				int age = rs.getInt(8);
				
				m = new MemberVO(num, id, pass, name, addr, phone, gender, age);
			}
			
		} catch (SQLException e) {
			System.out.println("sql 쿼리 실패");
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public MemberVO idCheck(MemberVO member) {
		// 회원이 존재하면 반환, 존재하지 않으면 null
		MemberVO m = null;
		
		// 회원 정보 확인
		sql = "SELECT * FROM test_member WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			// 존재하는 회원은 있거나 없거나 이기에
			if (rs.next()) {
				// 존재하는 회원이 있다면,
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String pass = rs.getString(3);
				String name = rs.getString(4);
				String addr = rs.getString(5);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				int age = rs.getInt(8);
				
				m = new MemberVO(num, id, pass, name, addr, phone, gender, age);
			}
			
		} catch (SQLException e) {
			System.out.println("sql 쿼리 실패");
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(MemberVO member) {
		// 회원 수정
		sql = "UPDATE test_member SET id=?, pass=?, name=?, addr=?, phone=?, gender=?, age=? WHERE num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());
			pstmt.setInt(7, member.getAge());
			pstmt.setInt(8, member.getNum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql 쿼리 실패");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	@Override
	public void delete(MemberVO member) {
		
		sql = "DELETE FROM test_member WHERE num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getNum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

}
