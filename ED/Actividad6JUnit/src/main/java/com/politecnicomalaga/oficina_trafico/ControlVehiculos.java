package com.politecnicomalaga.oficina_trafico;

import com.politecnicomalaga.DAO.TraficoDAO;
import com.politecnicomalaga.modelo.Persona;
import com.politecnicomalaga.modelo.Vehiculo;

public class ControlVehiculos {
    private TraficoDAO traficoDAO;

    public ControlVehiculos(TraficoDAO traficoDAO){
        this.traficoDAO = traficoDAO;
    }

    public Persona getPropietarioVehiculo(String matricula){
        Vehiculo vehiculo = traficoDAO.getVehiculoByMatricula(matricula);
        String DNI = vehiculo.getDNIPropietario();
        return traficoDAO.getPropietarioByDNI(DNI);
    }
}