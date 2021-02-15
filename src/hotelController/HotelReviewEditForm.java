package hotelController;

import java.util.Map;

import hotelDao.ReviewDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/reviewEditForm.do")
public class HotelReviewEditForm implements Controller, DataBinding{

	private ReviewDao reviewDao;
	public HotelReviewEditForm setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int qseq = (Integer)model.get("qseq");
		
		model.put("reviewVo", reviewDao.getReview(qseq));
		
		return "/hotel/hotelReviewEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
