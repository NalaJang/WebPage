package hotelController;

import java.util.Map;

import hotelDao.CampaignReplyDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReplyDelete.do")
public class CampaignReplyDeleteController implements Controller, DataBinding{

	private CampaignReplyDao campaignReplyDao;
	public CampaignReplyDeleteController setCampaignReplyDao(CampaignReplyDao campaignReplyDao) {
		this.campaignReplyDao = campaignReplyDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int replynum = (Integer)model.get("replynum");
		int qseq = (Integer)model.get("qseq");
		
		campaignReplyDao.delete(replynum);
		
		return "redirect:../hotel/campaignReviewContent.do?qseq=" + qseq;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"replynum", Integer.class, "qseq", Integer.class};
	}

}
