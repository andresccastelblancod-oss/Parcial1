package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Cliente> listaSupermercadoClientes;
    private List<Producto> listaSupermercadoProductos;
    private List<Compra> listaSupermercadoCompras;

    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaSupermercadoClientes = new ArrayList<>();
        this.listaSupermercadoProductos = new ArrayList<>();
        this.listaSupermercadoCompras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getListaSupermercadoClientes() {
        return listaSupermercadoClientes;
    }

    public void setListaSupermercadoClientes(List<Cliente> listaSupermercadoClientes) {
        this.listaSupermercadoClientes = listaSupermercadoClientes;
    }

    public List<Producto> getListaSupermercadoProductos() {
        return listaSupermercadoProductos;
    }

    public void setListaSupermercadoProductos(List<Producto> listaSupermercadoProductos) {
        this.listaSupermercadoProductos = listaSupermercadoProductos;
    }

    public List<Compra> getListaSupermercadoCompras() {
        return listaSupermercadoCompras;
    }

    public void setListaSupermercadoCompras(List<Compra> listaSupermercadoCompras) {
        this.listaSupermercadoCompras = listaSupermercadoCompras;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaSupermercadoClientes=" + listaSupermercadoClientes +
                ", listaSupermercadoProductos=" + listaSupermercadoProductos +
                ", listaSupermercadoCompras=" + listaSupermercadoCompras +
                '}';
    }

    public void registrarCliente(Cliente cliente) {
        this.listaSupermercadoClientes.add(cliente);
    }

    public void agregarProducto(Producto producto) {
        this.listaSupermercadoProductos.add(producto);
    }

    public void registrarCompra(Compra compra) {
        this.listaSupermercadoCompras.add(compra);
    }

    public boolean verificarCliente(String documento) {
        for (Cliente cliente : this.listaSupermercadoClientes) {
            if (cliente.getDocumento().equals(documento)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarProducto(String codigo) {
        for (Producto producto : this.listaSupermercadoProductos) {
            if (producto.getCodigoProducto().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Cliente obtenerCliente(String documento) {
        for (Cliente cliente : this.listaSupermercadoClientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return new Cliente("", "", "", "");
    }

    public Producto obtenerProducto(String codigo) {
        for (Producto producto : this.listaSupermercadoProductos) {
            if (producto.getCodigoProducto().equals(codigo)) {
                return producto;
            }
        }
        return new Producto("", "", CategoriaProducto.ALIMENTOS, 0.0, 0);
    }

    public double obtenerVentasFechas(LocalDate fecha) {
        double totalVendido = 0;
        for (Compra compra : this.listaSupermercadoCompras) {
            if (compra.getFecha().equals(fecha)) {
                totalVendido += compra.getValorTotal();
            }
        }
        return totalVendido;
    }
}
