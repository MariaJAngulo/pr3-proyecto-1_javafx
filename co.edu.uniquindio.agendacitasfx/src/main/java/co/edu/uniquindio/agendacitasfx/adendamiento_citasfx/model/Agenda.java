package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;

import lombok.Data;

import java.util.List;
@Data

public class Agenda {
    private Salon salon;
    private List<Cita> citasagendadas= salon.getCita();

}
