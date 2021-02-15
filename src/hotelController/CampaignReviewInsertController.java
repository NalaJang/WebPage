package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.CampaignReviewDao;
import hotelDto.CampaignReviewVo;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReviewInsert.do")
public class CampaignReviewInsertController implements Controller, DataBinding{

	private CampaignReviewDao campaignReviewDao;
	public CampaignReviewInsertController setCampaignReviewDao(CampaignReviewDao campaignReviewDao) {
		this.campaignReviewDao = campaignReviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			CampaignReviewVo reviewInsert = (CampaignReviewVo)model.get("reviewInsert");
			campaignReviewDao.reviewInsert(reviewInsert, memberVo.getEmail(), memberVo.getName());
			
			return "redirect:../hotel/campaignReviewList.do"; //*****
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"reviewInsert", CampaignReviewVo.class};
	}
}
