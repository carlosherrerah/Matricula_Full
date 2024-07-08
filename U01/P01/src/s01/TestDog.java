package s01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class TestDog {

  public static void main(String[] args) {
    List<Dog> dogs = new ArrayList<>();

    dogs.add(new Dog("boi", 30, 6, LocalDate.of(2018, 10, 21)));
    dogs.add(new Dog("tyri", 40, 12, LocalDate.parse("2012-01-20")));
    dogs.add(new Dog("charis", 120, 7, LocalDate.of(2017, 1, 20)));
    dogs.add(new Dog("aiko", 50, 10, LocalDate.parse("2014-10-20")));
    dogs.add(new Dog("clover", 35, 12, LocalDate.parse("2012-05-25")));
    dogs.add(new Dog("mia", 15, 4, LocalDate.parse("2020-11-20")));
    dogs.add(new Dog("zooey", 45, 8, LocalDate.parse("2016-09-18")));

    System.out.println(dogs);

    dogs.forEach(System.out::println);
    for (Dog dog : dogs) {
      System.out.println(dog);
    }

    List<Dog> edadMinimaList = Dog.edadMinima(dogs, 10);
    System.out.println("Edad Minima: " + edadMinimaList);

    List<Dog> dogViejos = new ArrayList<>();
    dogs.forEach(dog -> {
      if (dog.edad >= 10) {
        dogViejos.add(dog);
      }
    });
    System.out.println("viejos:      " + dogViejos);

    // Ordenados por :
    Collections.sort(edadMinimaList, Comparator.comparing(Dog::getEdad));
    // Collections.sort(edadMinimaList, (p1, p2) -> p1.nombre.compareTo(p2.nombre));
    // Collections.sort(edadMinimaList, (p1, p2) -> p1.getEdad().compareTo(p2.getEdad()));
    // edadMinimaList.sort((p1, p2) -> p1.edad.compareTo(p2.edad));
    // System.out.println("Edad Minima: " + edadMinimaList);

    List<Dog> pesoMinimoList = Dog.dogQuery(dogs, d -> d.getPeso() >= 50);
    System.out.println("Peso Minimo: " + pesoMinimoList);

    List<Dog> eneroList = dogs.stream().filter(x -> x.nacimiento.getMonthValue() == 1).collect(Collectors.toList());
    System.out.println(eneroList);

    System.out.println(dogs.stream()
        .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
        .map(dog -> dog.nombre.toUpperCase())
        .collect(Collectors.toList()));
  }
}
