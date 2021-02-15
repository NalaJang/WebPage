package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.ReplyDao;
import hotelDao.ReviewDao;
import hotelDto.ReplyVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/hotelReviewContent.do")
public class HotelReviewContentController implements Controller, DataBinding {

	private ReviewDao reviewDao;
	public HotelReviewContentController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	private ReplyDao replyDao;
	public HotelReviewContentController setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int qseq = (Integer)model.get("qseq");
		
		reviewDao.viewsUpdate(qseq);								//조회수 증가

		
		model.put("reviewVo", reviewDao.getReview(qseq));			//후기 내용
		
		
		ArrayList<ReplyVo> replyList = replyDao.replyList(qseq);	//댓글 목록
		model.put("replyList", replyList);
		
		return "/hotel/hotelReviewContent.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
