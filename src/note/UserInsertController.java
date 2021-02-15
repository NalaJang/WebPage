package note;

import java.util.Map;

import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/note/userInsert.do")
public class UserInsertController implements Controller, DataBinding {

	private UsersDao userDao;
	public UserInsertController setUserDao(UsersDao userDao) {
		this.userDao = userDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"user", UsersVo.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

//		String id = (String)model.get("id");
//		String pw = (String)model.get("pw");
		
		UsersVo user = (UsersVo)model.get("user");
		
		userDao.insert(user);
		
		return "/note/userInsert.jsp";
	}

}
