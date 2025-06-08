package Model.Comparator;

import Model.Producto;

import java.util.Comparator;

public class ComparatorStock implements Comparator<Producto> {
    @Override
        public int compare(Producto producto1, Producto producto2) {
        return Integer.compare(producto1.getCantidadStock(), producto2.getCantidadStock());
    }
}
