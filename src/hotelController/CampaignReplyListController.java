package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/campaignReplyList.do")
public class CampaignReplyListController implements Controller {

	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/campaignReviewContent.do";
	}

}
