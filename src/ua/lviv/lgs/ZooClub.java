package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class ZooClub {
    Map<Person, ArrayList<Animal>> zooClub = new HashMap<Person, ArrayList<Animal>>();

    public void addZooClubMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я учасника зооклубу:");
        String name = scanner.next();
        System.out.println("Введіть вік учасника зооклубу:");
        int age = scanner.nextInt();

        Person zooClubMember = new Person(name, age);

        zooClub.put(zooClubMember, new ArrayList<Animal>());
        System.out.println(zooClubMember.toString() + " успішно зареєстрований в зооклубі!");
    }

    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я учасника зооклубу:");
        String name = scanner.next();
        System.out.println("Введіть вік учасника зооклубу:");
        int age = scanner.nextInt();

        boolean typeCorrect = isZooClubMemberExists(zooClub, name, age);

        if (typeCorrect) {
            System.out.println("Введіть тварину:");
            String species = scanner.next();
            System.out.println("Введіть кличку тварини:");
            String animalName = scanner.next();

            Animal newAnimal = new Animal(species, animalName);

            Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

            while (iterator.hasNext()) {
                Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

                if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
                    ArrayList<Animal> animalList = nextMember.getValue();

                    animalList.add(newAnimal);
                    System.out.println("Тварину " + newAnimal.toString() + " успішно додано учаснику "
                            + nextMember.getKey() + "!");
                }
            }

        } else {
            System.out.println("Введений учасник в зооклубі не зареєстрований!");
        }
    }

    public void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я учасника зооклубу:");
        String name = scanner.next();
        System.out.println("Введіть вік учасника зооклубу:");
        int age = scanner.nextInt();

        boolean typeCorrect = isZooClubMemberExists(zooClub, name, age);

        if (typeCorrect) {
            System.out.println("Введіть тварину:");
            String species = scanner.next();
            System.out.println("Введіть кличку тварини:");
            String animalName = scanner.next();

            boolean typeAnimalCorrect = isZooClubMemberAnimalExists(zooClub, name, age, species, animalName);

            if (typeAnimalCorrect) {
                Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

                while (iterator.hasNext()) {
                    Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

                    if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
                        ArrayList<Animal> animalList = nextMember.getValue();

                        Iterator<Animal> iterator2 = animalList.iterator();

                        while (iterator2.hasNext()) {
                            Animal next2 = iterator2.next();

                            if (next2.getSpecies().equalsIgnoreCase(species)
                                    && next2.getName().equalsIgnoreCase(animalName)) {
                                iterator2.remove();
                                System.out.println("Тварину " + next2.toString() + " успішно видалено у учасника "
                                        + nextMember.getKey() + "!");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Введеної тварини немає у даного учасника зооклубу!");
            }
        } else {
            System.out.println("Введений учасник в зооклубі не зареєстрований!");
        }
    }

    public void removeZooClubMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я учасника зооклубу:");
        String name = scanner.next();
        System.out.println("Введіть вік учасника зооклубу:");
        int age = scanner.nextInt();

        boolean typeCorrect = isZooClubMemberExists(zooClub, name, age);

        if (typeCorrect) {
            Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

            while (iterator.hasNext()) {
                Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

                if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
                    iterator.remove();
                    System.out.println(nextMember.getKey().toString() + " успішно видалений з зооклубу!");
                }
            }
        } else {
            System.out.println("Введений учасник в зооклубі не зареєстрований!");
        }
    }

    public void removeAnimalFromAllMembers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть тварину:");
        String species = scanner.next();

        Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

            ArrayList<Animal> animalList = nextMember.getValue();

            Iterator<Animal> iterator2 = animalList.iterator();

            while (iterator2.hasNext()) {
                Animal next2 = iterator2.next();

                if (next2.getSpecies().equalsIgnoreCase(species)) {
                    iterator2.remove();
                    System.out.println("Тварину " + next2.toString() + " успішно видалено у учасника "
                            + nextMember.getKey() + "!");
                }
            }
        }
    }

    public void viewZooClub() {
        Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();

        System.out.println("У зооклубі є:");
        for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
            System.out.println("У учасника " + entry.getKey() + " є " + entry.getValue());
        }
    }

    static boolean isZooClubMemberExists(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
        boolean flag = false;

        Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();

        for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
            if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
                flag = true;
            }
        }

        return flag;
    }

    static boolean isZooClubMemberAnimalExists(Map<Person, ArrayList<Animal>> zooClub, String name, int age,
                                               String species, String animalName) {
        boolean flag = false;

        Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

            if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
                ArrayList<Animal> animalList = nextMember.getValue();

                Iterator<Animal> iterator2 = animalList.iterator();

                while (iterator2.hasNext()) {
                    Animal next2 = iterator2.next();

                    if (next2.getSpecies().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }
}
