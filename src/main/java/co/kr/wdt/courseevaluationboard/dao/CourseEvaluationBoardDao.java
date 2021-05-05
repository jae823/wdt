package co.kr.wdt.courseevaluationboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.wdt.common.dao.CommonSqlDao2;
import co.kr.wdt.courseevaluationboard.vo.BoardVo;

@Repository
public class CourseEvaluationBoardDao extends CommonSqlDao2 {

	private static String PRIFIX = "board.";
	
	public List<BoardVo> findAll(Map<String, Object> param) {
		return selectList(PRIFIX + "findAll", param);
	}

	public int updateMovieHit_Cnt(String movieName) {
		return (int) update(PRIFIX + "updateMovieHit_Cnt", movieName);
	}
	
	public int findAllTotalCount(Map<String, Object> param) {
		return (int) selectOne(PRIFIX + "findAll_totalCount", param);
	}
	
	public BoardVo findOne(int idx) {
		return (BoardVo) selectOne(PRIFIX + "findOne", idx);
	}
	
	public List<BoardVo> search(Map<String, Object> param) {
		return selectList(PRIFIX + "board.search", param);
	}
	
	public int searchTotalCount(Map<String, Object> param) {
		return (int) selectOne(PRIFIX + "search_totalCount", param);
	}
	
	public int updateHit_Cnt(int mv_Idx) {
		return (int) update(PRIFIX + "updateHit_Cnt", mv_Idx);
	}
	
	public int insert(Map<String, Object> param) {
		return (int) insert(PRIFIX + "insert", param);
	}
	
	public int delete(int mv_Idx) {
		return (int) update(PRIFIX + "delete", mv_Idx);
	}
	
	public int update(BoardVo boardVo) {
		return (int) update(PRIFIX + "update", boardVo);
	}


}
