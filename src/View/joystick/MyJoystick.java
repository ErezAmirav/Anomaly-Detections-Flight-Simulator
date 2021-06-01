package View.joystick;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyJoystick extends BorderPane {

   public DoubleProperty aileron , elevators , rudder , throttle; // aileron -  X , elevator - Y
    public MyJoystick() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            BorderPane bd = fxml.load(getClass().getResource("Joystick.fxml").openStream());
            MyJoystickController MyJcontroller = fxml.getController();

            aileron = new SimpleDoubleProperty();
            elevators  = new SimpleDoubleProperty();
            rudder = new SimpleDoubleProperty();
            throttle = new SimpleDoubleProperty();

            //
            aileron = MyJcontroller.aileron;
            elevators = MyJcontroller.elevators;
            rudder = MyJcontroller.rudder.valueProperty();
            throttle = MyJcontroller.throttle.valueProperty();
            MyJcontroller.moveJoystick();
            //

            this.getChildren().add(bd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
