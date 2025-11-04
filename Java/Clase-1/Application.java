public class Application {
    public static void main(String[] args) {
        System.out.println("¡Hola Mundo!");

        // TIPOS DE DATOS
        int num1 = 1;
        Integer num2 = 7;

        double dec1 = 1.9;
        Double dec2 = 3.89;

        boolean esTrue = true;
        Boolean esFalse = false;

        char letra1 = 'C';
        Character letra2 = 'R';

        String str = "Hola, ";
        String str2 = new String("Gabriela!");
        String str3 = new String("gabriela!");

        // STRING METHODS
        // Imprimir una String
        System.out.println(str);

        // Método .concat()
        System.out.println(str.concat(str2));

        // Método .length()
        System.out.println(str.length());

        // Método .toUpperCase() y .toLowerCase()
        System.out.println(str2.toLowerCase());
        System.out.println(str2.toUpperCase());

        // Método .trim()
        System.out.println(str.trim().concat(str3));

        // Método .indexOf()
        System.out.println(str2.indexOf("a"));

        // Método .equals() o .equalsIgnoreCase()
        System.out.println(str2.equals(str3));
        System.out.println(str2.equalsIgnoreCase(str3));

        // CASTING
        // Explícito
        double miDouble = 10.5;
        int miEntero = (int) miDouble;
        String miString = String.valueOf(miEntero);

        // Implícito
        int miEntero2 = 60;
        double miDouble2 = miEntero2;

        // CONDICIONALES
        System.out.println(miDouble2);

        if (miDouble2 > 60.1) {
            System.out.println("Es mayor.");
        } else {
            System.out.println("Es menor.");
        }

        // Operador/Condicional Ternario
        String resultadoTernario = (miDouble2 > 60.1) ? "Es mayor." : "Es menor.";

        System.out.println(resultadoTernario);
    }
}