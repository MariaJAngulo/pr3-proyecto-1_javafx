package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.CitaDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller.AgendaCitasController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AgendacitasViewController {
    AgendaCitasController agendaCitasController;

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
        AgendarCita();

    }

    private void AgendarCita() {
        if (verificarDatos()) {
            if (AgendaCitasController.disponibilidadFecha(DateFecha)) {
                ClienteDto clienteDto = crearClienteDto();
                AgendaCitasController.crearCita(clienteDto,DateFecha);
            } else {
                mostrarMensaje("Advertencia","Fecha Ocupada", "La fecha solicitada no se encuentra disponible", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void OnbtnEliminar(ActionEvent event) {

    }

    @FXML
    void onbtnCancelar(ActionEvent event) {

    }
    private void CancelarAngendamiento() {
    txtCedulaCliente.setText("");
    txtNombreCliente.setText("");
    txtTelefonoCliente.setText("");
    DateFecha.setValue(null);


    }

    @FXML
    void initialize() {
        agendaCitasController = new AgendaCitasController();
    }



    private ClienteDto crearClienteDto() {
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
        if (txtCedulaCliente.getText().equals("") || txtNombreCliente.getText().equals("") || txtTelefonoCliente.getText().equals("")) {
            mostrarMensaje("Error", "Campos Nulos", "Hay campos sin rellenar.", Alert.AlertType.ERROR);
            resultado = false;
        } else if (fecha.isBefore(LocalDate.now())) {
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





