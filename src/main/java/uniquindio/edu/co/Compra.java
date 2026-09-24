package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String codigoCompra;
    private LocalDate fecha;
    private Cliente cliente;
    private MetodoDePago metodoPago;
    private double valorTotal;


    private List<DetalleDeCompra> listaDetalleDeCompra;


    public Compra(String codCompra, LocalDate now, MetodoDePago nuevoMetodoDePago, Cliente cliente) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.valorTotal = 0.0;


        this.listaDetalleDeCompra = new ArrayList<>();
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }
    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoDePago getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(MetodoDePago metodoPago) {
        this.metodoPago = metodoPago;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public List<DetalleDeCompra> getListaDetalleDeCompra() {
        return listaDetalleDeCompra;
    }
    public void setListaDetalleDeCompra(List<DetalleDeCompra> listaDetalleDeCompra) {
        this.listaDetalleDeCompra = listaDetalleDeCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra='" + codigoCompra + '\'' +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", metodoPago=" + metodoPago +
                ", valorTotal=" + valorTotal +
                ", listaDetalleDeCompra=" + listaDetalleDeCompra +
                '}';
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        if (producto.validarDisponibilidad(cantidad)) {
            DetalleDeCompra nuevoDetalle= new DetalleDeCompra(cantidad, producto);
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