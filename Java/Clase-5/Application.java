import clases.Estudiante;

public class Application {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Juanita", "2003-10-09", "asd@asd.com", "FS Java", "Oct 2025");
        Estudiante est2 = new Estudiante("Ale", "2003-03-29", "asd1@asd.com", "FS Java", "Oct 2025");

        System.out.println(est1);
        System.out.println(est2);

    }
}
