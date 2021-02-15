package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = "/*", 
		initParams= {
				@WebInitParam(name="encoding", value = "UTF-8")
		})
//web.xml 설정이 필요없다.
//애노테이션을 이용한 필터 설정 방법이다. ->초기값을 설정한것
public class CharacterEncodingFilter implements Filter { // 프론트에서 셋 인코딩 없애도된다.
	FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
			throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		nextFilter.doFilter(request, response);

	}
	
	@Override
	public void destroy() {

	}

}
