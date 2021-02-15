package projectControls;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;


public class ApplicationContext {	//실행과 동시에 시작(ContextLoaderListener 의 프로퍼티 값을 가지고 왔다.)
	Hashtable<String,Object> objTable = new Hashtable<String,Object>();
	
	public Object getBean(String key) { //페이지 컨트롤러와 상호작용(.do 를 실행하면 시작)
		
		System.out.println("getBean(String key) = " + key);
		
		return objTable.get(key);
		
	}
	
	public ApplicationContext(String propertiesPath) throws Exception {
		
		System.out.println("propertiesPath1 = " + propertiesPath);
		
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		
		System.out.println("ApplicationContext props = " + props);
		System.out.println("propertiesPath2 = " + propertiesPath);
		
		/*
		참고 :
		reflections-0.9.9-RC1.jar
		pom.xml
		<dependency>
			<groupId>org.reflections</groupId>
			<artifactId>reflections</artifactId>
			<version>0.9.9-RC1</version>
		</dependency>
		*/
		
		prepareObjects(props);
		prepareAnnotationObjects();
		injectDependency();
	}
	
	private void prepareAnnotationObjects() throws Exception {
		Reflections reflector = new Reflections("");
		
		System.out.println("reflector = " + reflector);
		
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class); //pageController 에 대한 class 를 불러옴
		
		System.out.println("Set<Class<?>> list = " + list);
		
		String key = null;
		for(Class<?> clazz : list) {
			key = clazz.getAnnotation(Component.class).value();
			
			System.out.println("clazz.getAnnotation(Component.class).value()= key = " + key);
			System.out.println("clazz.newInstance() = " + clazz.newInstance());
			
			objTable.put(key, clazz.newInstance());
		}
	}

	
	private void prepareObjects(Properties props) throws Exception { //"프로퍼티 정보"를 가져와서 인젝션하고 생성하는 역할
		Context ctx = new InitialContext(); //데이터 소스를 뽑아냄
		String key = null;
		String value = null;
		for (Object item : props.keySet()) {
			key = (String)item;
			value = props.getProperty(key);
			
			System.out.println("(String)item key , value 값");
			
			if(key.startsWith("jndi.")) {
				objTable.put(key, ctx.lookup(value));
				
				System.out.println("objTable.put(key, ctx.lookup(value)) = " + objTable);
				System.out.println("ctx.lookup(value) = " + ctx.lookup(value));
				
			} else {
				objTable.put(key, Class.forName(value).newInstance());
			}
		}
		
	}
	
	private void injectDependency() throws Exception {
		for(String key : objTable.keySet()) {
			
			System.out.println("injectDependency key = " + key);
			System.out.println("injectDependency keySet = " + objTable.keySet());
			
			if(!key.startsWith("jndi.")) {
				callSetter(objTable.get(key));
				
				System.out.println("!key.startsWith(\"jndi.\") = " + key);
			}
		}
	}

	private void callSetter(Object obj) throws Exception {
		Object dependency = null;	//=dao
		for (Method m : obj.getClass().getMethods()) {
			if (m.getName().startsWith("set")) {	//java.lang.ArrayIndexOutOfBoundsException: 이 나서 여기 추가해줌
				dependency = findObjectByType(m.getParameterTypes()[0]);
				
				System.out.println("m = " + m);
				System.out.println("dependency = " + dependency);
				System.out.println("===========callSetter 마침================");
				
				if (dependency != null) {
					m.invoke(obj, dependency);
					
					System.out.println("m.invoke(obj, dependency) = " + m.invoke(obj, dependency));
				}
			}

		}
	}
	
	private Object findObjectByType(Class<?> type) {	// Type 으로 찾는다.(이름, 나이, 등등)
		for(Object obj : objTable.values()) {	// DAO반환
			
			System.out.println("findObjectByType obj  + objTable.values()");
			
			if(type.isInstance(obj)) {
				System.out.println("type.isInstance(obj) = " + type);
				System.out.println("isInstance(obj) = " + obj);
				System.out.println("===========findObjectByType 마침================");
				return obj;
			}
		}
		return null;
	}
	
}
