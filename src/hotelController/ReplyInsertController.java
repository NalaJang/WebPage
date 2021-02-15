package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ReplyDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/replyInsert.do")
public class ReplyInsertController implements Controller, DataBinding{
	
	private ReplyDao replyDao;
	public ReplyInsertController setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
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
			
			replyDao.replyInsert(qseq, memberVo.getEmail(), content, memberVo.getName());
			
			return "redirect:../hotel/hotelReviewContent.do?qseq="+qseq;
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq" , Integer.class, "content", String.class};	//request.getParameter 가 필요할 때는 꼭 써주기.
	}

}
