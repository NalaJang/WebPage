package hotelController;

import java.util.Map;

import hotelDao.newOrderDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopOrderDelete.do")
public class ShopOrderDeleteController implements Controller, DataBinding{

	private newOrderDao orderDao;
	public ShopOrderDeleteController setCartDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
	
		int oseq = (Integer)model.get("oseq");
		
		if(oseq != 0) {
			orderDao.ordertDelete(oseq);
			
			return "redirect:../hotel/shopOrderList2.do";
			
		} else {
			
			return "redirect:../hotel/shopOrderList2.do";
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"oseq", Integer.class};
	}

}
