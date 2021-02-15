package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ReviewDao;
import hotelDto.HotelMemberVo;
import hotelDto.ReviewVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/hotelReviewInsert.do")
public class HotelReviewInsertController implements Controller, DataBinding{
	
	private ReviewDao reviewDao;
	public HotelReviewInsertController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			ReviewVo reviewInsert = (ReviewVo)model.get("reviewInsert");
			reviewDao.reviewInsert(reviewInsert, memberVo.getEmail(), memberVo.getName());
			
			return "redirect:../hotel/hotelReviewList.do"; //*****
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"reviewInsert", ReviewVo.class};	//request.getParameter 가 필요할 때는 꼭 써주기.
	}

}
