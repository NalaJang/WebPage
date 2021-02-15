package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/logout.do")
public class LogoutController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		
		return "redirect:../hotel/main.do";
	}

}
