package co.kr.wdt.courseevaluationmanagement.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.wdt.courseevaluationmain.service.CourseEvaluationMainService;
import co.kr.wdt.courseevaluationmanagement.dto.CategoryResult;
import co.kr.wdt.courseevaluationmanagement.service.CourseEvaluationManagementService;
import co.kr.wdt.courseevaluationmanagement.vo.MovieCategoryVo;
import co.kr.wdt.courseevaluationmanagement.vo.MovieVo;

@Controller
@RequestMapping("/courseEvaluationManagement")
public class CourseEvaluationManagementController {

	@Autowired
	private CourseEvaluationManagementService courseEvaluationManagementService;
	@Autowired
	private CourseEvaluationMainService courseEvaluationMainService;
	
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	//영화등록
	@RequestMapping(value="/addCourse.do", method=RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("categoryList", courseEvaluationMainService.getMovieCategoryList());
		return "courseevaluationmanagement/addcourse";
	}
	
	//영화등록
	@RequestMapping(value="/addCourse.do", method=RequestMethod.POST)
	public String addMovie(MovieVo vo, HttpServletRequest request) throws Exception {
		courseEvaluationManagementService.addMovie(vo, request);
		return "redirect:/courseEvaluationManagement/getCourseList.do";			
	}

	// 등록영화 조회
	@RequestMapping(value = "/getCourseList.do", method = RequestMethod.GET)
	public String getMovielist(Model model) throws Exception {
		
		model.addAttribute("categoryList", courseEvaluationMainService.getMovieCategoryList());
		model.addAttribute("list", courseEvaluationManagementService.getMovie());
		
		return "courseevaluationmanagement/courselist";
	}
	
	// 등록영화 상세 조회
	@RequestMapping(value = "/courseViewDetail/{mv_idx}.do")
	public String view(Model model, @PathVariable("mv_idx") int mv_idx) throws Exception {
		MovieVo movieVo = courseEvaluationManagementService.getMovieDetail(mv_idx);
		model.addAttribute("categoryList", courseEvaluationMainService.getMovieCategoryList());
		model.addAttribute("movieVo", movieVo);
		
		return "courseevaluationmanagement/getcourse";
	}

	@ResponseBody
	@RequestMapping(value="/courseCategory.do")
	public CategoryResult getCategory() {
		List<MovieCategoryVo> category = courseEvaluationManagementService.getCategory();
		return CategoryResult.success(category);
	}
}
