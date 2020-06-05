package model;

public class AgregarPrenda implements IPropuestaModificacion {
    Prenda prendaAAgregar;

    public void aplicarEn(Guardarropas guardarropas){
        guardarropas.agregarPrenda(prendaAAgregar);
    }
}
