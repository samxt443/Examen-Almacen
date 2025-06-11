package Model;

import Model.Comparator.ComparatorStock;

import java.util.*;



public class Almacen {

    private String id;

    List<Producto> miListaP;
    Map<String, Producto> miMapaP;

    public Almacen(String id) {
        this.id = id;
        miListaP = new ArrayList<>();
        miMapaP = new HashMap<>();
    }

    public String getId(String id) {
        return this.id;
    }

    //1.Añadir producto
    public boolean addProducto(Producto producto) {
        if(producto == null || producto.getPrecio() <= 0) return false; //Producto not null y precio ni 0 ni -
        if(miMapaP.containsKey(producto.getId())) {
            //Cogemos el producto gracias a get
            Producto p = miMapaP.get(producto.getId());
            //Precio
            p.setPrecio(producto.getPrecio());
           //Cantidad de stock
           p.setCantidadStock(p.getCantidadStock() + producto.getCantidadStock());
           return true;
       }else{
           //Añadimos en el mapa y la lista el Producto nuevo
           miListaP.add(producto);
           miMapaP.put(producto.getId(),producto);
           return true;
       }
    }

    //2. Sacar producto
    public boolean sacarProducto(String id, int cantidadStock) {
        if(id == null || cantidadStock == 0) return false;
        /*for(Producto p : miMapaP.values()) {
            if(p.getId().compareTo(id) == 0) {
                if(p.getCantidadStock()== 0 || p.getCantidadStock() < cantidadStock) {
                    return  false;
                }
                p.setCantidadStock(p.getCantidadStock() - cantidadStock);
                return true;
            }
        }
        return false;*/
        Producto p = miMapaP.get(id); //De esta forma con get(id) cogemos en p --> el producto con esa id y luego restamos el Stock
        if(p != null && p.getCantidadStock() >= cantidadStock) {
            p.setCantidadStock(p.getCantidadStock() - cantidadStock);
            return true;
        }
        return false;
    }

    //3. Mostrar todos los productos
    public List<Producto> getListaP() {
        List<Producto> lista = new ArrayList<>(miListaP);
        lista.sort(new ComparatorStock());
        return lista;
    }
    //Lista subtipos
    /*public List<Producto> getListaSubtipo(int opcion) {
        List<Producto> lista = new ArrayList<>();
        String classname = "";
        switch (opcion) {
            case 0 : classname = Periferico.class.getName();
            break;
            case 1 : classname = Consumible.class.getName();
        }

        for(Producto producto : miListaP) {
            if(producto){
               lista.add(producto);
            }
        }

    }*/

    //4.Mostrar productos de un subtipo(periferico o consumibles)
    public List<Periferico> getListaPerifericos() {
        List<Periferico> perifericos = new ArrayList<>();
        for(Producto p : miListaP) {
            if(p instanceof Periferico){ //Con isntance of buscamos solo los productos que queremos
                perifericos.add((Periferico) p); //Index --> Periferico y el Periferico --> p
            }
        }
        return perifericos;
    }

    public List<Consumible> getListaConsumibles() {
        List<Consumible> consumibles = new ArrayList<>();
        for(Producto p : miListaP) {
            if(p instanceof Consumible){
                consumibles.add((Consumible) p);
            }
        }
        return consumibles;
    }

    //5.Ordenar productos por precio

    public List<Producto>  getListaProductos(Comparator<Producto> comparator) {
        List<Producto> productos = new ArrayList<>(miListaP);
        productos.sort(comparator);
        return productos;
    }

    //8. Buscar por id
    public Producto getProducto(String id) {
        //Inecesario
        /*for (Producto p : miListaP) {
            if (p.getId().compareTo(id) == 0) {
                return p;
            }
        }*/
        return miMapaP.get(id);
    }


}
