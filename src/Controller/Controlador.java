package Controller;

import Model.Almacen;
import Model.Consumible;
import Model.Periferico;
import Model.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Controlador {

    private static Controlador singleton;
    Almacen almacen;
    private Controlador() {
        almacen = new Almacen("");
    }
    public static Controlador getSingleton() {
        if (singleton == null) {
            singleton = new Controlador();
        }
        return singleton;
    }

    public void setData(String id){
        almacen.getId(id);
    }

    public boolean addProducto(Map<String,String> mapita){
        Producto producto=null;
        if (mapita.get("Clase").equals("Producto")) {
            producto = new Producto(mapita.get("id"), mapita.get("nombre"), descripcion, cantidad, precio);
        } else if (mapita.get("Clase").equals("Consumible")) {
            producto = new Consumible(mapita.get("id"), mapita.get("nombre"), descripcion, cantidad, precio);
        }
        return almacen.addProducto(producto);
    }

    public boolean sacarProducto(String id,int CantidadStock){
        return almacen.sacarProducto(id,CantidadStock);
    }

    public List<Producto> getListProducto(){
        return almacen.getListaP();
    }

    public List<Producto> getListProducto(Comparator<Producto> comparator){
        return almacen.getListaProductos(comparator);
    }

    public List<Periferico> getListaPeriferico(){
        return almacen.getListaPerifericos();
    }
    public List<Consumible> getListaConsumible(){
        return almacen.getListaConsumibles();
    }

    public void grabarFichero(){
        ControladorFichero.grabarFichero(almacen);
    }

    public void cargarFichero(){
        ControladorFichero.cargarFichero(almacen);
    }

    public Producto buscarproducto(String id){
        return almacen.getProducto(id);
    }
}
