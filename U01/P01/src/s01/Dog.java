package s01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Dog {
    String nombre;
    Integer peso;
    public Integer edad;
    LocalDate nacimiento;

    public Dog(String nombre, Integer peso, Integer edad, LocalDate nacimiento) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String toString() {
        return "Dog{nombre=" + nombre + ", peso=" + peso + ", edad=" + edad + ", nacimiento="+ nacimiento + "}";
    }

    static List<Dog> edadMinima(List<Dog> dogList, Integer edadTest) {
        List<Dog> result = new ArrayList<>();

        for (Dog dog : dogList) {
            if (dog.edad >= edadTest) {
                result.add(dog);
            }
        }
        return result;
    }

    // declare a new lambda powered, generic, multi-purpose query method
    static List<Dog> dogQuery(List<Dog> dogList, Predicate<Dog> expr) {
        // do an "on the fly" query
        List<Dog> result = new ArrayList<>();
        for (Dog d : dogList)
            if (expr.test(d)) // the key moment, lambda powered!
                result.add(d);
        return result;
    }

}
