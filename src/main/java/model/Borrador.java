package model;

import exceptions.PrendaException;

import static java.util.Objects.requireNonNull;

public class Borrador {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrimario;
    Color colorSecundario;
    Trama trama = Trama.LISA;
    Float temperaturaMaxima;

    Borrador(TipoPrenda tipoPrenda) {
        this.tipoPrenda = requireNonNull(tipoPrenda,"El tipo de prenda es obligatorio");
    }

    public void conColorPrimario(Color colorPrimario){
        this.colorPrimario = colorPrimario;
    }

    public void conColorSecundario(Color colorSecundario){
        this.colorSecundario = colorSecundario;
    }

    public void conMaterial(Material material){
        this.validarMaterialConsistenteConTipoDePrenda(material);
        this.material = material;
    }

    public void conTemperaturaMaxima(Float temperaturaMaxima){
        this.temperaturaMaxima = temperaturaMaxima;
    }

    private void validarMaterialConsistenteConTipoDePrenda(Material material){
        if(!tipoPrenda.admiteMaterial(material)){
            throw new PrendaException("El material no es compatible con el tipo de prenda.");
        }
    }

    public void conTrama(Trama trama) {
        this.trama = trama;
    }

    private boolean estaTodoSeteado() {
        return material != null && colorPrimario != null && temperaturaMaxima != null;
    }

    public Prenda crearPrenda(){
        if(!estaTodoSeteado()){
            throw new PrendaException("No se especificaron todos los elementos de la prenda.");
        }

        return new Prenda(tipoPrenda,material,colorPrimario,colorSecundario,trama,temperaturaMaxima);
    }


}
