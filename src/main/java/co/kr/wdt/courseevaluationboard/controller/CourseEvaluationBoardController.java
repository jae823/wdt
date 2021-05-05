package co.kr.wdt.courseevaluationboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.wdt.courseevaluationboard.service.CourseEvaluationBoardService;
import co.kr.wdt.courseevaluationboard.vo.BoardVo;
import co.kr.wdt.courseevaluationmain.service.CourseEvaluationMainService;
import co.kr.wdt.security.Auth;
import co.kr.wdt.security.AuthUser;
import co.kr.wdt.user.vo.UserVo;

@Controller
@RequestMapping("/courseEvaluationBoard")
public class CourseEvaluationBoardController {
	
	@Autowired
	private CourseEvaluationBoardService courseEvaluationBoardService;
	@Autowired
	private CourseEvaluationMainService evaluationCourseMainService;
	
	
	// 게시판 글 목록 가져오기
	@RequestMapping(value="/list.do")
	public String getList(Model model, BoardVo boardVo, 
			@RequestParam(defaultValue = "1") int nowPage, 
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "") String movieName) {
		
		Map<String, Object> result = new HashMap<String, Object>(); 
		
		if (!movieName.equals("")) {
			boardVo.setMovieName(movieName);
			courseEvaluationBoardService.updateMovieHit_Cnt(movieName);
		}
		
		if (search.equals("")) {
			result = courseEvaluationBoardService.getBoardList(boardVo, nowPage);	
		} else {
			result = courseEvaluationBoardService.getSearchList(boardVo, nowPage, search);
			model.addAttribute("search", search);
		}
		
		model.addAttribute("categoryList", evaluationCourseMainService.getMovieCategoryList());
		model.addAttribute("movieName", movieName);
		model.addAttribute("list", result.get("list"));
		model.addAttribute("pageVo", result.get("pageVo"));
		return "courseevaluationboard/courseevaluationboardlist";
	}
	
	// 게시판 글 상세
	@RequestMapping(value="view/{idx}.do")
	public String view(Model model, @PathVariable("idx") int idx) {
		BoardVo boardVo = courseEvaluationBoardService.getDetail(idx);
		model.addAttribute("categoryList", evaluationCourseMainService.getMovieCategoryList());
		model.addAttribute("boardVo", boardVo);
		return "courseevaluationboard/courseevaluationboardview";
	}
	
	
	// 게시판 글쓰기 Page
	@Auth
	@RequestMapping(value="/write/{movieName}.do", method=RequestMethod.GET)
	public String writeForm(Model model, @PathVariable("movieName") String movieName) {
		model.addAttribute("categoryList", evaluationCourseMainService.getMovieCategoryList());
		model.addAttribute("movieName", movieName);
		return "courseevaluationboard/courseevaluationboardwrite";
	}
	
	// 게시판 글쓰기 insert
	@Auth
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(@AuthUser UserVo userVo ,BoardVo boardVo,RedirectAttributes redirectAttributes) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userVo", userVo);
		param.put("boardVo", boardVo);
		
		courseEvaluationBoardService.write(param);
		
		if(boardVo.getMovieName() != null) {
			redirectAttributes.addAttribute("movieName", boardVo.getMovieName());	
		}
		return "redirect:/courseEvaluationBoard/list.do";
	}
	
	// 게시판 update Page
	@Auth
	@RequestMapping(value="/update/{idx}.do", method=RequestMethod.GET)
	public String updateForm(@AuthUser UserVo userVo, Model model, @PathVariable("idx") int idx) {
		BoardVo boardVo = courseEvaluationBoardService.getDetail(idx);
		model.addAttribute("categoryList", evaluationCourseMainService.getMovieCategoryList());
		model.addAttribute(boardVo);
		return "/courseevaluationboard/courseevaluationboardupdate";
	}
	
	// 게시판 글 update
	@Auth
	@RequestMapping(value="/update/{idx}.do", method=RequestMethod.POST)
	public String update(@AuthUser UserVo userVo, BoardVo boardVo, @PathVariable("idx") int idx) {
		courseEvaluationBoardService.update(boardVo);
		return "redirect:/courseEvaluationBoard/list.do";
	}
	
	// 게시판 글 delete
	@Auth
	@RequestMapping("/delete/{mv_Idx}.do")
	public String delete(@AuthUser UserVo userVo, @PathVariable("mv_Idx") int mv_Idx) {
		courseEvaluationBoardService.delete(mv_Idx);
		return "redirect:/courseEvaluationBoard/list.do";
	}
}
