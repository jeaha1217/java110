// @MartixVariable 사용법

package ex03;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex03/test25")
public class Test25 {
    /* test:
           http://localhost:8888/app/ex03/test25/search/car/
     */
    @RequestMapping("search/{keyword}")
    public String m1(
            @PathVariable String keyword,
            Model model) throws Exception {
        /*  

         */

        return String.format("keyword=%s", keyword);
    }

    /* test:
            http://localhost:8888/app/ex03/test25/search/DB9/Black/true/2019
     */
    @RequestMapping("search/{car}/{color}/{auto}/{year}")
    public String m1_2(
            @PathVariable String car,
            @PathVariable String color,
            @PathVariable Boolean auto,
            @PathVariable int year,
            Model model) throws Exception {

        return String.format("car=%s, color=%s, auto=%b, year=%d",
                car, color, auto, year);
    }

    /* 
            @MatrixVariable annotation을 사용하려면 
            스프링 설정을 활성화 시켜야 한다.
            1) XML 설정
                <mvc:annotation-driven enable-matrix-variables="true"/>

            2) JavaConfig 설정

                @EnableWebMvc   <== 이 annotation을 추가한다.
                public class AppConfig{
                    ...
                }
        test:
            http://localhost:8888/app/ex03/test25/search2/car=DB9;color=Black;auto=true;year=2019
     */
    @RequestMapping(value="search2/{value}",
                    produces="text/plain;charset=UTF-8")
    public String m2(
            @PathVariable String value,
            @MatrixVariable String car,
            @MatrixVariable String color,
            @MatrixVariable Boolean auto,
            @MatrixVariable int year,
            Model model) throws Exception {
        //  알아서 parse해줌 ㄷㄷㄷ
        return String.format("value:%s\ncar=%s, color=%s, auto=%b, year=%d",
                value, car, color, auto, year);
    }
    /*
http://localhost:8888/app/ex03/test25/search2/;car=test;color=Black;auto=true;year=2019
  ..?

      test:
        .../search3/model/car=DB9;color=Black;/spec/auto=true;year=2019
        
        PathVariable 이름이 다르더라도 Metrix변수이름으로 값을 추출할 수 있다. 
      */
    @RequestMapping(value="search3/model/{value1}/spec/{value2}",
                    produces="text/plain;charset=UTF-8")
    public String m3(
            @MatrixVariable String car,
            @MatrixVariable String color,
            @MatrixVariable Boolean auto,
            @MatrixVariable int year,
            Model model) throws Exception {
        //  
        return String.format("car=%s, color=%s, auto=%b, year=%d",
                car, color, auto, year);
    }

    // test:
    //  .../search4/car/model=DB9;year=2019/spec/model=AT1;year=2019;
    @RequestMapping(value="search4/car/{value1}/spec/{value2}",
                    produces="text/plain;charset=UTF-8")
    public String m4(
            //  PathVariable이 다르고, Metrix 변수 이름이 같을 때?
            //  PathVariable과 Matrix 변수 이름을 명확하게 해야한다.
            @MatrixVariable(pathVar="value1", name="model") String cmodel,
            @MatrixVariable(pathVar="value1", name="year") int cyear,
            @MatrixVariable(pathVar="value2", name="model") String tmodel,
            @MatrixVariable(pathVar="value2", name="year") int tyear,
            Model model) throws Exception {
        //  
        return String.format("car=%s(%d), spec=%s(%d)",
                cmodel, cyear, tmodel, tyear);
    }
    
 /* PathVariable에 정규 표현식
    
    
    test:
        http://localhost:8888/app/ex03/test25/search5/2001020211_16v4

        .../search5/{l1:[0-9][0-9]} <== 숫자 두자리 
                    {l2:[0-9][0-9]}
                    {l3:[0-9][0-9]}
                    {l4:[0-9][0-9]}
                    {no:[0-9]+}_{yr[0-9\+]}v{ver:[a-z0-9]}
                         |ㅏ 숫자 한개 이상
*/
    @RequestMapping(value="search5/{l1:[0-9][0-9]}" + 
                          "{l2:[0-9][0-9]}" + 
                          "{l3:[0-9][0-9]}" + 
                          "{l4:[0-9][0-9]}" + 
                          "{no:[0-9][0-9]}_{yr:[0-9]*}v{ver:[a-z0-9]}",
                    produces="text/plain;charset=UTF-8")
    public String m5(
            @PathVariable String l1,
            @PathVariable String l2,
            @PathVariable String l3,
            @PathVariable String l4,
            @PathVariable String no,
            @PathVariable String yr,
            @PathVariable String ver ) throws Exception {
        //  규칙에 맞는지 확인함.
        return String.format("%s,%s,%s,%s,%s,%s%s",
                l1, l2, l3, l4, no, yr, ver);
    }
    
}   //  보안 강화 하는 방법, 쓰는 시점에만 요소를 추가하라.