package projectControls;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/*
 	- 페이지 컨트롤러
 		Controller 인터페이스
 		서블릿 대체. 일반 클래스
 		앞으로 action -> controller 로 교체
 	
 	- DI 를 이용한 빈 의존성 관리
 		1. 의존성 주입(DI : Dependency Injection)
	 		특정 작업을 수행 할 때 사용하는 객체를 "의존 객체"라 부름
	 		이런 의존 객체를 외부에서 주입 -> 결합도가 낮아짐 -> 교체가 쉽고 변경이 용이.
	 		문법 ) 의존 객체를 위한 인스턴스 변수와 셋터 메소드를 준비
 		
 		2. 의존 객체의 관리
	 		의존 객체의 관리롸 주입은 빈 컨테이너가 관리
	 		ContextLoaderListener 가 빈 컨테이너 역할 수행
	 		인터페이스를 통해 의존 객체에 대한 결합도를 낮춤
	 		MemberDao에 인터페이스 적용
 		
 	- 프로퍼티를 이용한 객체 관리
 		1. 프로퍼티 파일(.properties)
	 		하나의 라인은 키 = 값 형태로 구성됨
	 		#으로 시작하면 라인 전체가 주석이 됨
 		
 		2.Properties 클래스
	 		load() 메소드를 통해 프로퍼티 파일을 읽어서 내부 맵에 저장
	 		get(key) 또는 getProperty(key)를 통해 값을 꺼냄
 		
 	- 리플랙션 API 를 이용하여 프론트 컨트롤러 개선하기
 		리플랙션 API (Reflection API)
 		실행 중에 애플리케이션을 조사하고 변경할 때 사용
 		클래스의 멤버(메소드나 변수)의 정보를 손쉽게 탐색 할 수 있음
 		
 		단점)
 		성능을 떨어뜨림 <- 동적인 객체 생성, 메소드 조사
 		보안에 제약 <- 보안 제약이 걸려있는 애플릿에서는 사용할 수 없음
 		내부의 구조의 무분별한 노출 <- private 변수나 메소드의 실행
 		
 		ex)
 		Class classinfo = dto.Member.class;
 		dto.Member member = (dto.Member)classinfo.newInstance(); //동적 객체 생성
 		Method[] methodList = classinfo.getMethods();	//클래스의 정보(calssinfo)로 객체의 정보 가져옴(get)
 		Method method = classinfo.getMemthod("getEmail");
 		for(Method methods : methodList){...}
 		Method m = classinfo.getMethod("setEmail", String.class);
 		dto.Member instance = (dto.Member)class.newInstance();
 		m.invoke(instance, "abc@abc.com");	//setter method 를 찾아옴(invoke)
 		instance.getEamil() -> 실행시 -> "abc@abc.com"
 		
 	- 애노테이션을 이용한 객체 관리
 		1.애노테이션(Annotation)
	 		컴파일이나 배포, 실행할 때 참조할 수 있는 특별한 주석
	 		클래스나 필드, 메소드에 부가 정보 설정
	 		
 		2.애노테이션 유지 정책(RetentionPolicy)
	 		SOURCE  : 컴파일 후 버려짐. 클래스 파일에 없음
	 		CLASS	: 컴파일 후 클래스에 남아 있음. 실행 시에 참조 불가
 			RUNTIME : 컴파일 후 클래스에 남아 있음. 실행 시 참조 가능.
 			
 		3. 애노테이션 정의와 활용 //사용할 수록 코드가 줄어듦
 */
@WebListener //(이벤트가 동작되었을 때 실행되도록 - 컨테이너가 감지한다.)
public class ContextLoaderListener implements ServletContextListener {
	
	static ApplicationContext applicationContext;	//추가
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//커넥션 풀은 네이밍 익셉션
		//sc에 저장
		System.out.println("애플리케이션 시작");//===========================
		
		try {
			ServletContext sc = event.getServletContext(); //서버를 키자마자 호출된다.
			
			System.out.println("event.getServletContext() = " + sc);//===========================

			String propertiesPath = sc.getRealPath(	//추가
					sc.getInitParameter("contextConfigLocation"));	// application-context.properties 의 값을 가지고 ApplicationContext.java 로 간다.
			
			System.out.println("propertiesPath = " + propertiesPath);//===========================
			
			applicationContext = new ApplicationContext(propertiesPath);
			
			System.out.println("applicationContext = " +  applicationContext);//===========================
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
}
