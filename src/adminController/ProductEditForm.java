package adminController;

import java.util.Map;

import hotelDao.ShopProductDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/productEditForm.do")
public class ProductEditForm implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ProductEditForm setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;		
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Integer pseq = (Integer)model.get("pseq");
		
		model.put("productDetail", productDao.product_detail(pseq));
		return "/hotel/adminProductEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"pseq", Integer.class};
	}
}
