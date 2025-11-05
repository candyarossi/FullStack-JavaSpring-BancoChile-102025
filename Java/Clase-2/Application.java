import clases.Calculadora;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        // METODOS ESTATICOS
        int resultado = Calculadora.sumarEnteros(5, 8);
        int resultado2 = Calculadora.sumarEnteros(7, 9, 3);
        int resultado3 = Calculadora.sumarEnteros(4, 6.2);

        System.out.println("Resultado: " + resultado);
        System.out.println("Resultado 2: " + resultado2);
        System.out.println("Resultado 3: " + resultado3);

        Date fecha = new Date();
        System.out.println("La fecha de hoy es: " + fecha);

        // ARREGLOS ESTATICOS
        int[] numeros = new int[5];

        numeros[0] = 10;
        numeros[1] = 20;
        // numeros[8] = 30;

        System.out.println(numeros[0]);
        System.out.println(numeros[1]);
        System.out.println(numeros[2]);
        System.out.println(numeros[3]);
        System.out.println(numeros[4]);
        // System.out.println(numeros[8]);

        int[] numeros2 = { 1, 2, 3, 4, 5 };

        System.out.println(numeros2[2]);
        // System.out.println(numeros2[6]);
        System.out.println(numeros2);

        // ARREGLOS DINAMICOS
        ArrayList<String> colores = new ArrayList<>();

        // Añadir items
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Verde");
        colores.add("Azul");
        System.out.println("Lista de colores: " + colores);

        // Quitar items
        colores.remove("Verde");
        System.out.println("Lista de colores: " + colores);

        // Obtener item con index
        String primerColor = colores.get(0);
        System.out.println("Primer color: " + primerColor);

        // Verificar existencia de item
        boolean contieneAzul = colores.contains("Azul");
        System.out.println("Contiene 'Azul': " + contieneAzul);

        // Tamaño o cantidad de items
        int cantidad = colores.size();
        System.out.println("Tamaño: " + cantidad);

        // CICLOS
        // For -> Recorrer ArrayList
        for (int i = 0; i < colores.size(); i++) {
            System.out.println("For 1: " + colores.get(i));
        }

        // For -> Recorrer Array Estático
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("For 2: " + numeros[i]);
        }

        // While -> Recorrer ArrayList
        int i = 0;

        while (i < colores.size()) {
            System.out.println("While 1: " + colores.get(i));
            i++;
        }

        // While -> Recorrer Array Estático
        int j = 0;

        while (j < numeros.length) {
            System.out.println("While 2: " + numeros[j]);
            j++;
        }

        // For .. of
        for (String color : colores) {
            System.out.println("For (:) -> " + color);
        }

        // HASHMAP -> Mapa de Hash
        HashMap<String, Integer> personas = new HashMap<>();

        // Añadir elementos (clave - valor)
        personas.put("Maria", 26384024);
        personas.put("Claudia", 94829382);
        personas.put("Susana", 72772819);
        System.out.println("HASHMAP: " + personas);

        // Borrar elemento
        personas.remove("Maria");
        System.out.println("HASHMAP: " + personas);

        // Obtener elemento -> por KEY
        System.out.println("Elemento HM: " + personas.get("Claudia"));

        Set<String> claves = personas.keySet();
        System.out.println("SET de KEYS: " + claves);

        for (String clave : claves) {
            System.out.println("Clave: " + clave + ", Valor: " + personas.get(clave));
        }
    }
}