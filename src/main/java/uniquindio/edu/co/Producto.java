public class Producto {

    private String codigoProdcuto;
    private String nombre;
    private categoria categoria;
    private double precioUnitario;
    private int cantidadDisponible;

    public Producto(String codigoProdcuto, String nombre, categoria categoria, double precioUnitario, int cantidadDisponible) {
        this.codigoProdcuto = codigoProdcuto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigoProdcuto() {
        return codigoProdcuto;
    }

    public void setCodigoProdcuto(String codigoProdcuto) {
        this.codigoProdcuto = codigoProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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
                "codigoProdcuto='" + codigoProdcuto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", precioUnitario=" + precioUnitario +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
