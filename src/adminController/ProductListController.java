package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopProductDao;
import hotelDto.HotelWorkerVo;
import hotelDto.ProductVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/productList.do")
public class ProductListController implements Controller{

	private ShopProductDao productDao;
	public ProductListController setProductDao(ShopProductDao productDao) {
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

			ArrayList<ProductVo> productList = productDao.productList();
			model.put("productList", productList);
			
			return "/hotel/adminProductList.jsp";
		}
	}

}
