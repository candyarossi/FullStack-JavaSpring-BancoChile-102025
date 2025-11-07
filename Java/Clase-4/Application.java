import java.util.ArrayList;

import clases.Persona;

public class Application {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Candela", "1996-10-08");

        System.out.println(persona1.getNombre());
        System.out.println(persona2.getNombre());

        persona1.setNombre("Alexandra");
        System.out.println(persona1.getNombre());

        // persona1.setEdad(19);
        System.out.println(persona1.getEdad());

        System.out.println(persona1);
        System.out.println(persona2);

        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(persona1);
        personas.add(persona2);

        System.out.println(personas);

        // persona1.calcularEdad();

        Persona persona3 = new Persona("Juanita", "1997-02-27", "asd@asd.com");

        System.out.println(persona3.toString());
        System.out.println("incrementId: " + Persona.getIncrementId());
    }
}
