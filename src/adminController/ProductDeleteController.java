package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopProductDao;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/productDelete.do")
public class ProductDeleteController implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ProductDeleteController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			return "/hotel/login.do";
		} else {

			int pseq = (Integer)model.get("pseq");
			
			productDao.delete(pseq);
			return "redirect:../hotel/productList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"pseq", Integer.class};
	}

}
