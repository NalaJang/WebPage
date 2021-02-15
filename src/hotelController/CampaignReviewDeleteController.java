package hotelController;

import java.util.Map;

import hotelDao.CampaignReviewDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReviewDelete.do")
public class CampaignReviewDeleteController implements Controller, DataBinding{

	private CampaignReviewDao campaignReviewDao;
	public CampaignReviewDeleteController setCampaignReviewDao(CampaignReviewDao campaignReviewDao) {
		this.campaignReviewDao = campaignReviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int qseq = (Integer)model.get("qseq");
		
		campaignReviewDao.delete(qseq);
		
		return "redirect:../hotel/campaignReviewList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
