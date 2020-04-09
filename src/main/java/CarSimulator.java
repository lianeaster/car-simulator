import com.intellias.ActionListener;
import com.intellias.enums.CarState;
import com.intellias.models.Car;
import com.intellias.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarSimulator {

    public static void main(String[] args) {
        FileUtils.typeFileLineByLine("src\\main\\resources\\Instructions");
        Car car = new Car();
        log.info("Initial car state is: "+car.getCarState().toString());
        log.info("Initial transmission state is: "+car.getTransmission().getTState().toString());
        new ActionListener().listen(car);
    }
}
