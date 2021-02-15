package adminController;

import java.util.Map;

import hotelDao.newOrderDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/orderResultUpdate.do")
public class OrderResultUpdateController implements Controller, DataBinding{

	private  newOrderDao orderDao;
	public OrderResultUpdateController setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int odseq = (Integer)model.get("odseq");
		
//		model.put("getOdseq", orderDao.getOdseq(odseq));
		
		orderDao.updateResult(odseq);
		
		return "redirect:../hotel/admin_orderList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"odseq", Integer.class};
	}

}
