package uniquindio.edu.co;

public class DetalleDeCompra {
    private int cantidad;
    private double subTotal;

    public DetalleDeCompra(int cantidad, double subTotal) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    @Override
    public String toString() {
        return "DetalleDeCompra{" +
                "cantidad=" + cantidad +
                ", subTotal=" + subTotal +
                '}';
    }
}
