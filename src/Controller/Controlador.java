package Controller;

import Model.Almacen;
import Model.Consumible;
import Model.Periferico;
import Model.Producto;

import java.util.Comparator;
import java.util.List;

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

    public boolean addProducto(Producto producto){
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
