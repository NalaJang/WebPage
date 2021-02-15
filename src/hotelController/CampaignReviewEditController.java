package hotelController;

import java.util.Map;

import hotelDao.CampaignReviewDao;
import hotelDto.CampaignReviewVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReviewEdit.do")
public class CampaignReviewEditController implements Controller, DataBinding{

	private CampaignReviewDao campaignreviewDao;
	public CampaignReviewEditController setReviewDao(CampaignReviewDao campaignreviewDao) {
		this.campaignreviewDao = campaignreviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int qseq = (Integer)model.get("qseq");
		CampaignReviewVo reviewVo = (CampaignReviewVo)model.get("reviewVo");
		
		if(qseq == 0) {
			campaignreviewDao.getReview(qseq);
			
			return "redirect:../hotel/campaignReviewList.do";
		} else {
			
			campaignreviewDao.update(reviewVo);
			
			return "redirect:../hotel/campaignReviewContent.do?qseq=" + qseq;
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class, "reviewVo", CampaignReviewVo.class};
	}

}
