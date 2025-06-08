package Model;

public class Consumible extends Producto {

    private double capacidad;

    public Consumible(String id, String nombre, String descripcion, int cantidadStock, double precio, double capacidad) {
        super(id, nombre, descripcion, cantidadStock, precio);
        this.capacidad = capacidad;
    }

    public double getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Consumible{" +
                super.toString() +
                "capacidad=" + capacidad +
                '}';
    }
}
