package basecamp.prehomework.board;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import basecamp.prehomework.board.Appconfig.AppConfig;
import basecamp.prehomework.board.dao.BoardDAO;
import basecamp.prehomework.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class JUnitSpringTest {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDAO boardDAO;
	
	static Runnable setup = () -> System.out.println("<-----Set up----->");
	static Runnable finish = () -> System.out.println("<-----finish----->");
	
	@Before
	public void setUp() throws Exception {
		setup.run();
	}

	@Test
	public void testBoardService() {
		assertEquals("class basecamp.prehomework.board.service.BoardServiceImpl",this.boardService.getClass().toString());
	}
	
	@AfterClass
	public static void afterTest() {
		finish.run();
	}

}
