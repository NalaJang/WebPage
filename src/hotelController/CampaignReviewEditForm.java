package hotelController;

import java.util.Map;

import hotelDao.CampaignReviewDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReviewEditForm.do")
public class CampaignReviewEditForm implements Controller, DataBinding{

	private CampaignReviewDao campaignReviewDao;
	public CampaignReviewEditForm setCampaignReviewDao(CampaignReviewDao campaignReviewDao) {
		this.campaignReviewDao = campaignReviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int qseq = (Integer)model.get("qseq");
		
		model.put("reviewVo", campaignReviewDao.getReview(qseq));
		
		return "/hotel/campaignReviewEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
