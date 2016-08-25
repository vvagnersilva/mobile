package Questao27;

import RetornoCovariante.Animals;

public class Test {
    public static void main(String[] args) {
        Animals animal = new Dog();
        Cat cat = (Cat) animal; //java.lang.ClassCastException:

        System.out.println(cat.noise());
    }
}
