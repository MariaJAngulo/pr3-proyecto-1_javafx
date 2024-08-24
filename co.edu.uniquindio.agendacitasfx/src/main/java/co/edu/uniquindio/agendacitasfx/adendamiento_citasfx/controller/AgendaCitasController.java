package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.controller;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mappings.Mapper.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Factory.ModelFactory;
import javafx.scene.control.DatePicker;

public class AgendaCitasController {
    static ModelFactory modelFactory;

    public AgendaCitasController(){

        modelFactory = ModelFactory.getInstance();
    }


    public static boolean disponibilidadFecha(DatePicker dateInfo) {

        return modelFactory.disponibilidadFecha(dateInfo);
    }

    public static void crearCita(ClienteDto clienteDto,DatePicker dateFecha) {

        modelFactory.crearCita(clienteDto, dateFecha);
    }
}
