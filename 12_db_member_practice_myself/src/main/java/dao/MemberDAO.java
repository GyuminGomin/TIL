package dao;

import java.util.List;

import vo.MemberVO;

public interface MemberDAO {
	
	// memberList 확인
	public List<MemberVO> selectMemberList();
	
	// 회원 가입
	public void join(MemberVO member);
	
	// 로그인
	public MemberVO login(MemberVO member);
	
	// 자동 로그인 또는 id 체크
	public MemberVO idCheck(MemberVO member);
	
	// 회원 정보 수정
	public void update(MemberVO member);
	
	// 회원 정보 삭제
	public void delete(MemberVO member);
}
