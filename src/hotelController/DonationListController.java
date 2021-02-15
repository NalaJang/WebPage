package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.DonationDao;
import hotelDto.DonationVo;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/donationList.do")
public class DonationListController implements Controller{

	private DonationDao donationDao;
	public DonationListController setDonation(DonationDao donationDao) {
		this.donationDao = donationDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");		
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		int donationTotal = 0;
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
		} else  {
			
			ArrayList<DonationVo> donationList = donationDao.donationList(memberVo.getEmail());			
			
			for(DonationVo dnVo : donationList) {
				donationTotal += dnVo.getMoney();
			}
			
			model.put("donationList", donationList);
			model.put("donationTotal", donationTotal);
			
			return "/hotel/donationList.jsp";
		}
	}


}
