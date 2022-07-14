package sec03.brd01;

public class BoardService {

	public BoardService() {
		BoardDAO boardDAO = new BoardDAO(); // 생성자 호출 시 DAO 객체를 생성
	}
	
	//controller에서 호출할 함수 정의
	//
	public List listArticles() {
		List articlesList = boardDAO.
		return articlesList;
	}

	
}
