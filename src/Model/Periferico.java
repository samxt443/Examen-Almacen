package Model;

public class Periferico extends Producto {

    private boolean inalambrico;
    private String observaciones;

    public Periferico(String id, String nombre, String descripcion, int cantidadStock, double precio, boolean inalambrico, String observaciones) {
        super(id, nombre, descripcion, cantidadStock, precio);
        this.inalambrico = inalambrico;
        this.observaciones = observaciones;
    }

    public boolean isInalambrico() {
        return inalambrico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "Periferico{" +
                super.toString() +
                "inalambrico=" + inalambrico +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }

}
