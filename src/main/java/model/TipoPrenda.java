package model;

import java.util.Arrays;
import java.util.List;

public enum TipoPrenda{
    ZAPATO(Categoria.CALZADO, Arrays.asList(Material.CUERO,Material.ALGODON)),
    PANTALON(Categoria.PARTE_INFERIOR, Arrays.asList(Material.CUERO,Material.ALGODON,Material.JEAN)),
    CAMPERA(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.CUERO,Material.ALGODON,Material.JEAN,Material.TELA_IMPERMEABLE)),
    BOTA(Categoria.CALZADO, Arrays.asList(Material.CUERO,Material.GOMA)),
    REMERA(Categoria.PARTE_SUPERIOR,Arrays.asList(Material.ALGODON)),
    SANDALIA(Categoria.CALZADO,Arrays.asList(Material.CUERO, Material.GOMA)),
    SHORTS(Categoria.PARTE_INFERIOR,Arrays.asList(Material.ALGODON));

    List<Material> materialesAdecuados;
    Categoria categoria;

    TipoPrenda(Categoria categoria, List<Material> materialesAdecuados){
        this.categoria = categoria;
        this.materialesAdecuados = materialesAdecuados;
    }

    public boolean admiteMaterial(Material material){
        return getMaterialesAdecuados().contains(material);
    }

    private List<Material> getMaterialesAdecuados() {
        return materialesAdecuados;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
