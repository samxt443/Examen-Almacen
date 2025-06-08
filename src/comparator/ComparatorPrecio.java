package comparator;

import Model.Producto;

import java.util.Comparator;

public class ComparatorPrecio implements Comparator<Producto> {
    @Override
    public int compare(Producto producto1, Producto producto2) {
        return (Double.compare(producto1.getPrecio(), producto2.getPrecio()));
    }
}
