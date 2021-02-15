package hotelController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/qnaInsertForm.do")
public class QnAInsertForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/qnaInsert.jsp";
	}

}
