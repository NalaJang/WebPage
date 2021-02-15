package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/insertForm.do")
public class MemberInsertFormController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "redirect:../hotel/memberInsert.jsp";
	}

}
