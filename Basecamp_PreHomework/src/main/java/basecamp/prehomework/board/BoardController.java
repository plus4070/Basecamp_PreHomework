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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//		
//		HashMap<String, String> input = new HashMap<String, String>();
//		input.put("bContent", "content");
//		List<HashMap<String, String>> outputs = sqlSession.selectList("userControlMapper.selectSample", input);
//		System.out.println(outputs.toString());
//		
//		return "home";
//	}
	
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
		
//		System.out.println("-----------------------------------------------------------------");
//		System.out.println(commandMap.getMap());
//		System.out.println("-----------------------------------------------------------------");
		
		boardService.insertBoardList(commandMap.getMap());
		
		return mv;
	}
	
	@RequestMapping(value = "/boardInput")
	public ModelAndView inputBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardInput");
		mv.addObject("target", commandMap.getMap());
		
		return mv;
	}
	
	@RequestMapping(value = "/boardEditCheck")
	public ModelAndView editCheckBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardEditCheck");
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("/boardEditCheck");
		System.out.println(commandMap.getMap());
		System.out.println("-----------------------------------------------------------------");
		
		boardService.editCheckBoardList(commandMap.getMap());

		return mv;
	}

	@RequestMapping(value = "/boardEdit")
	public ModelAndView editBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		
//		boardService.editBoardList(commandMap.getMap());

		return mv;
	}
	
	@RequestMapping(value = "/boardDelete")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(commandMap.getMap());
		System.out.println("-----------------------------------------------------------------");
		
		boardService.deleteBoardList(commandMap.getMap());

		return mv;
	}

}
