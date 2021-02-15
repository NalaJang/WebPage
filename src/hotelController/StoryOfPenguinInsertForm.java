package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/storyOfPenguinInsertForm.do")
public class StoryOfPenguinInsertForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/adminBoardInsert.jsp";
	}

}
