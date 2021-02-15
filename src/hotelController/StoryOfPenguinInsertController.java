package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.PenguinBoardDao;
import hotelDto.HotelWorkerVo;
import hotelDto.PenguinBoardVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/storyOfPenguinInsert.do")
public class StoryOfPenguinInsertController implements Controller, DataBinding{
	
	private PenguinBoardDao penguinDao;
	public StoryOfPenguinInsertController setpenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		PenguinBoardVo penguinVo = (PenguinBoardVo)model.get("penguinVo");
		
		if(workerVo.getEmail() == null) {
			
			return "/hotel/login.jsp";
			
		} else {
			penguinDao.insert(penguinVo, workerVo.getEmail());
			
			return "/hotel/storyOfPenguin.jsp";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"penguinVo", PenguinBoardVo.class};
	}

}
