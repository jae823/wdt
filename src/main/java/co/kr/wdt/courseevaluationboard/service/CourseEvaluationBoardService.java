package co.kr.wdt.courseevaluationboard.service;

import java.util.Map;

import co.kr.wdt.courseevaluationboard.vo.BoardVo;

public interface CourseEvaluationBoardService {
	
	public Map<String, Object> getBoardList(BoardVo boardVo, int nowPage);
	
	public Map<String, Object> getSearchList(BoardVo boardVo, int nowPage, String search);
	
	public boolean updateMovieHit_Cnt(String movieName);
	
	public BoardVo getDetail(int idx);

	public boolean write(Map<String, Object> param);
	
	public boolean update(BoardVo boardVo);

	public boolean delete(int mv_Idx);
}
