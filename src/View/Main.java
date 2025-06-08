package View;

import Controller.Controlador;
import Controller.ControladorFichero;
import Model.Comparator.ComparatorStock;
import Model.Consumible;
import Model.Periferico;
import Model.Producto;

import java.util.Comparator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcion;
        Controlador.getSingleton().setData("ES25");

        do {
            mostrarMenu();
            System.out.println("Introduzca la opción a realizar (0 salir)");
            opcion = leerValorInt();
            realizarOpcion(opcion);

        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("--------------------------------");
        System.out.println("Menú de Gestión de la Taller");
        System.out.println("1. Añadir producto (si ya existe aumentar cantidad)");
        System.out.println("2. Sacar producto (si existe y hay la cantidad solicitada)");
        System.out.println("3. Mostrar todos los productos y cantidades");
        System.out.println("4. Mostrar los productos de un subtipo (periféricos o consumibles)");
        System.out.println("5. Ordenar productos por precio");
        System.out.println("6. Grabar Fichero");
        System.out.println("7. Cargar Fichero");
        System.out.println("8. Buscar producto por id");
        System.out.println("0. Salir");
        System.out.println("--------------------------------");
    }

    public static int leerValorInt() {
        return (new Scanner(System.in)).nextInt();
    }
    public static int leerValorIntTexto(String texto) {
        System.out.println("Introduzca "+texto);
        return (new Scanner(System.in)).nextInt();
    }

    public static String leerValor(String texto) {
        System.out.println("Introduzca " + texto);
        return (new Scanner(System.in)).nextLine();
    }

    public static boolean leerValorBoolean(String texto) {
        System.out.println("Introduzca " + texto + "(True para si, False para no)");
        return (new Scanner(System.in)).nextBoolean();
    }

    public static double leerValorDouble(String texto) {
        System.out.println("Introduzca " + texto);
        return (new Scanner(System.in)).nextDouble();
    }
    public static void realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                addProducto();
                break;
            case 2:
                sacarProducto();
                break;
            case 3:
                mostrarProductos();
                break;
            case 4:
                mostrarProductosSubtipo();
                break;
            case 5:
                ordenarPrecio();
                break;
            case 6:
                grabarFichero();
                break;
            case 7:
                cargarFichero();
                break;
            case 8:
                buscarProducto();
                break;
            case 9:

                break;
            case 10:

                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public static void addProducto() {
        System.out.println("¿Qué producto desea añadir?\n1.Periferico\n2.Consumible");
        int opcion = leerValorInt();
        tipoDeProducto(opcion);
    }

    public static void tipoDeProducto(int opcion) {
        switch(opcion){
            case 1: añadirPeriferico();
            break;
            case 2: añadirConsumible();
            break;
        }
    }

    public static void añadirPeriferico() {
        Periferico periferico = new Periferico(leerValor("id"),leerValor("nombre"),leerValor("descripcion"),leerValorIntTexto("cantidad de Stock"),leerValorDouble("precio"),leerValorBoolean("inalambrico"),leerValor("observaciones"));
        if(Controlador.getSingleton().addProducto(periferico)) {
            System.out.println("Periferico añadido con exito");
        }else{
            System.out.println("Error al añadir el periferico");
        }
    }

    public static void añadirConsumible() {
        Consumible consumible = new Consumible(leerValor("id"),leerValor("nombre"),leerValor("descripcion"),leerValorIntTexto("cantidad de Stock"),leerValorDouble("precio"),leerValorDouble("capacidad"));
        if(consumible.getCapacidad() > 0) {
            if(Controlador.getSingleton().addProducto(consumible)) {
                System.out.println("Consumible añadido con exito");
            }else{
                System.out.println("Error al añadir el consumible");
            }
        }
    }

    public static void sacarProducto() {
        System.out.println("Sacar producto: restaremos stock");
        String id = leerValor("id");
        int stock = leerValorIntTexto("cantidad de stock");
        if (Controlador.getSingleton().sacarProducto(id,stock)){
            System.out.println("Productos sacados con exito");
        }else{
            System.out.println("Productos no sacados con exito (No hay suficiente canticad de stock o id equivocado)");
        }
    }

    public static void mostrarProductos() {
        System.out.println("..................\nProductos:\n..............");
        for (Producto producto : Controlador.getSingleton().getListProducto(new ComparatorStock())){
            System.out.println(producto.toStringProductoCantidadStock());
        }
    }

    public static void mostrarProductosSubtipo(){
        System.out.println("¿Qué producto desea ver?\n1.Todos\n2.Periferico\n3.Consumible");
        int opcion = leerValorInt();
        mostrarProductosSubtipo(opcion);
    }

    public static void mostrarProductosSubtipo(int opcion) {
        switch (opcion) {
            case 1:
                verTodos();
                break;
            case 2:
                verPerifericos();
                break;
            case 3:
                verConsumibles();
                break;
        }
    }

    public static void verTodos() {
        System.out.println("..................\nProductos:\n..............");
        for (Producto producto : Controlador.getSingleton().getListProducto()){
            System.out.println(producto.toString());
        }
    }

    public static void verPerifericos() {
        System.out.println("..................\nPerifericos:\n..............");
        for (Periferico periferico : Controlador.getSingleton().getListaPeriferico()){
            System.out.println(periferico.toString());
        }
    }

    public static void verConsumibles() {
        System.out.println("..................\nConsumibles:\n..............");
        for (Consumible consumible : Controlador.getSingleton().getListaConsumible()){
            System.out.println(consumible.toString());
        }
    }

    public static void ordenarPrecio(){
        System.out.println("..................\nProductos x Precio:\n..............");
        for (Producto p : Controlador.getSingleton().getListProducto(new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        })){
            System.out.println(p.toString());
        }
    }

    public static void grabarFichero(){
        Controlador.getSingleton().grabarFichero();
    }

    public static void cargarFichero(){
        Controlador.getSingleton().cargarFichero();
    }

    public static void buscarProducto(){
        String id = leerValor("id");
        if (Controlador.getSingleton().buscarproducto(id) == null){
            System.out.println("No existe el producto con el id: " + id);
        }else{
            System.out.println(Controlador.getSingleton().buscarproducto(id));
        }
    }

}