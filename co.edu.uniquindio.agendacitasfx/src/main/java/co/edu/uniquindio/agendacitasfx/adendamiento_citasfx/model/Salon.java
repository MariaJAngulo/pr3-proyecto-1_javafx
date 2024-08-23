package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Salon {
    private String nombre;
    private List<Cita> citas = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public String getNombre() {
        return nombre;}

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Salon(String nombre, List<Cita> cita, List<Empleado> empleados, List<Cliente> clientes) {
        this.nombre = nombre;
        this.citas = cita;
        this.empleados = empleados;
        this.clientes = clientes;
    }

    public boolean disponibilidadFecha(DatePicker dateInfo) {
        boolean disponibilidad = true;
        LocalDate fecha = dateInfo.getValue();
        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha)) {
                return false;
            }
        }
        return disponibilidad;
    }
}

