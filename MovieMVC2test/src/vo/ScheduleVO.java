package vo;

import java.sql.Timestamp;

public class ScheduleVO {
	private String movieName;
	private int category;
	private String img;
	private String info;
	private int schNo;
	private int movieNo;
	private Timestamp runDay;
	private int runtime;
	private int roomNo;
	private int seatCnt;
	
	public ScheduleVO(String movieName, int category, String img, String info, int schNo, int movieNo, Timestamp runDay,int runtime, int roomNo, int seatCnt) {
		this.movieName = movieName;
		this.category = category;
		this.img = img;
		this.info = info;
		this.schNo = schNo;
		this.movieNo = movieNo;
		this.runDay = runDay;
		this.runtime = runtime;
		this.roomNo = roomNo;
		this.seatCnt = seatCnt;
	}

	public ScheduleVO() {}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public Timestamp getRunDay() {
		return runDay;
	}

	public void setRunDay(Timestamp runDay) {
		this.runDay = runDay;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getSeatCnt() {
		return seatCnt;
	}

	public void setSeatCnt(int seatCnt) {
		this.seatCnt = seatCnt;
	}
}
