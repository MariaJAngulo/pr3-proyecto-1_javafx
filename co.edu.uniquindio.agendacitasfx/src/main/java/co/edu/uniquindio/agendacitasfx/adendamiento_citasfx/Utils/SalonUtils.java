package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.Utils;

import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cita;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Cliente;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Empleado;
import co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model.Salon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SalonUtils {
    private Salon salon;

    private Salon inicializarDatos(){
        salon.setNombre("Perfect Nails");

        Empleado empleado = new Empleado();
        empleado.setNombre("karen");
        empleado.getApellido("muñoz");
        empleado.setIdEmpleado("123456");
        salon.getEmpleados().add(empleado);

        Cliente cliente= new Cliente();
        cliente.setNombre("karen");
        cliente.setCedula("12345678");
        cliente.setTelefono("31374563");
        salon.getClientes().add(cliente);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Cita cita= new Cita();
        cita.setFecha(LocalDate.parse("25/08/2024"));
        cita.setClienteAsociado(cliente);
        cita.setClienteAsociado(empleado);
        salon.getCita().add(cita);

        return salon;

    }
}