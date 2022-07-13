package com.saeyan.dao;

public class BoardDAO {
	
	private BoardDAO(){

	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() { //왜 type이 BoardDAO일까???
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		String sql = "select * from board order by num desc";
		
	}
}
