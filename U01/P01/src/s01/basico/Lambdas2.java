package s01.basico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import s01.Dog;

class EdadMayor {
    public boolean test(Dog d){
       return d.getEdad() >= 10;
    }
  }

public class Lambdas2 {

    private static void eliminarEdadMayor(List<Dog> lista, Predicate<Dog> predicate) {   // recomendado
        Iterator<Dog> iterator = lista.iterator();
        while (iterator.hasNext()) {
            //Dog d = iterator.next();
            if (predicate.test(iterator.next()))
                iterator.remove();
        }
    }

    private static void eliminarEdadMayor(List<Dog> lista, EdadMayor predicate) {   
        Iterator<Dog> iterator = lista.iterator();
        while (iterator.hasNext()) {
            //Dog d = iterator.next();
            if (predicate.test(iterator.next()))
                iterator.remove();
        }
    }


public static void main(String[] args) {
     List<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog("boi", 30, 6, LocalDate.of(2018,10,21)));
        dogs.add(new Dog("tyri", 40, 12, LocalDate.parse("2012-01-20")));
        dogs.add(new Dog("charis", 120, 7, LocalDate.of(2017,1,20)));
        dogs.add(new Dog("aiko", 50, 10, LocalDate.parse("2014-10-20")));
        dogs.add(new Dog("clover", 35, 12, LocalDate.parse("2012-05-25")));
        dogs.add(new Dog("mia", 15, 4, LocalDate.parse("2020-11-20")));
        dogs.add(new Dog("zooey", 45, 8, LocalDate.parse("2016-09-18")));

        System.out.println(dogs);
        dogs.forEach(d -> System.out.print(d.getNombre()+ "\t"));
        System.out.println("");

        Predicate<Dog> minPeso = dog -> dog.getPeso() >= 50;
        //List<Dog> pesoMinimoList = dogs.stream().filter(minPeso).collect(Collectors.toList());
        List<Dog> pesoMinimoList = dogs.stream().filter(x -> x.getPeso() >= 50).collect(Collectors.toList());
        System.out.println("Peso minimo: " + pesoMinimoList);

        Predicate<Dog> p = d -> d.getNombre().toUpperCase().substring(0, 1).equals("C");
        System.out.println("C:" + dogs.stream().filter(p).collect(Collectors.toList()));

        eliminarEdadMayor(dogs, d -> d.getEdad() >= 10);
        eliminarEdadMayor(dogs, (Dog d) -> { return d.getEdad() >= 10;});
        Lambdas2.eliminarEdadMayor(dogs, new EdadMayor());
        System.out.println("Jovenes: " + dogs);


}    
}
