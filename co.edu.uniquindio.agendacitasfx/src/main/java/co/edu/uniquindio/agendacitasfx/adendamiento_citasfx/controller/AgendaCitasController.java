package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Factory.ModelFactory;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.viewController.AgendacitasViewController;
import javafx.scene.control.DatePicker;

public class AgendaCitasController {
    ModelFactory modelFactory;

    public AgendacitasViewController(){

        modelFactory = ModelFactory.getInstance();
    }

    public boolean disponibilidadFecha(DatePicker dateInfo) {
        return modelFactory.disponibilidadFecha(dateInfo);
    }

    public void crearCita(ClienteDto clienteDto, DatePicker dateInfo) {
        modelFactory.crearCita(clienteDto, dateInfo);
    }
}
