package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO() { // 왜 생성자 내부에 선언되어 있는걸까?
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List membersList = new ArrayList();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//두가지 방법이 있음. 개인적으로는 아래것이 좋아보임.
//				String id = rs.getString("id");
//				String pwd = rs.getString("pwd");
//				String name = rs.getString("name");
//				String email = rs.getString("email");
//				Date joinDate = rs.getDate("joinDate");
//				
//				MemberVO memberVO = new MemberVO(id,pwd,name,email,joinDate);
//				membersList.add(memberVO);
				
				// 필드 값에 접근하기 위해서는 get set으로 접근해야하지!!!
				  MemberVO mVO = new MemberVO();
				  mVO.setId(rs.getString("id"));
				  mVO.setPwd(rs.getNString("pwd"));
				  mVO.setName(rs.getString("name"));
				  mVO.setEmail(rs.getString("email"));
				  mVO.setJoinDate(rs.getDate("joinDate"));
				  membersList.add(mVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return membersList;
	}
	
	
	public void addMember(MemberVO memberVO) {
		try {
			conn = dataFactory.getConnection();
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member(id,pwd,name,email)"+"values(?,?,?,?)";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
