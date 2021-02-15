package projectControls;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectControls.ApplicationContext;
import projectControls.ContextLoaderListener;
import projectControls.DataBinding;
import projectControls.ServletRequestDataBinder;

@SuppressWarnings("serial")
@WebServlet("*.do") //=all.do
public class DispatcherServlet extends HttpServlet {
//				---------------------------------------
//							프론트 컨트롤					//빈의 객체 생성, 사용자의 정보를 가져오기 위한 분기문
//				---------------------------------------
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();
		try {
//			ServletContext sc = this.getServletContext();	//주석
			
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();	//추가
			System.out.println("디스패처");
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", request.getSession());
//			Controller controller = (Controller) sc.getAttribute(servletPath); //page control로 사용자 요청 분석해서 control 로 형변환되어서 나온다. 그러면 controller 가 빈이 되고 dao 를 사용할 수 있다.
			
			Controller controller = (Controller) ctx.getBean(servletPath);	//추가 //controller 가 page controller 의 instance 가 된다.

				if(controller instanceof DataBinding) {
					prepareRequestData(request, model, (DataBinding)controller);
				}
				String viewUrl = controller.execute(model);	//controller 실행
				for (String key : model.keySet()) {
					request.setAttribute(key, model.get(key));
				}
				if(viewUrl.startsWith("redirect:")) {	//이러한 문자열을 갖는 스트링이 넘어오면..
					response.sendRedirect(viewUrl.substring(9));
					return;
				} else {
					RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
					rd.include(request, response);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding) throws Exception {
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i = 0; i < dataBinders.length; i += 2) {	//2개의 값이 한 쌍이기 때문에
			dataName = (String)dataBinders[i];
			dataType = (Class<?>)dataBinders[i + 1];
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);	//데이터가 가공하고 생성되어지는 부분
			model.put(dataName, dataObj);	//실행구조의 5번 부분 -> 6번(execute)
		}
	}

}
/*
 * 참고 > 리스트.do 가 없는 이유 는 멤버의 정보가 필요하지 않기 때문.
 * */
