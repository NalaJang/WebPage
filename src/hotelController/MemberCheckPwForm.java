package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/checkPwForm.do")
public class MemberCheckPwForm implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/memberCheckPw.jsp";
	}

}
