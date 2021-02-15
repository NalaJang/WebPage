package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.CampaignDao;
import hotelDto.CampaignVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/campaignList.do")
public class CampaignListController implements Controller{

	private CampaignDao campaignDao;
	public CampaignListController setCampaignDao(CampaignDao campaignDao) {
		this.campaignDao = campaignDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		ArrayList<CampaignVo> campaignVo = campaignDao.boardList();
		
		model.put("boardList", campaignVo);
		
		return "/hotel/campaignForPenguin.jsp";
	}

}
