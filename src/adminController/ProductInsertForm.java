package adminController;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/productInsertForm.do")
public class ProductInsertForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/hotel/adminProductInsert.jsp";
	}

}
