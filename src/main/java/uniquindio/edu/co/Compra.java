package uniquindio.edu.co;

import uniquindio.edu.co.MetodoDePago;

import java.time.LocalDate;

public class Compra {
    private String codigoCompra;
    private LocalDate fecha;
    private MetodoDePago metodoPago;
    private double valorTotal;

    public Compra(String codigoCompra, LocalDate fecha, MetodoDePago metodoPago, double valorTotal) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
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
    public double getValorTotal() {
       return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra='" + codigoCompra + '\'' +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
