package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.PenguinBoardDao;
import hotelDto.PenguinBoardVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/storyOfPenguinList.do")
public class StoryOfPenguinList implements Controller {

	private PenguinBoardDao penguinDao;
	public StoryOfPenguinList setpenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		ArrayList<PenguinBoardVo> penguinVo = penguinDao.boardList();
		model.put("boardList", penguinVo);
		
		return "/hotel/storyOfPenguinList.jsp";
		
	}

}
