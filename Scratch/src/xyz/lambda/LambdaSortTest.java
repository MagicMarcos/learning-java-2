package xyz.lambda;

import java.util.ArrayList;
import java.util.List;

class LambdaSortTest {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("tiger");
        animals.add("elephant");
        animals.add("orca");
        animals.add("panda");
        animals.add("dog");
        animals.add("shark");
        animals.add("cow");
        animals.add("zebra");
        animals.add("seal");
        animals.add("monkey");

        animals.sort((animal1, animal2) -> Integer.compare(animal1.length(), animal2.length()));

        animals.forEach(System.out::println); // forEach takes consumer
        System.out.println();

        animals.removeIf(animal -> animal.contains("r")); // removeIf takes a predicate (take something return bool)

        animals.forEach(System.out::println); //animal -> System.out.println(animal)
    }
}