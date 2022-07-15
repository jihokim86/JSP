package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JdbcUtil;
import vo.MemberVO;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}
	
	//회원가입 처리 메서드
	public int memberRegister(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int status = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO member2 VALUES(?, ?, ?, ?, ?)");

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTel());
			pstmt.setDate(5, vo.getBirth());

			status = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB 객체 반환
			JdbcUtil.close(rs, pstmt, conn);
		}
		return status;
	}
	
	//로그인 처리 메서드
	public MemberVO memberLogin(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO vo = new MemberVO();

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM member2 WHERE id = ? AND pw = ?");

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setBirth(rs.getDate("birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB 객체 반환
			JdbcUtil.close(rs, pstmt, conn);
		}

		return vo;
	}

}
