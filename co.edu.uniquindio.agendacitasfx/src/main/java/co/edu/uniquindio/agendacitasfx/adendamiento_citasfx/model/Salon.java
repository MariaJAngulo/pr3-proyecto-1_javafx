package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Salon {
    private String nombre;
    private List<Cita> cita= new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> cliente = new ArrayList<>();
}
