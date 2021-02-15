package hotelController;

import java.util.Map;

import hotelDao.ShopRoomCartDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomCartdelete_choice.do")
public class RoomCartDelete_choice_Controller implements Controller, DataBinding{

	private ShopRoomCartDao roomCartDao;
	public RoomCartDelete_choice_Controller setRoomCartDao(ShopRoomCartDao roomCartDao) {
		this.roomCartDao = roomCartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int cseq = (Integer)model.get("cseq");
		
		String s = String.valueOf(cseq);
		String cseqArr[] = s.split(",");
		
		
		for(int i = 0; i<cseqArr.length; i++) {
			
			roomCartDao.roomCartDelete(Integer.parseInt(cseqArr[i]));
		}
		
		return "redirect:../hotel/shopRoomCartList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"cseq", Integer.class};
	}

}
