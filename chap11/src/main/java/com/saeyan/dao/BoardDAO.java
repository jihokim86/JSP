package com.saeyan.dao;

public class BoardDAO {
	
	private BoardDAO(){

	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() { //�� type�� BoardDAO�ϱ�???
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		String sql = "select * from board order by num desc";
		
	}
}
