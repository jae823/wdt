package co.kr.wdt.courseevaluationboard.service;

import java.util.Map;

import co.kr.wdt.courseevaluationboard.vo.CourseEvaluationBoardVo;

public interface CourseEvaluationBoardService {
	
	public Map<String, Object> getBoardList(CourseEvaluationBoardVo CourseEvaluationBoradVo, int nowPage);
	
	public Map<String, Object> getSearchList(CourseEvaluationBoardVo CourseEvaluationBoradVo, int nowPage, String search);
	
	public boolean updateMovieHit_Cnt(String movieName);
	
	public CourseEvaluationBoardVo getDetail(int idx);

	public boolean write(Map<String, Object> param);
	
	public boolean update(CourseEvaluationBoardVo CourseEvaluationBoradVo);

	public boolean delete(int mv_Idx);
}
