package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/reviewList.do")
public class ReplyListController implements Controller {

	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/hotelReviewContent.do";
	}

}
