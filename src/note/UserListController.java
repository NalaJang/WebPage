package note;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/note/userExist.do")
public class UserListController implements Controller, DataBinding{
	
	private UsersDao userDao;
	public UserListController setUserDao(UsersDao userDao) {
		this.userDao = userDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {"id", String.class, "pw", String.class};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		String id = (String)model.get("id");
		String pw = (String)model.get("pw");
		
		model.put("user", userDao.exist(id, pw));
		
		return "/project/note/userExist.jsp";
	}

}
