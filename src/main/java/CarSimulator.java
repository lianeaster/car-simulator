import com.intellias.ActionListener;
import com.intellias.InstructionHandler;
import com.intellias.models.Car;


public class CarSimulator {

    public static void main(String[] args) {
        InstructionHandler.loadInstruction();
        Car car = new Car();
        new ActionListener().listen(car);
    }
}
