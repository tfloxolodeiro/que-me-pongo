package model;

public class RemoverPrenda implements IPropuestaModificacion {
    Prenda prendaARemover;

    public void aplicarEn(Guardarropas guardarropas){
        guardarropas.removerPrenda(prendaARemover);
    }

}
