package hotelController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import hotelDao.newOrderDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopOrderInsert2.do")
public class ShopOrderInsertController2 implements Controller, DataBinding{

	private newOrderDao orderDao;
	
	public ShopOrderInsertController2 setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
//		CartVo cartVo = (CartVo)session.getAttribute("cartVo");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			
			List<String> cseqList = new ArrayList<>();
			List<Integer> pseq = new ArrayList<>();
			List<Integer> quantity = new ArrayList<>();
			
			String value = (String)model.get("cseq");
			int oseq = 0;
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(value, ",");
			
			while (st.hasMoreTokens()) {	//파싱된 개수 만큼 반복
				cseqList.add(st.nextToken());
				
			}
			
			for (String cseq : cseqList) {
				StringTokenizer st2 = new StringTokenizer(cseq, "@");	//한번 더 파싱
				pseq.add(Integer.parseInt(st2.nextToken()));
				quantity.add(Integer.parseInt(st2.nextToken()));
				
			}
			
			try {
				result = orderDao.addOrder(memberVo.getEmail());
				
				if(result > 0) {	//성공 했을 때(newDao 의 addOrder 에서 insert 성공 시 return 되기 때문)
					oseq = orderDao.getOseq(memberVo.getEmail());
					
					if(oseq > 0) {	//주문 할 상품이 존재할 경우
						result = orderDao.newOrder_detail(oseq, pseq, quantity);	//상품상세에 insert
						
							if(result > 0) {
								orderDao.newUpdateCart(memberVo.getEmail(), pseq);	//장바구니 상품 없애기(update)
							
							}					
					}
				}
			} catch (Exception e) {

			}
			return "redirect:../hotel/shopCartList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {

		return new Object[] {"cseq", String.class};
	}
}

