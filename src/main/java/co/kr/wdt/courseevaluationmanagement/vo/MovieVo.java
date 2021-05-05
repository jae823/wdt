package co.kr.wdt.courseevaluationmanagement.vo;

public class MovieVo {
	private int mv_Idx;
	private String mvName;
	private String mvCateCode;
	private String cateName;
	private int mvPrice;
	private int mvAvailSeat;
	private String mvDes;
	private String mvImg;
	private String mvDate;
	private String stored_File_Name;
	private String original_File_Name;
	
	public int getMv_Idx() {
		return mv_Idx;
	}
	public void setMv_Idx(int mv_Idx) {
		this.mv_Idx = mv_Idx;
	}
	public String getMvName() {
		return mvName;
	}
	public void setMvName(String mvName) {
		this.mvName = mvName;
	}
	public String getMvCateCode() {
		return mvCateCode;
	}
	public void setMvCateCode(String mvCateCode) {
		this.mvCateCode = mvCateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getMvPrice() {
		return mvPrice;
	}
	public void setMvPrice(int mvPrice) {
		this.mvPrice = mvPrice;
	}
	public int getMvAvailSeat() {
		return mvAvailSeat;
	}
	public void setMvAvailSeat(int mvAvailSeat) {
		this.mvAvailSeat = mvAvailSeat;
	}
	public String getMvDes() {
		return mvDes;
	}
	public void setMvDes(String mvDes) {
		this.mvDes = mvDes;
	}
	public String getMvImg() {
		return mvImg;
	}
	public void setMvImg(String mvImg) {
		this.mvImg = mvImg;
	}
	public String getMvDate() {
		return mvDate;
	}
	public void setMvDate(String mvDate) {
		this.mvDate = mvDate;
	}
	public String getStored_File_Name() {
		return stored_File_Name;
	}
	public void setStored_File_Name(String stored_File_Name) {
		this.stored_File_Name = stored_File_Name;
	}
	public String getOriginal_File_Name() {
		return original_File_Name;
	}
	public void setOriginal_File_Name(String original_File_Name) {
		this.original_File_Name = original_File_Name;
	}
	
	@Override
	public String toString() {
		return "MovieVo [mv_Idx=" + mv_Idx + ", mvName=" + mvName + ", mvCateCode=" + mvCateCode + ", mvPrice="
				+ mvPrice + ", mvAvailSeat=" + mvAvailSeat + ", mvDes=" + mvDes + ", mvImg=" + mvImg + ", mvDate="
				+ mvDate + ", stored_File_Name=" + stored_File_Name + ", original_File_Name=" + original_File_Name
				+ "]";
	}
}
