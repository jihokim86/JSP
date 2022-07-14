package sec03.brd01;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		return list;
	}

	
}
