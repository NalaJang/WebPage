package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.PenguinBoardDao;
import hotelDto.PenguinBoardVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/storyOfPenguinContent.do")
public class StoryOfPenguinContent implements Controller, DataBinding{
	
	private PenguinBoardDao penguinDao;
	public StoryOfPenguinContent setpenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int num = (Integer)model.get("num");
		model.put("board", penguinDao.getBoard(num));
		
		ArrayList<PenguinBoardVo> boardList = penguinDao.boardList();
		model.put("boardList", boardList);
		
		return "/hotel/storyOfPenguin2.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"num", Integer.class};
	}

}
