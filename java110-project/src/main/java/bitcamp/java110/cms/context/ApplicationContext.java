package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.java110.cms.annotation.Component;

public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception{
        String path = packageName.replace(".", "/");
        
        File file = Resources.getResourceAsFile(path);

        findClass(file, path);
        
    }
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    public String[] getBeanDefinitionNames() {
        Set<String> keySet = objPool.keySet();
        String[] names = new String[keySet.size()];
//        keySet.toArray(names);
//        return names;
        return keySet.toArray(names);
    }
    
    private void findClass(File path, String packagePath) throws Exception {
        File[] files = path.listFiles();

        for(File file : files) {
            
            if(file.isDirectory()) {
                findClass(file, packagePath + "/" + file.getName());
            }   else {
                String className = (packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class", "");
                
                //  1) 클래스 이름을 가지고 .class파일을 찾아 메모리에 로딩한다.
                Class<?> clazz = Class.forName(className);
                
                //  인터페이스인경우 무시한다.
                if(clazz.isInterface())
                    continue;
                try {
                //  2) 로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                //      => 해당 클래스의 생성자 정보를 얻는다.
                Constructor<?> constructor = clazz.getConstructor();
                //      => 생성자를 가지고 인스턴스를 생성한다.
                Object instance = constructor.newInstance();
                
                //      => 클래스에서 Component 애노테이션 정보를 추출한다.
                Component anno = clazz.getAnnotation(Component.class);
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
    }
}