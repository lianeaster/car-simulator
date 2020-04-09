import com.intellias.ActionListener;
import com.intellias.enums.CarState;
import com.intellias.models.Car;
import com.intellias.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarSimulator {

    public static void main(String[] args) {
        FileUtils.typeFileLineByLine("D:\\car-simulator\\src\\main\\resources\\Instructions");
        Car car = new Car();
        log.info("Current car state is: "+car.getCarState().toString());
        new ActionListener().listen(car);
    }
}
