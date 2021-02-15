package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.CampaignReviewDao;
import hotelDto.CampaignReviewVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/campaignReviewList.do")
public class CampaignReviewListController implements Controller{

	private CampaignReviewDao campaignReviewDao;
	public CampaignReviewListController setCampaignReviewDao(CampaignReviewDao campaignReviewDao) {
		this.campaignReviewDao = campaignReviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		ArrayList<CampaignReviewVo> campaignReview = campaignReviewDao.reviewList();
		
		model.put("reviewList", campaignReview);
		
		return "/hotel/campaignReviewList.jsp";
	}

}
