package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String codigoCompra;
    private String fecha;
    private Cliente cliente;
    private MetodoDePago metodoPago;
    private double valorTotal;


    private List<DetalleDeCompra> listaDetalleDeCompra;


    public Compra(String codigoCompra, String fecha, Cliente cliente, MetodoDePago metodoPago) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.valorTotal = 0.0;


        this.listaDetalleDeCompra = new ArrayList<>();
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        if (producto.validarDisponibilidad(cantidad)) {
            DetalleDeCompra nuevoDetalle = new DetalleDeCompra(cantidad, producto);
            this.listaDetalleDeCompra.add(nuevoDetalle);
        } else {
            System.out.println("No hay suficiente cantidad disponible del producto.");
        }
    }

    public double calcularValorTotal() {
        double precioTotal = 0;
        for (DetalleDeCompra detalle : this.listaDetalleDeCompra) {
            precioTotal += detalle.calcularSubTotal();
        }
        return precioTotal;
    }
    public void confirmarCompra(){
        for(DetalleDeCompra detalle: this.listaDetalleDeCompra){
            Producto producto=detalle.getProducto();
            int cantidad=detalle.getCantidad();
            producto.actualizarInventario(cantidad);
        }
    }
}