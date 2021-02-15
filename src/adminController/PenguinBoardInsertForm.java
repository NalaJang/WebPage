package adminController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/boardInsertForm.do")
public class PenguinBoardInsertForm implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		return "/hotel/adminPenguinBoardInsert.jsp";
	}

}
