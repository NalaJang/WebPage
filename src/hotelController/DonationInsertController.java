package hotelController;

import java.util.Map;

import hotelDao.DonationDao;
import hotelDto.DonationVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/donationInsert.do")
public class DonationInsertController implements Controller, DataBinding{
	
	private DonationDao donationDao;
	public DonationInsertController setDonationDao(DonationDao donationDao) {
		this.donationDao = donationDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		DonationVo donationVo = (DonationVo)model.get("donationVo");
		donationDao.insert(donationVo);
		
		return "/hotel/main.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"donationVo", DonationVo.class};
	}

}
