package clases;

public class Libro {
    private String titulo;
    private String autor;
    private Double precioDeReemplazo;

    public Libro(String titulo, String autor, Double precioDeReemplazo) {
        this.titulo = titulo;
        this.autor = autor;
        this.precioDeReemplazo = precioDeReemplazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPrecioDeReemplazo() {
        return precioDeReemplazo;
    }

    public void setPrecioDeReemplazo(Double precioDeReemplazo) {
        this.precioDeReemplazo = precioDeReemplazo;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", precioDeReemplazo=" + precioDeReemplazo + "]";
    }
}
