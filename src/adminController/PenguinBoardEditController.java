package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.PenguinBoardDao;
import hotelDto.HotelWorkerVo;
import hotelDto.PenguinBoardVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/boardEdit.do")
public class PenguinBoardEditController implements Controller, DataBinding{

	private PenguinBoardDao penguinDao;
	public PenguinBoardEditController setPenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			
			int num = (Integer)model.get("num");
			
			penguinDao.getBoard(num);
			
			return "/hotel/login.jsp";
			
		} else {
			
			PenguinBoardVo boardVo = (PenguinBoardVo)model.get("boardVo");
			
			penguinDao.update(boardVo);
			return "redirect:../hotel/boardList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"num", Integer.class, "boardVo", PenguinBoardVo.class};
	}

}
