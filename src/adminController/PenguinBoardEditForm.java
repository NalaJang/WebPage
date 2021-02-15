package adminController;

import java.util.Map;

import hotelDao.PenguinBoardDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/boardEditForm.do")
public class PenguinBoardEditForm implements Controller, DataBinding{

	private PenguinBoardDao penguinDao;
	public PenguinBoardEditForm setPenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int num = (Integer)model.get("num");
		
		model.put("penguinVo", penguinDao.getBoard(num));
		
		return "/hotel/adminPenguinBoardEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"num", Integer.class};
	}

}
