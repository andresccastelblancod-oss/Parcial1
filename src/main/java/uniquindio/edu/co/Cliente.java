package uniquindio.edu.co;

public class Cliente {
    private String nombreCompleto;
    private int documento;
    private int telefono;
    private String correo;

    public Cliente(String nombreCompleto, int documento, int telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.documento= documento;
        this.telefono=telefono;
        this.correo=correo;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + ''' +
                ", documento=" + documento +
                ", telefono=" + telefono +
                ", correo='" + correo + ''' +
                '}';
    }
}
