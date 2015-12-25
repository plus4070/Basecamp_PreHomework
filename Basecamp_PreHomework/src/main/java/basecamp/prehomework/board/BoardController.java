package basecamp.prehomework.board;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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

	Logger logger = Logger.getLogger(BoardController.class);

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/boardList")
	public ModelAndView boardList(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardList");
    	List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
    	mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "/boardWrite")
	public ModelAndView boardWrite(Model model) {
		ModelAndView mv = new ModelAndView("/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "/insertBoard")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		boardService.insertBoardList(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/boardCheck")
	public ModelAndView inputBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardCheck");
		mv.addObject("target", commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/boardEditCheck")
	public ModelAndView editCheckBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardEdit");
		Map<String, Object> tempMap = boardService.editCheckBoardList(commandMap.getMap());
		if( tempMap != null){
			System.out.println(tempMap.entrySet());
			mv.addObject("edit", tempMap);
		}else{
			mv = new ModelAndView("redirect:/boardList");
		}
		return mv;			
	}

	@RequestMapping(value = "/boardEdit")
	public ModelAndView editBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		boardService.editBoardList(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/boardDelete")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		boardService.deleteBoardList(commandMap.getMap());
		return mv;
	}

}
