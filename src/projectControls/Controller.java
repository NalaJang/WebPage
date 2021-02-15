package projectControls;

import java.util.Map;

public interface Controller { // action -> controller 로 표현
	String execute(Map<String, Object> model) throws Exception;
}
