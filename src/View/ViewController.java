package View;

//import View.Buttoms.MyButtoms;

import View.attList.MyAttList;
import View.btest.MyButtons;


import View.files.MyFiles;
import View.joystick.MyJoystick;


import ViewModel.ViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;


import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class ViewController extends BorderPane implements Observer {

    ViewModel vm;
    @FXML
    MyButtons myButtons;
    @FXML
    MyJoystick myJoystick;

    @FXML
    MyFiles myFiles;

    @FXML
    MyAttList myAttList;


  //  DoubleBinding
    public ViewController(){  }

    void init(ViewModel vm){

        this.vm = vm;

        // my joystick
        myJoystick.aileron.bind(vm.aileron);
        myJoystick.elevators.bind(vm.elevators);
        myJoystick.rudder.bind(vm.rudder);
        myJoystick.throttle.bind(vm.throttle);



        // my buttons
        myButtons.myButtonsController.play=vm.play;
        myButtons.myButtonsController.pause=vm.pause;
        myButtons.myButtonsController.stop=vm.stop;
        myButtons.myButtonsController.forward=vm.forward;
        myButtons.myButtonsController.backward=vm.backward;
        myButtons.myButtonsController.fastbackward=vm.fastbackward;
        myButtons.myButtonsController.fastforward=vm.fastforward;
        myButtons.myButtonsController.timeSlider.valueProperty().bindBidirectional(vm.timeSlider);

        myButtons.setLayoutX(0);
        myButtons.setLayoutY(500);

        myJoystick.setLayoutX(640);
        myJoystick.setLayoutY(80);

        myAttList.setLayoutX(10);
        myAttList.setLayoutY(30);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
