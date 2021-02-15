package projectControls;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {	//정보를 얻어내서 객체화 하고 컨테이너가 관리할 수 있게 한다.
	String value() default "";
}
