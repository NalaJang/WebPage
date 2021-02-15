package adminController;

import java.util.Map;

import hotelDao.CampaignReplyDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignAdmin_delete.do")
public class CampaignAdminReplyDeleteController implements Controller, DataBinding{

	private CampaignReplyDao campaignReplyDao;
	public CampaignAdminReplyDeleteController setCampaignReplyDao(CampaignReplyDao campaignReplyDao) {
		this.campaignReplyDao = campaignReplyDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int replynum = (Integer)model.get("replynum");
		int qseq = (Integer)model.get("qseq");
		
		campaignReplyDao.admin_delete(replynum);
		
		return "redirect:../hotel/campaignReviewContent.do?qseq=" + qseq;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"replynum", Integer.class, "qseq", Integer.class};
	}

}
