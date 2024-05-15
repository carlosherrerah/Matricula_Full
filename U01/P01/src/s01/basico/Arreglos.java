package s01.basico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Arreglos {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 8, 2, 4 };
        Integer[] b = new Integer[] {10,8,4,6};

        List datos = new ArrayList<>();
        datos.add("ISC");
        datos.add(100);

        // Flexible y buenas practicas, generico, programacion por interfaz
        List<String> names = new ArrayList<>();
        List<Integer> list = Arrays.asList(7, 3, 9, 10, 5);
        List<Integer> lista = Arrays.asList(b);  // array to List

        lista.forEach(x -> System.out.print(x+ "\t")); 
        System.out.println();

        // No sincronizado, mas rapido, (un solo hilo)
        ArrayList<String> cars = new ArrayList<>();

        // Declaración de un vector (sincronizado y concurrente, multihilos)
        Vector<String> vector = new Vector<>();

        // ----------------------------------------------------------
        // Convert an array to an ArrayList.
        List<Integer> bList = Arrays.asList(b);

         // Convert ArrayList to an array.
         Integer[] c = bList.toArray(new Integer[0]);

         for (Integer element : c) {
            System.out.println(element);
         }

         // Colecciones ----------------------------------------------
         Collections.sort(lista);
         Collections.reverse(lista);
         System.out.println("Descendente: " +  lista);
         System.out.println("Max: " + Collections.max(lista));
         int posicion = Collections.binarySearch(lista, 3);
         System.out.println("busqueda: " + posicion);

         Collections.sort(lista, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        System.out.println(lista);

        System.out.println(". . .Hecho");
  

    }
    
}
