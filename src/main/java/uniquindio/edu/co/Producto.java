package uniquindio.edu.co;

public class Producto {

    private String codigoProducto;
    private String nombre;
    private CategoriaProducto categoria;
    private double precioProducto;
    private int cantidadDisponible;

    public Producto(String codigoProducto, String nombre, CategoriaProducto categoria, double precioUnitario, int cantidadDisponible) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioProducto = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", precioProducto=" + precioProducto +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }

    public boolean validarDisponibilidad(int cantidad) {
        return cantidadDisponible >= cantidad && cantidad > 0;
    }

    public void actualizarInventario(int cantidad) {
        this.cantidadDisponible = this.cantidadDisponible - cantidad;
    }
}