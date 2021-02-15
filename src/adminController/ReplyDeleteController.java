package adminController;

import java.util.Map;

import hotelDao.ReplyDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/admin_delete.do")
public class ReplyDeleteController implements Controller, DataBinding{

	private ReplyDao replyDao;
	public ReplyDeleteController setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int replynum = (Integer)model.get("replynum");
		int qseq = (Integer)model.get("qseq");
		
		replyDao.admin_delete(replynum);
		
		return "redirect:../hotel/hotelReviewContent.do?qseq=" + qseq;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"replynum", Integer.class, "qseq", Integer.class};
	}

}
