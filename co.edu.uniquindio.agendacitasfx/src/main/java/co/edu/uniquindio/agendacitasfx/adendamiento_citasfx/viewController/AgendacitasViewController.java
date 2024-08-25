package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;


import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.CitaDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.EmpleadoDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Services.Observer;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller.AgendaCitasController;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cita;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AgendacitasViewController implements Observer {
    ObservableList<CitaDto>listaCitaDto = FXCollections.observableArrayList();
    AgendaCitasController agendaCitasController;
    CitaDto citaSeleccionada;

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
    private TableView<CitaDto> TableViewCitas;

    @FXML
    private TableColumn<CitaDto, String> tcFecha;

    @FXML
    private TableColumn<CitaDto, String> tcNombreCliente;

    @FXML
    private TableColumn<CitaDto, String> tcNombreEmpleado;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtTelefonoCliente;


    @FXML
    void OnbtnActualizar(ActionEvent event) {
        ActualizarCita(citaSeleccionada);
    }


    private void ActualizarCita(CitaDto citaSeleccionada) {
        if (citaSeleccionada != null){
            if(verificarDatos()){
                crearClienteDto();
                CitaDto citaActualizada  = crearCitaDto(crearClienteDto());
                int index = listaCitaDto.indexOf(citaSeleccionada);
                if(index>=0) {
                    listaCitaDto.set(index, citaActualizada);
                    TableViewCitas.refresh();
                }

            }else {
                mostrarMensaje("Error", "Error de Actualización", "Hay campos  necesarios vacíos");
            }
        }else {
            mostrarMensaje("Error", "Error De Actualización","No se selecciono una cita para actualizar" );
        }

    }

    private CitaDto crearCitaDto(ClienteDto clienteDto) {
        CitaDto citaDto = new citaDto();
        citaDto.(clienteDto.getnombre());
        citaDto.setCedulaCliente(clienteDto.getCedula());
        citaDto.setTelefonoCliente(clienteDto.getTelefono());
        citaDto.setFecha(DateFecha.getValue().toString());
    }


    private void mostrarMensaje(String error, String errorDeActualización, String s) {
    }


    @FXML
    void OnbtnAgendaCita(ActionEvent event) {
        AgendarCita();

    }

    private void AgendarCita() {
        if (verificarDatos()) {
            if (agendaCitasController.disponibilidadFecha(DateFecha)) {
                ClienteDto clienteDto = crearClienteDto();
                agendaCitasController.crearCita(clienteDto, DateFecha);
            } else {
                mostrarMensaje("Advertencia", "Fecha Ocupada", "La fecha solicitada no se encuentra disponible", Alert.AlertType.ERROR);
            }
        }
   }

    @FXML
    void OnbtnEliminar(ActionEvent event) {
        eliminarCita(tcFecha.getText());

    }

    private void eliminarCita(String fecha) {
        agendaCitasController.eliminarCita(fecha);
        TableViewCitas.refresh();
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
        initView();
        TableViewCitas.setItems(listaCitaDto);
        agendaCitasController.agregarObserver(this);

    }
    private void initView() {
        initDataBinding();
        obtenerCitasDto();
        listenerSelection();
    }
    

    private void listenerSelection() {
    }

    private void obtenerCitasDto() {
        listaCitaDto.addAll(agendaCitasController.obtenerCitasDto());
    }

    private void initDataBinding() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente()));
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreEmpleado()));
        tcFecha.setCellValueFactory(cellData -> {
            String formattedDate = LocalDate.parse(cellData.getValue().fecha()).format(formatter);
            return new SimpleStringProperty(formattedDate);
        });
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

    @Override
    public void update() {
        listaCitaDto.addAll(agendaCitasController.obtenerCitasDto());
        TableViewCitas.refresh();
    }
}





