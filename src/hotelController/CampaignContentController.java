package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.CampaignDao;
import hotelDto.CampaignVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/campaignContent.do")
public class CampaignContentController implements Controller, DataBinding{

	private CampaignDao campaignDao;
	public CampaignContentController setCampaignDao(CampaignDao campaignDao) {
		this.campaignDao = campaignDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int num = (Integer)model.get("num");
		model.put("board", campaignDao.getBoard(num));
		
		ArrayList<CampaignVo> boardList = campaignDao.boardList();
		model.put("boardList", boardList);
		
		return "/hotel/CampaignContent.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"num", Integer.class};
	}
}
