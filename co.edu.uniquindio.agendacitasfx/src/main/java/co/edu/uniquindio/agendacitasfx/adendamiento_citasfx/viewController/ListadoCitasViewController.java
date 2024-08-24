package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.CitaDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.EmpleadoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ListadoCitasViewController {


}

@FXML
void initialize() {
    listaCitasController = new ListadoCitasViewController();
    TableViewCitas.setItems(listaCitas);
    listaCitasController.agregarObservador(this);
    initview();
}

private void initview() {
    initDataBinding();
    obtenerCitasDto();
    listenerSelection();
}

private void obtenerCitasDto() {
    ListaCitas.addAll(ListaCitasController.obtenerCitasDto());
}

private void actualizarCita(CitaDto citaSeleccionada) {
    if (citaSeleccionada != null){
        if(verificarDatos()){
            crearClienteDto();
            creaEmpleadoDto();
            crearCitaDto();
            CitaDto cita =crearCitaDto(crearClienteDto(),creaEmpleadoDto());
            if(cita!=null) {
                citaSeleccionada = new CitaDto(
                        cita.fecha(),
                        cita.nombreCliente(),
                        citaSeleccionada.cedulaCliente(),
                        cita.telefonoCliente(),
                        cita.nombreEmpleado(),
                        cita.idEmpleado(),
                        cita.apellidoEmpleado(),
                        );
                TableViewCitas.refresh();
            }

        }else {
            mostrarMensaje("Error", "Error de Actualización", "Hay campos  necesarios vacíos");
        }
    }else {
        mostrarMensaje("Error", "Error De Actualización","No se selecciono una cita para actualizar" );
    }

}

private boolean verificarDatos() {
    if(txtCedulaCliente.getText().isEmpty()||txtIDManicurista.getText().isEmpty(||txtNombreCliente.getText().isEmpty()||))
}
}

private ClienteDto crearClienteDto() {
    return new ClienteDto(
            txtNombreCliente.getText(),
            txtCedulaCliente.getTxt(),
            txtTelefonoCliente.getText()
    );

}

private void creaEmpleadoDto() {
    return new EmpleadoDto(
            txtNombreEmpleado.getText(),
            null,
            txtIDManicurista.getText()
    );
}

private CitaDto crearCitaDto(CitaDto clienteDto, EmpleadoDto empleadoDto) {
    try {
        String nombreCliente = clienteDto.nombreCliente();
        String cedulaCliente = clienteDto.cedulaCliente();
        String telefonoCliente = clienteDto.telefonoCliente();
        String nombreEmpleado = empleadoDtoDto.nombreEmpleado();
        String idEmpleado = empleadoDto.idEmpleado();

        return new CitaDto(
                "",
                nombreCliente,
                cedulaCliente,
                telefonoCliente,
                nombreEmpleado,
                idEmpleado,
                ""
        );
    }catch (NullPointerException e){
        mostrarMensaje("Error", "Datos Invalidos", "Se ingresaron datos invalidos", Alert.AlertType.ERROR);
    }
}


private void initDataBinding() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente()));
    tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaCliente()));
    txtTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefonoCliente()));
    tcNombreManicurista.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreManicurista()));
    tcIdEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idEmpleado()));
    tcFecha.setCellValueFactory(cellData -> {
        String formattedDate = LocalDate.parse(cellData.getValue().fecha()).format(formatter);
        return new SimpleStringProperty(formattedDate);

    });

}

private void listenerSelection() {
    TableViewCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)-> {
        citasSeleccionada = newSelection;
        mostrarInformacionProducto(citaSeleccionada);
    });

}

private void mostrarInformacionProducto(CitaDto citaSeleccionada) {
    if (citaSeleccionada != null) {
        txtTelefonoCliente.setText(citaSeleccionada.telefonoCliente());
        txtCedulaCliente.setText(citaSeleccionada.cedulaCliente());
        txtIDEmpleado.setText(citaSeleccionada.idEmpleado());
        txtNombreCliente.setText(citaSeleccionada.nombreCliente());
        txtNombreEmpleado.setText(citaSeleccionada.nombreEmpleado());

    }
}
