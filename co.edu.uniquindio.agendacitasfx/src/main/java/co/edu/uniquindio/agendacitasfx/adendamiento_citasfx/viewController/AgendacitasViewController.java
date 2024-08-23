package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller.AgendaCitasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
        btnAgendaCita();

    }

    @FXML
    void OnbtnEliminar(ActionEvent event) {

    }

    @FXML
    void onbtnCancelar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        AgendaCitasController = new AgendaCitasController();
    }

    private void agendarCita() {
        if(verificarDatos()){
            if(AgendaCitasController.disponibilidadFecha(DateFecha)){
                ClienteDto clienteDto = crearClienteDto();
                AgendaCitasController.crearCita(clienteDto);
            }else {
                mostrarMensaje("Advertencia", "Fecha Ocupada", "La fecha solicitada no se encuentra disponible");
            }
        }
    }

    private void crearClienteDto() {
        ClienteDto clienteDto = new ClienteDto(
                txtNombreCliente.getText(),
                txtCedulaCliente.getText(),
                txtTelefonoCliente.getText()
        );
        return clienteDto;
    }

    private boolean verificarDatos() {
        boolean resultado = true;
        LocalDate fecha = DateFecha.getValue();
        if (txtCedulaCliente.getText().equals("") || txtNombreCliente.getText().equals("")||txtTelefonoCliente.getText().equals("")){
            mostrarMensaje("Error", "Campos Nulos", "Hay campos sin rellenar.", Alert.AlertType.ERROR);
            resultado = false;
        }else if (fecha.isBefore(LocalDate.now())) {
            mostrarMensaje("Error", "Fecha Nula o Incorrecta", "La fecha ingresada es nula o anterior al dia actual", Alert.AlertType.ERROR);
            resultado = false;
        }
        return resultado;

    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.show();
    }


    private boolean verificarDatos() {
        boolean resultado = true;
        LocalDate fecha = DateInfo.getValue();
        if(txtCedulaCliente.getText().equals("") || txtNombreCliente.getText().equals("") || txtTelefonoCliente.getText().equals("")) {
            mostrarMensaje("Error", "Campos Nulos", "Hay campos necesarios sin rellenar", Alert.AlertType);
            resultado = false;
        }else if (fecha.isBefore(LocalDate.now())) {
            mostrarMensaje("Error", )
            return false;
        }
        return true;
    }

}



