package co.kr.wdt.courseevaluationmanagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.wdt.common.dao.CommonSqlDao2;
import co.kr.wdt.courseevaluationmanagement.vo.MovieCategoryVo;
import co.kr.wdt.courseevaluationmanagement.vo.MovieVo;

@Repository
public class CourseEvaluationManagementDao extends CommonSqlDao2 {
	
	private static String PREFIX = "movie.";

	public List<MovieCategoryVo> getCategory() {
		return selectList(PREFIX+ "getCategory");
	}
	
	public List<Map<String, Object>> getMovie() {
		return selectList(PREFIX+ "getMovie");
	}

	public boolean addMovie(MovieVo vo) {
		return (int)insert(PREFIX + "addMovie", vo) == 1;
	}
	
	public MovieVo findMovieOne(int mv_idx) {
		return (MovieVo)selectOne(PREFIX + "findMovieOne", mv_idx);
	}

	public void insertFile(Map<String, Object> map) {
		insert(PREFIX + "insertFile", map);
	}

}
