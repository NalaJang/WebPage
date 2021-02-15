package hotelController;

import java.util.Map;

import hotelDao.ShopCartDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopCartDelete.do")
public class ShopCartDeleteController implements Controller, DataBinding{

	private ShopCartDao cartDao;
	public ShopCartDeleteController setCartDao(ShopCartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		/*
		int cseq = (Integer)model.get("cseq");
		String s = String.valueOf(cseq);
		String cseqArr[] = s.split(",");
		
		
		for(int i = 0; i<cseqArr.length; i++) {
			
			cartDao.cartDelete(Integer.parseInt(cseqArr[i]));
		}
		*/

		int cseq = (Integer)model.get("cseq");
		
		if(cseq != 0) {
			cartDao.cartDelete(cseq);
			
			return "redirect:../hotel/shopCartList.do";
			
		} else {
			
			return "redirect:../hotel/shopCartList.do";
		}
		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"cseq", Integer.class};
	}

}
