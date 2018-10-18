package ex06;

public class EngineFactory2 {
    
    public Engine create(String model) {
        Engine e = new Engine();
        
        switch (model) {
        case "B100":
            e.setMaker("BitCar");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "B200":
            e.setMaker("BitCar");
            e.setValve(32);
            e.setDiesel(true);
            break;
        case "H01":
            e.setMaker("흉기");
            e.setValve(16);
            e.setDiesel(false);
            break;
        case "HX9":
            e.setMaker("흉기");
            e.setValve(32);
            e.setDiesel(true);
            break;
        default:
            e.setMaker("오호라Car");
            e.setValve(8);
            e.setDiesel(false);
        }
        return e;
    }
}








