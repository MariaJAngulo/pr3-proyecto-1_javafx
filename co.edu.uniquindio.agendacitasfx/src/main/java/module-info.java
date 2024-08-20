module co.edu.uniquindio.agendacitasfx.adendamiento_citasfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.agendacitasfx.adendamiento_citasfx to javafx.fxml;
    exports co.edu.uniquindio.agendacitasfx.adendamiento_citasfx;
    opens co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
    opens co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller to javafx.fxml;
    opens co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController to javafx.fxml;
    exports co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller;
    exports co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;

}