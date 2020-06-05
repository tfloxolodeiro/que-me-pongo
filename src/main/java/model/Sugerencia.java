package model;

import java.util.Arrays;
import java.util.List;

public class Sugerencia {
    IServicioMeteorologico servicioMeteorologico;

    public Sugerencia(IServicioMeteorologico servicioMeteorologico) {
        this.servicioMeteorologico = servicioMeteorologico;
    }


    public List<Prenda> atuendoRecomendado(String direccion){
        if(haceCalor(direccion)){
            return atuendoParaCalor();
        }

        if(puedeLlover(direccion)){
            return atuendoParaLluvia();
        }
        //...
    }

    private List<Prenda> atuendoParaCalor() {
        //Si se conociece una coleccion de prendas se podrian filtar segun si son adecuadas para la temperatura actual.
        //Pero como no puedo hacer eso, creo el atuendo manualmente con prendas que ya se que son adecuadas para la temperatura actual.
        Borrador borradorRemeraMangaCorta = new Borrador(TipoPrenda.REMERA);
        borradorRemeraMangaCorta.conColorPrimario(new Color(255,255,255));
        //...
        Prenda remeraMangaCorta = borradorRemeraMangaCorta.crearPrenda();

        Borrador borradorSandalias = new Borrador(TipoPrenda.SANDALIA);
        borradorSandalias.conColorPrimario(new Color(0,0,0));
        //...
        Prenda sandalias = borradorSandalias.crearPrenda();

        Borrador borradorShorts = new Borrador(TipoPrenda.SHORTS);
        borradorShorts.conColorPrimario(new Color(255,255,255));
        //...
        Prenda shorts = borradorShorts.crearPrenda();

        return Arrays.asList(remeraMangaCorta,sandalias,shorts);

    }

    private List<Prenda> atuendoParaLluvia() {
        Borrador borradorDeCampera = new Borrador(TipoPrenda.CAMPERA);
        borradorDeCampera.conColorPrimario(new Color(0,0,0));
        //...
        Prenda campera = borradorDeCampera.crearPrenda();

        Borrador borradorDeBotas = new Borrador(TipoPrenda.BOTA);
        borradorDeBotas.conColorPrimario(new Color(0,0,0));
        //...
        Prenda botas = borradorDeBotas.crearPrenda();

        Borrador borradorDePantalon = new Borrador(TipoPrenda.PANTALON);
        borradorDePantalon.conColorPrimario(new Color(0,0,255));
        //...
        Prenda pantalon = borradorDePantalon.crearPrenda();

        return Arrays.asList(campera,botas,pantalon);

    }

    private boolean haceCalor(String direccion) {
        return servicioMeteorologico.temperaturaCelsius(direccion) > 30;
    }

    private boolean puedeLlover(String direccion) {
        return servicioMeteorologico.probabilidadesDePrecipitacion(direccion) > 0.8;
    }
    //Estos 2 metodos suenan como que no deberian ser responsabilidad de la Sugerencia, pero puede ser que tenga sentido que...
    //la sugerencia sepa a partir de que temperatura tiene sentido llevar ropa para calor y a partir de que porcentaje de probabilidad...
    //tiene sentido llevar ropa de lluvia.


}
