package adminController;

import java.util.Map;

import hotelDao.ShopProductDao;
import hotelDto.ProductVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/productEdit.do")
public class ProductEditController implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ProductEditController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ProductVo productVo = (ProductVo)model.get("productVo");
		int pseq = (Integer)model.get("pseq");
		
		if(productVo.getPseq() == 0) {
			ProductVo product = productDao.selectOne(pseq);
			model.put("productDetail", product);
			
			return "/hotel/adminProductList.jsp";
			
		} else {
			
			productDao.update(productVo);
			return "redirect:../hotel/productList.do";
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"productVo", ProductVo.class, "pseq", Integer.class};
	}
}
