package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopProductDao;
import hotelDto.HotelWorkerVo;
import hotelDto.ProductVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/productInsert.do")
public class ProductInsertController implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ProductInsertController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			
			return "/hotel/login.jsp";
		} else {
			ProductVo productVo = (ProductVo)model.get("productVo");
			productDao.insert(productVo);
			
			return "redirect:../hotel/productList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"productVo", ProductVo.class};
	}

}
