package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import javafx.scene.control.DatePicker;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Salon {
    private String nombre;
    private List<Cita> cita= new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cita> getCita() {return cita;}

    public void setCita(List<Cita> cita) {
        this.cita = cita;
    }

    public boolean disponibilidadFecha(DatePicker dateInfo){
        boolean disponibilidad = true;
        LocalDate fecha = dateInfo.getValue();
        for (Cita cita : cita) {
            return false;
        }
    }
    return disponibilidad;
}
