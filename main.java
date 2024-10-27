import java.util.Objects;

abstract class Animal implements Cloneable, Comparable<Animal> {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }

    public abstract Animal deepClone();

    @Override
    public String toString() {
        return name;
    }
}

interface Petable {
    void bePet();
}

// Feline class
abstract class Feline extends Animal {
    public Feline(String name) {
        super(name);
    }
}

// Canine class
abstract class Canine extends Animal {
    public Canine(String name) {
        super(name);
    }
}

// Specific Animals
class Lion extends Feline {
    public Lion() {
        super("Lion");
    }

    @Override
    public Animal deepClone() {
        return new Lion();
    }
}

class Tiger extends Feline {
    public Tiger() {
        super("Tiger");
    }

    @Override
    public Animal deepClone() {
        return new Tiger();
    }
}

class Cat extends Feline implements Petable {
    public Cat() {
        super("Cat");
    }

    @Override
    public void bePet() {
        System.out.println("Cat purrs when petted.");
    }

    @Override
    public Animal deepClone() {
        return new Cat();
    }
}

class Wolf extends Canine {
    public Wolf() {
        super("Wolf");
    }

    @Override
    public Animal deepClone() {
        return new Wolf();
    }
}

class Dog extends Canine implements Petable {
    public Dog() {
        super("Dog");
    }

    @Override
    public void bePet() {
        System.out.println("Dog wags its tail when petted.");
    }

    @Override
    public Animal deepClone() {
        return new Dog();
    }
}

class Giraffe extends Animal {
    public Giraffe() {
        super("Giraffe");
    }

    @Override
    public Animal deepClone() {
        return new Giraffe();
    }
}

// Test class
public class Main {
    public static void main(String[] args) {
        try {
            // Original objects
            Animal cat = new Cat();
            Animal dog = new Dog();
            
            System.out.println("Original Cat: " + cat);
            System.out.println("Original Dog: " + dog);

            // Shallow copy
            Animal shallowCatCopy = (Animal) cat.clone();
            System.out.println("Shallow Cat Copy: " + shallowCatCopy);

            // Deep copy
            Animal deepDogCopy = dog.deepClone();
            System.out.println("Deep Dog Copy: " + deepDogCopy);

            // Demonstrate Petable
            if (cat instanceof Petable) {
                ((Petable) cat).bePet();
            }
            if (dog instanceof Petable) {
                ((Petable) dog).bePet();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
