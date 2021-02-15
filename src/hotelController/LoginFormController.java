package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/loginForm.do")
public class LoginFormController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/login.jsp";
	}

}
