package hotelController;

import java.util.Map;

import hotelDao.ReviewDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/reviewDelete.do")
public class HotelReviewDeleteController implements Controller, DataBinding{

	private ReviewDao reviewDao;
	public HotelReviewDeleteController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int qseq = (Integer)model.get("qseq");
		
		reviewDao.delete(qseq);
		
		return "redirect:../hotel/hotelReviewList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class};
	}

}
