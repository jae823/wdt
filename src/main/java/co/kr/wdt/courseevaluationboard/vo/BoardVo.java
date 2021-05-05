package co.kr.wdt.courseevaluationboard.vo;

public class BoardVo {
	private int idx;
	private int mv_Idx;
	private String title;
	private String content;
	private String name;
	private String movieName;
	private Long userNo;
	private int hit_Cnt;
	private String reg_Date;
	private String del_gb;
	
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public int getMv_Idx() {
		return mv_Idx;
	}
	
	public void setMv_Idx(int mv_Idx) {
		this.mv_Idx = mv_Idx;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getUserNo() {
		return userNo;
	}
	
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	public int getHit_Cnt() {
		return hit_Cnt;
	}
	
	public void setHit_Cnt(int hit_Cnt) {
		this.hit_Cnt = hit_Cnt;
	}
	
	public String getReg_Date() {
		return reg_Date;
	}
	
	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	
	public String getDel_gb() {
		return del_gb;
	}
	
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}
	
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", mv_Idx=" + mv_Idx + ", title=" + title + ", content=" + content + ", name="
				+ name + ", movieName=" + movieName + ", userNo=" + userNo + ", hit_Cnt=" + hit_Cnt + ", reg_Date="
				+ reg_Date + ", del_gb=" + del_gb + "]";
	}
	
}
