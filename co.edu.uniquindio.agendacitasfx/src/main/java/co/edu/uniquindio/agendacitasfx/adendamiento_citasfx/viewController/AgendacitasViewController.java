package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AgendacitasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DateFecha;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgendaCita;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<?, ?> tcFecha;

    @FXML
    private TableColumn<?, ?> tcNombreCliente;

    @FXML
    private TableColumn<?, ?> tcNombreManicurista;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    void OnbtnActulializar(ActionEvent event) {

    }

    @FXML
    void OnbtnAgendaCita(ActionEvent event) {

    }

    @FXML
    void OnbtnEliminar(ActionEvent event) {

    }

    @FXML
    void onbtnCancelar(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}

