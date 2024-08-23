package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Factory.ModelFactory;
import javafx.scene.control.DatePicker;

public class AgendaCitasController {
    ModelFactory modelFactory;

    public AgendaCitasController(){

        modelFactory = ModelFactory.getInstance();
    }


    public boolean disponibilidadFecha(DatePicker dateInfo) {

        return modelFactory.disponibilidadFecha(dateInfo);
    }

    public void crearCita(ClienteDto clienteDto, DatePicker dateInfo) {

        modelFactory.crearCita(clienteDto, dateInfo);
    }
}
