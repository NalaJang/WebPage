package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.HotelMemberDao;
import hotelDto.AddressVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberAddress.do")
public class MemberAddressController implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberAddressController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		String dong = (String)model.get("dong");
		ArrayList<AddressVo> address = memberDao.address(dong);
		
		model.put("address", address);
		
		return "redirect:../hotel/memberAddress.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"dong", String.class};
	}

}
