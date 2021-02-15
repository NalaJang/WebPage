package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/adminPage.do")
public class AdminPageController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "redirect:../hotel/adminPage.jsp";
	}

}
