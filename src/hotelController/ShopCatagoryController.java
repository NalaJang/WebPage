package hotelController;

import java.util.Map;

import hotelDao.ShopProductDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopProductCatagory.do")
public class ShopCatagoryController implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ShopCatagoryController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		String kind = (String)model.get("kind");
		
		model.put("catagory", productDao.selectCatagory(kind));
		
		return "/hotel/shopProduct.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"kind", String.class};
	}


}
