package model;

import static java.util.Objects.requireNonNull;

public class Prenda {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrimario;
    Color colorSecundario;
    Trama trama;
    Float temperaturaMaxima;


    Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario, Color colorSecundario, Trama trama, Float temperaturaMaxima){
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Categoria getCategoria(){
        return tipoPrenda.getCategoria();
    }

    public boolean esAdecuadaParaTemperaturaActual(){
        return new ClimaAdapter().temperaturaCelsius() < temperaturaMaxima;
    }

}