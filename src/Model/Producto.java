package Model;

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private int cantidadStock;
    private double precio;

    public Producto(String id, String nombre, String descripcion, int cantidadStock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadStock=" + cantidadStock +
                ", precio=" + precio +
                '}';
    }


    public String toStringProductoCantidadStock() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadStock=" + cantidadStock +
                '}';
    }
}
