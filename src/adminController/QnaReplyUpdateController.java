package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/qnaReplyUpdate.do")
public class QnaReplyUpdateController implements Controller, DataBinding{

	private HotelQnADao qnaDao;
	public QnaReplyUpdateController setQnaDao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			return "/hotel/loginForm.do";
		
		} else {
			String reply = (String)model.get("reply");
			int qseq = (Integer)model.get("qseq");
			
			model.put("replyList", qnaDao.update(reply, qseq));
			
			return "redirect:../hotel/qnaContent.do?qseq="+qseq;
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"reply", String.class, "qseq", Integer.class};
	}

}
