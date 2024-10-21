package Modelo;

public class Moneda {

    private String codigo;
    private double cantidad;

    public Moneda(String codigo, double cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "La cantidad es: "+cantidad+" el codigo es: "+codigo;
    }
}
