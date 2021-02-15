package hotelController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import hotelDao.ShopCartDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/cartDelete_choice.do")
public class ShopCartDelete_choice_Controller implements Controller, DataBinding{

	private ShopCartDao cartDao;
	public ShopCartDelete_choice_Controller setCartDao(ShopCartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		List<String> cseqList = new ArrayList<>();
		List<Integer> pseq = new ArrayList<>();
		List<Integer> quantity = new ArrayList<>();
		
		String value = (String)model.get("cseq");
		
		StringTokenizer st = new StringTokenizer(value, ",");
		
		while (st.hasMoreTokens()) {	//파싱된 개수 만큼 반복
			cseqList.add(st.nextToken());
			
		}
		
		for (String cseq : cseqList) {
			StringTokenizer st2 = new StringTokenizer(cseq, "@");	//한번 더 파싱
			pseq.add(Integer.parseInt(st2.nextToken()));
			quantity.add(Integer.parseInt(st2.nextToken()));
			
		}
		
		cartDao.cartDelete_choice(pseq, quantity);
		
		return "redirect:../hotel/shopCartList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"cseq", String.class};
	}

}
