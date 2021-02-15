package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/donationCOU.do")
public class DonationContentsOfUseController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/donationContentsOfUse.jsp";
	}

}
