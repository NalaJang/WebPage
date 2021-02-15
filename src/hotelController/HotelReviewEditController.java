package hotelController;

import java.util.Map;

import hotelDao.ReviewDao;
import hotelDto.ReviewVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/reviewEdit.do")
public class HotelReviewEditController implements Controller, DataBinding{

	private ReviewDao reviewDao;
	public HotelReviewEditController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int qseq = (Integer)model.get("qseq");
		ReviewVo reviewVo = (ReviewVo)model.get("reviewVo");
		
		if(qseq == 0) {
			reviewDao.getReview(qseq);
			
			return "redirect:../hotel/hotelReviewList.do";
		} else {
			
			reviewDao.update(reviewVo);
			
			return "redirect:../hotel/hotelReviewContent.do?qseq=" + qseq;
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class, "reviewVo", ReviewVo.class};
	}

}
