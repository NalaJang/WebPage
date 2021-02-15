package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.CampaignReplyDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReplyInsert.do")
public class CampaignReplyInsertController implements Controller, DataBinding{
	
	private CampaignReplyDao campaignReplyDao;
	public CampaignReplyInsertController setCampaignReplyDao(CampaignReplyDao campaignReplyDao) {
		this.campaignReplyDao = campaignReplyDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			int qseq = (Integer)model.get("qseq");
			String content = (String)model.get("content");
			
			campaignReplyDao.replyInsert(qseq, memberVo.getEmail(), content, memberVo.getName());
			
			return "redirect:../hotel/campaignReviewContent.do?qseq="+qseq;
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq" , Integer.class, "content", String.class};
	}

}
