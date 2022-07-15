package sec03.brd01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BoardDAO {
//----- 전역변수 선언-------------------------------------------------
	Connection conn;
	PreparedStatement pstmt;
	DataSource dataFactory;
	
//------ 기본 생성자에 DB연결 코딩 작성 ---------------------------------
	public BoardDAO() {
		
	}
//------ DB 데이터를 불러와서 리스트에 저장하여 리턴하는 함수 -----------------
	public List selectAllArticles() {
		List articlesList = new ArrayList();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select LEVEL, articleNO, parentNO,title,content,id,writeDate"
								+ "from t_board"
								+ "START WITH parentNO=0"
								+ "CONNECT BY PRIOR articleNO=parentNO"
								+ "ORDER SIBLINGS BY articleNO DESC";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int level = rs.getInt("level");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
