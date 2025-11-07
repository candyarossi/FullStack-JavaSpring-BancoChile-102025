import java.util.ArrayList;

import clases.Libro;
import clases.Prestamo;

public class Aplicacion {
    public static void main(String[] args) {

        Prestamo prestamo1 = new Prestamo();
        Prestamo prestamo2 = new Prestamo();

        Prestamo prestamo3 = new Prestamo("Fabiola", true);
        Prestamo prestamo4 = new Prestamo("Alondra", false);
        Prestamo prestamo5 = new Prestamo("Dominique", false);

        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", 56.9);
        Libro libro2 = new Libro("Pinocho", "Carlo Collodi", 48.2);
        Libro libro3 = new Libro("Peter Pan", "J. M. Barrie", 27.0);
        Libro libro4 = new Libro("Heidi", "Johanna Spyri", 65.2);
        Libro libro5 = new Libro("Alicia en el País de las Maravillas", "Lewis Carroll", 89.3);

        prestamo1.agregarLibro(libro1);
        prestamo1.agregarLibro(libro5);

        prestamo2.agregarLibro(libro2);
        prestamo2.agregarLibro(libro5);
        prestamo2.agregarLibro(libro3);

        prestamo3.agregarLibro(libro4);
        prestamo3.agregarLibro(libro1);

        prestamo4.agregarLibro(libro2);
        prestamo4.agregarLibro(libro5);
        prestamo4.agregarLibro(libro4);
        prestamo4.agregarLibro(libro3);

        prestamo5.agregarLibro(libro1);
        prestamo5.agregarLibro(libro3);

        ArrayList<Prestamo> prestamos = new ArrayList<>();

        prestamos.add(prestamo1);
        prestamos.add(prestamo2);
        prestamos.add(prestamo3);
        prestamos.add(prestamo4);
        prestamos.add(prestamo5);

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.mostrarDetallesDelPrestamo());
            System.out.println();
        }

        for (int i = 0; i < prestamos.size(); i++) {
            System.out.println("Estatus Prestamo " + (i + 1) + ": " + prestamos.get(i).mostrarEstatus());
            System.out.println();
        }

    }
}