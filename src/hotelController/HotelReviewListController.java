package hotelController;

import java.util.Map;

import hotelDao.ReviewDao;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/hotelReviewList.do")
public class HotelReviewListController implements Controller {

	private ReviewDao reviewDao;
	public HotelReviewListController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("hotelReviewList", reviewDao.reviewList());
		
		/*
		String pageNumber = "1";
		String pageNum = (String)model.get("pageNum");
		
		if(pageNum != null) {
			pageNumber = pageNum;
		}
//		ArrayList<ReviewVo> reviewList = reviewDao.getList(pageNumber);
		model.put("page", reviewDao.getList(pageNumber));
		*/
		return "/hotel/hotelReviewList2.jsp";
	}

}
