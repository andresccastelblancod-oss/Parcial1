package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String codigoCompra;
    private LocalDate fecha;
    private MetodoDePago metodoPago;
    private Cliente cliente;
    private double valorTotal;
    private List<DetalleDeCompra> listaDetalleDeCompra;

    public Compra(String codCompra, LocalDate fecha, MetodoDePago nuevoMetodoDePago, Cliente cliente, double valorTotal) {
        this.codigoCompra = codCompra;
        this.fecha = fecha;
        this.metodoPago = nuevoMetodoDePago;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
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
                ", cliente=" + cliente.getNombreCompleto() +
                ", metodoPago=" + metodoPago +
                ", valorTotal=" + valorTotal +
                ", listaDetalleDeCompra=" + listaDetalleDeCompra +
                '}';
    }

    public void agregarDetalle(int cantidad, Producto producto) {
        DetalleDeCompra detalle = new DetalleDeCompra(cantidad, producto);
        this.listaDetalleDeCompra.add(detalle);
    }

    public double calcularValorTotal() {
        double acumulado = 0.0;
        for (DetalleDeCompra detalle : listaDetalleDeCompra) {
            acumulado += detalle.getCantidad() * detalle.getProducto().getPrecioProducto();
        }
        this.valorTotal = acumulado;
        return this.valorTotal;
    }

    public void confirmarCompra() {
        calcularValorTotal();

        for (DetalleDeCompra detalle : listaDetalleDeCompra) {
            detalle.getProducto().actualizarInventario(detalle.getCantidad());
        }
    }
}