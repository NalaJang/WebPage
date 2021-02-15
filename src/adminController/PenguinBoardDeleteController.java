package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.PenguinBoardDao;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/boardDelete.do")
public class PenguinBoardDeleteController implements Controller, DataBinding{

	private PenguinBoardDao penguinDao;
	public PenguinBoardDeleteController setPenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			
			return "/hotel/login.do";
			
		} else {
			
			int num = (Integer)model.get("num");
			
			penguinDao.delete(num);
			
			return "redirect:../hotel/boardList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"num", Integer.class};
	}

}
