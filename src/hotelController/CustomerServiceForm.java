package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/customerServiceForm.do")
public class CustomerServiceForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/serviceCenter.jsp";
	}

}
