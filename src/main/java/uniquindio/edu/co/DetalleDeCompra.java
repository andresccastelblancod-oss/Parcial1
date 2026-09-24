package uniquindio.edu.co;

public class DetalleDeCompra {
    private int cantidad;
    private Producto producto;
    ;

    public DetalleDeCompra(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleDeCompra{" +
                "cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
    public double calcularSubTotal() {
        double precio = producto.getPrecioUnitario();
        double subtotal=precio*cantidad;
        return subtotal;
    }
}

