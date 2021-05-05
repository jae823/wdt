package co.kr.wdt.courseevaluationmanagement.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import co.kr.wdt.courseevaluationmanagement.vo.MovieCategoryVo;
import co.kr.wdt.courseevaluationmanagement.vo.MovieVo;

public interface CourseEvaluationManagementService {
	
	public List<MovieCategoryVo> getCategory();
	
	public boolean addMovie(MovieVo vo, HttpServletRequest request) throws Exception;
	
	public MovieVo getMovieDetail(int mv_idx);

	public List<Map<String, Object>> getMovie();
}
