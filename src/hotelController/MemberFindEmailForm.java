package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/memberFindEmailForm.do")
public class MemberFindEmailForm implements Controller{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/memberFindEmail.jsp";
		
		
	}

}
