package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Factory;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Dto.ClienteDto;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Mapper.SalonMapper;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Utils.SalonUtils;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cita;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cliente;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Salon;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class ModelFactory {
    private static ModelFactory modelFactory;
     Salon salon;


    public static ModelFactory getInstance(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        salon = SalonUtils.inicializarDatos();
    }

    public boolean disponibilidadFecha(DatePicker dateInfo) {
        return salon.disponibilidadFecha(dateInfo);
    }

    public void crearCita(ClienteDto clienteDto, DatePicker dateInfo) {
        LocalDate fecha = dateInfo.getValue();

        Cliente cliente = SalonMapper.INSTANCE.ClienteDtoToCliente(clienteDto);
        Cita cita = new Cita();
        cita.setFecha(fecha);
        cita.setClienteAsociado(cliente);
        cita.getEmpleadoAsociado(salon.getEmpleados().getFirst());
        salon.getCita().add(cita);
    }
}