package basecamp.prehomework.board;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import basecamp.prehomework.board.dto.BoardService;
import basecamp.prehomework.common.map.CommandMap;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	ZonedDateTime timeNow = ZonedDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(CommandMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
    	List<Map<String,Object>> list = boardService.selectBoardList(customMap.getMap());
    	
    	timeNow = ZonedDateTime.now();
    	
    	mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(Model model) {
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "/board/insertBoard.do")
	public ModelAndView insertBoard(CommandMap customMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		
		if(!boardService.insertBoardList(customMap.getMap()))
			mv = new ModelAndView("redirect:/board/boardEmailCheck.do");
		
		return mv;
	}
	
	@RequestMapping(value = "/board/boardCheck.do")
	public ModelAndView inputBoard(CommandMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardCheck");
		mv.addObject("target", customMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardEditCheck.do")
	public ModelAndView editCheckBoard(CommandMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardEdit");
		Map<String, Object> tempMap = boardService.editCheckBoardList(customMap.getMap());
		
		if( tempMap != null)
			mv.addObject("edit", tempMap);
		else
			mv = new ModelAndView("redirect:/board/boardPasswordCheck.do");
		
		return mv;			
	}

	@RequestMapping(value = "/board/boardEdit.do")
	public ModelAndView editBoard(CommandMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		boardService.editBoardList(customMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView deleteBoard(CommandMap customMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		boardService.deleteBoardList(customMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardEmailCheck.do")
	public ModelAndView emailCheckBoard(Model model) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardEmailCheck");
		return mv;
	}
	
	@RequestMapping(value = "/board/boardPasswordCheck.do")
	public ModelAndView passwordCheckBoard(Model model) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardPasswordCheck");
		return mv;
	}

}
