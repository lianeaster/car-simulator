import com.intellias.ActionListener;
import com.intellias.enums.CarState;
import com.intellias.models.Car;
import com.intellias.utils.FileUtils;


public class CarSimulator {

    public static void main(String[] args) {
        FileUtils.typeFileLineByLine("D:\\car-simulator\\src\\main\\resources\\Instructions");
        Car car = new Car();
        car.setState(CarState.OFF);
        new ActionListener().listen(car);
    }
}
