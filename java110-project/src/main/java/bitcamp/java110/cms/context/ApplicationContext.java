package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;

public class ApplicationContext {
    //  Annotation을 추가할때마다 여기 뜯어고쳐야함?
    HashMap<String, Object> objPool = new HashMap<>();
    ArrayList<Class<?>> classes = new ArrayList<>();

    public ApplicationContext(String packageName) throws Exception{
        String path = packageName.replace(".", "/");

        File file = Resources.getResourceAsFile(path);

        //  패키지 폴더에 있는 클래스를 찾아 클래스를 로딩한 후 그 목록에 저장한다.
        findClass(file, path);

        //  로딩된 클래스 목록을 뒤져서 @Component가 붙은
        //  클래스에 대해 인스턴스를 생성하여 objPool에 보관한다.
        createInstance();
        
        //  objPool에 보관된 객체를 꺼내 @Autowired가 붙은 setter를 찾아 호출,
        //  ->  의존 객체 주입.
        injectDependency();
    }

        //  "이름"으로 찾아 리턴.
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    //  객체 타입으로 objPool에 보관된 객체를 찾아 리턴한다.
    public Object getBean(Class<?> type) {
        //  key는 빼고 value값만 추출함.
        Collection<Object> objlist = objPool.values();
        for(Object obj : objlist) {
            if(type.isInstance(obj))
                return obj;
        }
        return null;
    }

    public String[] getBeanDefinitionNames() {
        Set<String> keySet = objPool.keySet();
        String[] names = new String[keySet.size()];
        return keySet.toArray(names);
    }

    private void findClass(File path, String packagePath){
        File[] files = path.listFiles();

        for(File file : files) {

            if(file.isDirectory()) {
                findClass(file, packagePath + "/" + file.getName());
            }   else {
                String className = (packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class", "");
                
                try {
                //  1) 클래스 이름을 가지고 .class파일을 찾아 메모리에 로딩한다.
                Class<?> clazz = Class.forName(className);
                
                classes.add(clazz); //  로딩한 클래스 정보를 목록에 보관한다.
                }   catch(Exception e) {    }
            }
        }
    }
    private void createInstance(){
        for(Class<?> clazz : classes) {
            //  인터페이스인경우 무시한다.
            if(clazz.isInterface())
                continue;
            
            //      => 클래스에서 Component 애노테이션 정보를 추출한다.
            Component anno = clazz.getAnnotation(Component.class);
            
            //  @Component Annotation이 붙지 않은 클래스는 객체를 생성하지 않는다.
            if(anno == null) continue;
            
            try {
                //  2) 로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                //      => 해당 클래스의 생성자 정보를 얻는다.
                Constructor<?> constructor = clazz.getConstructor();
                //      => 생성자를 가지고 인스턴스를 생성한다.
                Object instance = constructor.newInstance();

                //  !!자바에서 컴파일러가 자동으로 .class라는 변수를 생성함!!
                //  클래스의 정보를 담고있는 변수임.
                //  String을 다루는 클래스 String, Integer를 다루는 클래스 Integer
                //  클래스를 다루는 클래스 class
                //  자바에서 모든 파일은 .class임 (interface, abstract class 뭐든 다 class)임.

                //  =>  Component 애노테이션에 value가 있으면 그값으로 객체를 저장.
                //  ->  없다면 클래스 이름으로 객체를 저장.
                if(anno.value().length() > 0 ) {
                    //  =>  Component 애노테이션 value값으로 인스턴를 objPool에 저장한다.
                    objPool.put(anno.value(), instance);
                }   else {
                    //  =>  클래스 이름으로 객체를 저장.
                    objPool.put(clazz.getName(), instance);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void injectDependency() {
        //  objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = objPool.values();
        
        for(Object obj : objList) {
        //  목록에서 객체를 꺼내 Autowired Annotation이 붙은 method를 찾는다.
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                //  Autowired 없다면,
                if(!m.isAnnotationPresent(Autowired.class)) continue;
//                System.out.println(m.getName());
                //  setter 메소드를 호출하기 위해 parameter값을 준비한다.
//                Class<?>[] pramTypes = m.getParameterTypes();
                
                //  getParameterTypes()
                //  -> parameter값 한개만 추출.
                
                //  setter 메서드의 파라메터 타입을 알아낸다.
                Class<?> paramType = m.getParameterTypes()[0];
                
                //  그 파라메터 타입과 일치하는 객체가 objPool에서 꺼낸다.
                Object dependency = getBean(paramType);
                
                if(dependency == null) continue;
                
                System.out.printf("Call %s()\n", m.getName());
                try {
                m.invoke(obj, dependency);
                }   catch(Exception e) {}
            }
        }
    }
    
}