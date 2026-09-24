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

    public void setCodigoProdcuto(String codigoProdcuto) {
        this.codigoProducto = codigoProdcuto;
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

    public double getPrecioUnitario() {
        return precioProducto;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioProducto = precioUnitario;
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
                "codigoProdcuto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", precioUnitario=" + precioProducto+
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }

    public boolean validarDisponibilidad(int cantidad){
        boolean estaDisponible=true;
        if(cantidadDisponible>=cantidad && cantidad!=0){
            estaDisponible=true;
        }
        else{
            estaDisponible=false;
        }
        return estaDisponible;
    }
    public void actualizarInventario(int cantidad){
        this.cantidadDisponible=this.cantidadDisponible-cantidad;
    }




}
