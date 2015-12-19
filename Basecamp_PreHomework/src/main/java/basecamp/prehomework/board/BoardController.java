package basecamp.prehomework.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlSession;

	/**
	 * Simply selects the home view to render by returning its name.
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
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(Model model) {

		
		
		return "boardList";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite(Model model) {

		
		
		return "boardWrite";
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard(Model model){
		
		
		
		return "";
	}
	
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public String boardView(Model model) {

		
		
		return "boardView";
	}
	
	@RequestMapping(value = "/boardEdit", method = RequestMethod.GET)
	public String boardEdit(Model model) {

		
		
		return "boardEdit";
	}
	
	

}
