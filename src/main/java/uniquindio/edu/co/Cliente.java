package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombreCompleto;
    private String documento;
    private String telefono;
    private String correo;
    private List<Compra> historialCompras;

    public Cliente(String nombreCompleto, String documento, String telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.historialCompras = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Compra> historialCompras) {
        this.historialCompras = historialCompras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", historialCompras=" + historialCompras +
                '}';
    }

    public void registrarCompra(Compra compra) {
        this.historialCompras.add(compra);
    }

    public double calcularTotalGastado() {
        double totalGastado = 0;
        for (Compra compra : this.historialCompras) {
            totalGastado += compra.getValorTotal();
        }
        return totalGastado;
    }
}

