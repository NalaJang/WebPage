package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/memberFindPwForm.do")
public class MemberFindPwForm implements Controller{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/memberFindPw.jsp";
		
		
	}

}
