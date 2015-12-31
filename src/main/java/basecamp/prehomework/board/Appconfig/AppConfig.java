package basecamp.prehomework.board.Appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import basecamp.prehomework.board.dao.BoardDAO;
import basecamp.prehomework.board.service.BoardService;
import basecamp.prehomework.board.service.BoardServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public BoardService getBoardService() {
		return new BoardServiceImpl();
	}
	
	@Bean
	public BoardDAO getBoardDAO() {
		return new BoardDAO();
	}
	
}
