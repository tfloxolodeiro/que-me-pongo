package model;

import java.util.List;

public class Guardarropas {
    String criterio;
    List<Prenda> prendas;
    List<IPropuestaModificacion> propuestasModificacion;

    public void agregarPrenda(Prenda prendaAAgregar){
        prendas.add(prendaAAgregar);
    }
    public void removerPrenda(Prenda prendaARemover){
        prendas.remove(prendaARemover);
    }

    public void proponerModificacion(IPropuestaModificacion propuesta){
        propuestasModificacion.add(propuesta);
    }

    public void aceptarModificacion(IPropuestaModificacion propuesta){
        propuesta.aplicarEn(this);
        removerPropuesta(propuesta);
    }

    public void rechazarModificacion(IPropuestaModificacion propuesta){
        removerPropuesta(propuesta); //Asumo que rechazar una modificacion implica removerla
    }

    private void removerPropuesta(IPropuestaModificacion propuesta){
        propuestasModificacion.remove(propuesta);
    }

    public List<IPropuestaModificacion> getPropuestasModificacion(){
        return propuestasModificacion;
    }

}
