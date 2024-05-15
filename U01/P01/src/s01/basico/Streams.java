package s01.basico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(7, 4, 9, 10, 5);

        // -------------------------Programacion Funcional
        // ---------------------------------
        lista = lista.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());
        System.out.println(lista);

        List<Integer> binarios = lista.stream()
                .map(x -> x % 2 == 0 ? 0 : 1)
                .collect(Collectors.toList());
        System.out.println("binarios: " + binarios);

        binarios = lista.stream()
                .map(x -> {
                    if (x % 2 == 0) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .collect(Collectors.toList());

        binarios = lista.stream()
                .map(x -> {
                    int r;
                    if (x % 2 == 0) {
                        r = 0;
                    } else {
                        r = 1;
                    }
                    return r;
                })
                .collect(Collectors.toList());

        int suma = lista.stream().reduce(0, Integer::sum);
        suma = lista.stream().reduce(0, (a, b) -> a + b);
        System.out.println("La suma: " + suma);

        List<Integer> pares = lista.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        int sumarPares = lista.stream()
                .filter(num -> num % 2 == 0) // Filtrar solo los números pares
                // .reduce(0, Integer::sum); // Sumar los números pares
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sumar Pares: " + sumarPares);

        int sumaPares = lista.stream()
                .filter(num -> num % 2 == 0) // Filtrar solo los números pares
                .mapToInt(Integer::intValue) // Convertir a un IntStream
                .sum(); // Sumar los números
        System.out.println("Suma  Pares: " + sumaPares);

    }

}
