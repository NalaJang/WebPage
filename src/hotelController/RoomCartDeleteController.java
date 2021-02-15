package hotelController;

import java.util.Map;

import hotelDao.ShopRoomCartDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopRoomCartDelete.do")
public class RoomCartDeleteController implements Controller, DataBinding{

	private ShopRoomCartDao roomCartDao;
	public RoomCartDeleteController setRoomCartDao(ShopRoomCartDao roomCartDao) {
		this.roomCartDao = roomCartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		/*
		String cseqArr[] = (String[])((String) model.get("cseq")).split(",");
		
		for(int i = 0; i < cseqArr.length; i++) {
			roomCartDao.roomCartDelete(Integer.parseInt(cseqArr[i]));
			
		}
		return "redirect:../hotel/shopRoomCartList.do";
	}
	*/
		int cseq = (Integer)model.get("cseq");
		
		if(cseq != 0) {
			roomCartDao.roomCartDelete(cseq);
			
			return "redirect:../hotel/shopRoomCartList.do";
			
		} else {
			
			return "redirect:../hotel/shopRoomCartList.do";
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"cseq", Integer.class};
	}

}
