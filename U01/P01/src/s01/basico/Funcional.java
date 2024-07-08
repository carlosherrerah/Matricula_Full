package s01.basico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Funcional {
  static List<Integer> transformar(Iterable<Integer> conjunto, Function<Integer, Integer> funcion) {
    List<Integer> lista = new ArrayList<>();
    for (Integer valor : conjunto) {
      lista.add(funcion.apply(valor));
    }
    return lista;
  }

  static Integer transformarYsumar(Iterable<Integer> conjunto, Function<Integer, Integer> funcion) {
    Integer acumulador = 0;
    for (Integer valor : conjunto) {
      acumulador += funcion.apply(valor);
    }
    return acumulador;
  }

  public static void main(String[] args) {
    List<Integer> CONJUNTO = Arrays.asList(1, 4, 6, 2, -5, 9);
    List<Integer> real1 = transformar(CONJUNTO, s -> -s);
    List<Integer> real11 = CONJUNTO.stream().map(i -> i > 0 ? -i : -i).collect(Collectors.toList());

    List<Integer> real2 = transformar(CONJUNTO, s -> s * s);
    List<Integer> real3 = CONJUNTO.parallelStream()      // parallelStream es mas rapido que Stream   M3.s4
        .map(x -> x + 1)
        .collect(Collectors.toList());
    Integer real4 = CONJUNTO.stream()
        .filter(num -> num % 2 == 0)
        .map(x -> x)
        .reduce(0, (a, b) -> a + b);
    Integer real5 = transformarYsumar(CONJUNTO, s ->s);


    System.out.println(real1);
    System.out.println(real11);
    System.out.println(real2);
    System.out.println(real3);
    System.out.println(real4);
    System.out.println(real5);



  }

}
