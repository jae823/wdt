package co.kr.wdt.courseevaluationmanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.wdt.courseevaluationmanagement.dao.CourseEvaluationManagementDao;
import co.kr.wdt.courseevaluationmanagement.service.CourseEvaluationManagementService;
import co.kr.wdt.courseevaluationmanagement.vo.MovieCategoryVo;
import co.kr.wdt.courseevaluationmanagement.vo.MovieVo;
import co.kr.wdt.utils.FileUtils;

@Service
public class CourseEvaluationManagementServiceImpl implements CourseEvaluationManagementService {
	
	@Autowired
	private CourseEvaluationManagementDao courseEvaluationManagementDao;
	
	@Resource(name="fileUtils") 
	private FileUtils fileUtils;
	
	public List<MovieCategoryVo> getCategory() {
		return courseEvaluationManagementDao.getCategory();
	}

	public boolean addMovie(MovieVo vo, HttpServletRequest request) throws Exception {
		Boolean result = courseEvaluationManagementDao.addMovie(vo); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IDX", String.valueOf(vo.getMv_Idx()));
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for(int i=0, size=list.size(); i<size; i++){ 
			courseEvaluationManagementDao.insertFile(list.get(i)); 
		}
		
		return result;
	}
	
	public MovieVo getMovieDetail(int mv_idx) {
		return courseEvaluationManagementDao.findMovieOne(mv_idx);
	}

	public List<Map<String, Object>> getMovie() {
		return courseEvaluationManagementDao.getMovie();
	}


	
	
}
