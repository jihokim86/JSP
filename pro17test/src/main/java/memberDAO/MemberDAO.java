package memberDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.net.httpserver.Authenticator.Result;

import memberVO.MemberVO;

public class MemberDAO {
	//전역 변수들 
	Connection conn; //db 연결
	DataSource dataFactroy;
	PreparedStatement pstmt; //쿼리문 연결
	
//--------커넥션 풀 연결 하기---------------------------------------------------------
//--------기본 생성자 내부에 넣기--------------------------------------------------
	public MemberDAO() {
		try {
			Context context = new InitialContext(); 
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataFactroy = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------------

//-------DB와 연결하고 member 데이터에 접근하여 list에 저장하고 리턴하는 기능-------------
	public  List listMember() {
		
		List listMembers = new ArrayList();
		
		try {
			
			conn = dataFactroy.getConnection(); 	//DB 연결 완료
			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql); 	//sql문 준비 상태
			ResultSet rs = pstmt.executeQuery(); 	//쿼리 실행하여 rs에 저장
		
			
		
			while(rs.next()){						
				//ResultSet의 next()함수를 통해 1행씩 데이터를 읽음
				//rs.next() = false되면 while문 종료
				//ResultSet의 getString으로 DB의 데이터에 접근할수 있다.
				// ex) rs.getString(id)
			
				// 얻어온 값을 차례대로 리스트에 넣어야 한다.!
				// MemberVO의 필드에 값을 저장하기 위해 객체를 생성함
				MemberVO mVO = new MemberVO();
			
				//ResultSet의 getString()을 통해 DB의 값을 불러오고
				//set기능을 통해 MemberVO의 필드의 값을 저장함
				mVO.setId(rs.getString("id"));
				mVO.setPwd(rs.getString("pwd"));
				mVO.setName(rs.getString("name"));
				mVO.setEmail(rs.getString("email"));
				mVO.setJoinDate(rs.getDate("joinDate"));
			
				//1행을 순회했으면 리스트에 저장해야한다.
				//List listMembers = new ArrayList<E>(); 
				//이곳에 선언하게 되면 매번 객체를 생성하기에 가장 상단에 선언해야함 옮다.
				listMembers.add(mVO);
			}
				//원하는 값들을 리스트에 저장했으므로 서버를 닫아주는 코드를 추가해야한다
				rs.close();
				pstmt.close();
				conn.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return listMembers;
	}

	
	
}
