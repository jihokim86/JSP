package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.MovieVO;
import vo.ScheduleVO;
import vo.TicketVO;

public class MovieDAO {
	private static MovieDAO instance = new MovieDAO();

	private MovieDAO() {
	}

	public static MovieDAO getInstance() {
		return instance;
	}

	// 영화 가져오는 메서드 카테고리가 0이면 모든 영화를 불러오고 카테고리가 1, 2면 각 카테고리에 맞는 영화만 불러와집니다.
	// 불러와진 영화들을 리스트에 저장하여 return 합니다.
	public ArrayList<MovieVO> selectCategory(int category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();
		try {

			conn = JdbcUtil.getConnection();

			String sql = "SELECT * FROM movie ORDER BY movieNo";

			if (category != 0) {
				sql = "SELECT * FROM movie WHERE category = " + category + " ORDER BY movieNo";
			}

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO();

				vo.setMovieNo(rs.getInt("movieNo"));
				vo.setMovieName(rs.getString("movieName"));
				vo.setCategory(rs.getInt("category"));
				vo.setRuntime(rs.getInt("runtime"));
				vo.setImg(rs.getString("img"));
				vo.setInfo(rs.getString("info"));

				movieList.add(vo);
			}

		} catch (Exception e) {
			System.out.println("selectCategory() 오류");
			e.printStackTrace();

		} finally {
			// DB 객체 반환
			JdbcUtil.close(rs, pstmt, conn);
		}
		return movieList;
	}

	public ArrayList<MovieVO> movieInfo(int movieNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MovieVO> list = new ArrayList<MovieVO>();

		try {
			conn = JdbcUtil.getConnection();

			pstmt = conn.prepareStatement("SELECT * FROM movie WHERE movieNo = ?");

			pstmt.setInt(1, movieNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO();
				
				vo.setMovieNo(rs.getInt("movieNo"));
				vo.setMovieName(rs.getString("movieName"));
				vo.setCategory(rs.getInt("category"));
				vo.setRuntime(rs.getInt("runtime"));
				vo.setImg(rs.getString("img"));
				vo.setInfo(rs.getString("info"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	public ArrayList<ScheduleVO> scheduleAList(int movieNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ScheduleVO> list = new ArrayList<ScheduleVO>();
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT m.movieName, m.category, m.img, m.info, m.runtime, m.movieNo, s.schNo, r.roomNo, s.runDay, r.seatcnt FROM movie m, schedule s, room r WHERE m.movieNo = s.movieNo AND r.schNo = s.schNo AND m.movieNo = ?");
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScheduleVO vo = new ScheduleVO();
				
				vo.setMovieName(rs.getString("movieName"));
				vo.setCategory(Integer.parseInt(rs.getString("category")));
				vo.setImg(rs.getString("img"));
				vo.setInfo(rs.getString("info"));
				vo.setSchNo(rs.getInt("schNo"));
				vo.setMovieNo(rs.getInt("movieNo"));
				vo.setRunDay(rs.getTimestamp("runDay"));
				vo.setRuntime(rs.getInt("runtime"));
				vo.setRoomNo(rs.getInt("roomNo"));
				vo.setSeatCnt(rs.getInt("seatCnt"));
				
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}

		return list;
	}
	
	public ArrayList<TicketVO> ticketAllList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TicketVO> list = new ArrayList<TicketVO>();
		
		try {
			conn = JdbcUtil.getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM ticket");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TicketVO vo = new TicketVO();
				
				vo.setTicketNo(rs.getInt("ticketNo"));
				vo.setBookDate(rs.getDate("bookDate"));
				vo.setSchNo(rs.getInt("schNo"));
				vo.setSeatNo(rs.getInt("seatNo"));
				vo.setId(rs.getString("id"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}

		return list;
	}
	
	public ArrayList<TicketVO> ticketMyList(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TicketVO> list = new ArrayList<TicketVO>();
		
		try {
			conn = JdbcUtil.getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM ticket WHERE id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TicketVO vo = new TicketVO();
				
				vo.setTicketNo(rs.getInt("ticketNo"));
				vo.setBookDate(rs.getDate("bookDate"));
				vo.setSchNo(rs.getInt("schNo"));
				vo.setSeatNo(rs.getInt("seatNo"));
				vo.setId(rs.getString("id"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}

		return list;
	}
	
	public ArrayList<TicketVO> ticketList(int schNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TicketVO> list = new ArrayList<TicketVO>();
		
		try {
			conn = JdbcUtil.getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM ticket WHERE schNo = ?");
			
			pstmt.setInt(1, schNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TicketVO vo = new TicketVO();
				
				vo.setTicketNo(rs.getInt("ticketNo"));
				vo.setBookDate(rs.getDate("bookDate"));
				vo.setSchNo(rs.getInt("schNo"));
				vo.setSeatNo(rs.getInt("seatNo"));
				vo.setId(rs.getString("id"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}

		return list;
	}
	
	public int ticketBuy(TicketVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int status = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO ticket VALUES(?, SYSDATE, ?, ?, ?)");
			//"현 값 + 1 해주기"
			pstmt.setInt(1, ticketMaxNo() + 1);
			pstmt.setInt(2, vo.getSchNo());
			pstmt.setInt(3, vo.getSeatNo());
			pstmt.setString(4, vo.getId());

			status = pstmt.executeUpdate();
			
			if(status > 0) {
				pstmt = conn.prepareStatement("UPDATE room SET seatCnt = seatCnt + 1 WHERE schNo = ?");
				pstmt.setInt(1, vo.getSchNo());
				
				status = pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		return status;
	}
	
	public int ticketMaxNo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int status = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement("select MAX(ticketno) from ticket");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				status = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		return status;
	}
}
