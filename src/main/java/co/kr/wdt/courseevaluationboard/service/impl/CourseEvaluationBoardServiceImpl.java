package co.kr.wdt.courseevaluationboard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.wdt.courseevaluationboard.dao.CourseEvaluationBoardDao;
import co.kr.wdt.courseevaluationboard.service.CourseEvaluationBoardService;
import co.kr.wdt.courseevaluationboard.vo.BoardVo;
import co.kr.wdt.courseevaluationboard.vo.PageVo;

@Service
public class CourseEvaluationBoardServiceImpl implements CourseEvaluationBoardService {

	@Autowired
	private CourseEvaluationBoardDao courseEvaluationBoardDao;
	
	
	public Map<String, Object> getBoardList(BoardVo boardVo, int nowPage) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("movieName", boardVo.getMovieName());
		int totalCount = courseEvaluationBoardDao.findAllTotalCount(param);
		
		PageVo pageVo = new PageVo(totalCount, 5, nowPage);
		
		param.put("start", (pageVo.getNowPage()-1)*pageVo.getCntPerPage());
		param.put("end", pageVo.getCntPerPage());
		List<BoardVo> list = courseEvaluationBoardDao.findAll(param); 
		
		result.put("pageVo", pageVo);
		result.put("list", list);
		
		return result;
	}
	
	public Map<String, Object> getSearchList(BoardVo boardVo, int nowPage, String search) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>(); 
		
		param.put("searchText", "%"+search+"%");
		param.put("movieName", boardVo.getMovieName());
		int totalCount = courseEvaluationBoardDao.searchTotalCount(param);
		PageVo pageVo = new PageVo(totalCount, 5, nowPage);
		
		param.put("start", (pageVo.getNowPage()-1)*pageVo.getCntPerPage());
		param.put("end", pageVo.getCntPerPage());
		List<BoardVo> list = courseEvaluationBoardDao.search(param);
		
		result.put("pageVo", pageVo);
		result.put("list", list);
		
		return result;
	}
	
	public boolean updateMovieHit_Cnt(String movieName) {
		return courseEvaluationBoardDao.updateMovieHit_Cnt(movieName) == 1;
	}
	
	public BoardVo getDetail(int idx) {
		courseEvaluationBoardDao.updateHit_Cnt(idx);
		return courseEvaluationBoardDao.findOne(idx);
	}

	public boolean write(Map<String, Object> param) {
		return courseEvaluationBoardDao.insert(param) == 1;
	}
	
	public boolean update(BoardVo boardVo) {
		return courseEvaluationBoardDao.update(boardVo) == 1;
	}

	public boolean delete(int mv_Idx) {
		return courseEvaluationBoardDao.delete(mv_Idx) == 1;
	}





	
	
}
