package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception{
        //  패키지 이름을 파일 경로로 바꾸기.
        String path = packageName.replace(".", "/");
//        System.out.println(path);
        
        //  패키지경로를 절대경로로 알아온다. 
        File file = Resources.getResourceAsFile(path);
        //  file 우리가생각하는 추상적 파일의 의미와, 디렉토리까지 파일임.
                    //  resoursec 현재 클래스를 실행하는 jvm class path 뒤져서 찾음.
//        System.out.println(file.getAbsolutePath());
        
        //  package 폴더에 들어있는 파일 목록 알아낸다.
        findClass(file, path);
        
        //  1) 인스턴스 생성.
        //  해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후.
        //  objPool에 보관한다.
    }
    // objectPool에 보관된 객체를 이름으로 찾아 리턴한다.
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    private void findClass(File path, String packagePath) throws Exception {
//        String[] fileNames = path.list();   //  list 파일, 디렉토리 구분 못함.
        File[] files = path.listFiles();

        for(File file : files) {
//            System.out.println(packagePath);
            
            if(file.isDirectory()) {
                findClass(file, packagePath + "/" + file.getName());
                //  와 미친; 재귀 호출 : 자기 자신을 마치 다른 사람인냥 부르는것.
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
                
                //      => 이름으로 인스턴스의 필드를 찾는다.
                Field filed = clazz.getField("name");
                
                //      => name 필드의 값을 꺼낸다.
                Object name = filed.get(instance);
                
//                System.out.println(inst.getClass());
                
//                System.out.println(clazz.getName() + "===>" + name);
                
                //  => "name" 필드의 값으로 인스턴스를 objPool에 저장한다.
                objPool.put((String)name, instance);
                            //  이놈이 원래 타입이 이것이라고 알려주는것.
                            //  typeCast 
                            //  typeConversion 형변환은 이란것은 없다는것.
                } catch (Exception e) {
                    e.printStackTrace();
//                    System.out.printf("%s 클래스는 기본 생성자가 없습니다.",
//                            clazz.getName());
                }
            }
        }
    }
/*    
    public static void main(String[] args) {
        System.out.println(sigma(5));
    }
    public static int sigma(int a) {
        if(a == 0) {
            return 0;
        }
        return a + sigma(a - 1);
    }
*/    //  수학 공식 sigma. sigma(n) = n + sigma(n-1)
    //  재귀 메소드 쓰는 이유, 속도는 느리지만 코드가 간결하다. 너무 깊게가면 stackOverFlow
    //  stack memory에 쌓아서 호출함으로 새로운 메소드로 만들어옴.
    //  debuger로 stack쌓이는걸 볼수 있다.
    //  f5 step into, f6 step over
    //  메소드 호출 실행 방향도 볼수 있음.
}