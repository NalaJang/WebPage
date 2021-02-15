package hotelController;

import java.util.Map;

import hotelDao.newOrderDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/orderConfirm.do")
public class ShopOrderConfirmController implements Controller, DataBinding{

	private newOrderDao orderDao;
	public ShopOrderConfirmController setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int odseq = (Integer)model.get("odseq");
		
		orderDao.updateResult2(odseq);
		
		return "redirect:../hotel/shopOrderList2.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"odseq", Integer.class};
	}

}
