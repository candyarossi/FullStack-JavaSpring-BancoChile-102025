import java.util.ArrayList;
import java.util.Arrays;

import clases.Estudiante;
import clases.Instructor;
import clases.Usuario;

public class Application {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Juanita", "2003-10-09", "asd@asd.com", "FS Java", "Oct 2025");
        Estudiante est2 = new Estudiante("Ale", "2003-03-29", "asd1@asd.com", "FS Java", "Oct 2025");

        ArrayList<Integer> calificaciones1 = new ArrayList<>(Arrays.asList(8, 10, 7));
        ArrayList<Integer> calificaciones2 = new ArrayList<>(Arrays.asList(8, 6, 9));

        est1.setCalificaciones(calificaciones1);
        est2.setCalificaciones(calificaciones2);

        // Usuario user = new Usuario();

        Instructor inst1 = new Instructor("Juan", "1990-01-23", "asd2@asd.com");

        inst1.agregarBootcamp("FS Java");

        inst1.agregarAlumno(est1);
        inst1.agregarAlumno(est2);

        System.out.println(inst1);
        System.out.println();
        System.out.println(inst1.verCalificaciones());

        System.out.println();
        System.out.println(est1.verCalificaciones() + " -> " + est1.calcularPromedio());
        System.out.println(est2.verCalificaciones() + " -> " + est2.calcularPromedio());

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(est2);
        usuarios.add(est1);
        usuarios.add(inst1);
    }
}
