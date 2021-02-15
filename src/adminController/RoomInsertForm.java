package adminController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/roomInsertForm.do")
public class RoomInsertForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/adminRoomInsert.jsp";
	}

}
