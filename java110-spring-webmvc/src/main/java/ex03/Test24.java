// @PathVariable 사용법

package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03/test24")
public class Test24 {
    /* test:
           http://localhost:8888/app/ex03/test24/car/detail?no=100
     */
    @RequestMapping("car/datail")
    public String m1(
            int no,
            Model model) throws Exception {
        /*  Request Handler가 호출될 때
            DBMS에서 해당 번호의 차 정보를 가져 온다고 가정하자!
         */
        Car car = new Car();
        car.setNo(no);
        car.setModel("DB9");
        car.setMaker("AustinMartin");
        car.setAuto(false);
        model.addAttribute("car", car);

        return "ex03/Test24";
    }

    /* test:
        http://localhost:8888/app/ex03/test24/car/200/true
     */
    @RequestMapping("car/{no}/{auto}")
    public String m2(
            @PathVariable int no,
            @PathVariable Boolean auto,
            Model model) throws Exception {
        /*
             PathVariable
         */
        Car car = new Car();
        car.setNo(no);
        car.setModel("DB11");
        car.setMaker("AustinMartin");
        car.setAuto(auto);
        model.addAttribute("car", car);

        return "ex03/Test24";
    }
}