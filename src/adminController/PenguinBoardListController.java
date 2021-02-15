package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.PenguinBoardDao;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/boardList.do")
public class PenguinBoardListController implements Controller {

	private PenguinBoardDao penguinDao;
	public PenguinBoardListController setPenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			
			model.put("boardList", penguinDao.boardList());
			
			return "/hotel/adminPenguinBoardList.jsp";
		}
	}

}
