package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.CampaignReplyDao;
import hotelDao.CampaignReviewDao;
import hotelDto.CampaignReplyVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignReviewContent.do")
public class CampaignReviewContentController implements Controller, DataBinding {

	private CampaignReviewDao campaignReviewDao;
	public CampaignReviewContentController setCampaignReviewDao(CampaignReviewDao campaignReviewDao) {
		this.campaignReviewDao = campaignReviewDao;
		return this;
	}

	private CampaignReplyDao campaignReplyDao;
	public CampaignReviewContentController setCampaignReplyDao(CampaignReplyDao campaignReplyDao) {
		this.campaignReplyDao = campaignReplyDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int qseq = (Integer)model.get("qseq");
		
		campaignReviewDao.viewsUpdate(qseq);								//조회수 증가

		
		model.put("reviewVo", campaignReviewDao.getReview(qseq));			//후기 내용
		
		ArrayList<CampaignReplyVo> replyList = campaignReplyDao.replyList(qseq);			//댓글 목록
		model.put("replyList", replyList);
		
		return "/hotel/campaignReviewContent.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
