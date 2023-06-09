package ua.lviv.lgs;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println();
        System.out.println("Введіть 1, щоб додати учасника клубу");
        System.out.println("Введіть 2, щоб додати тваринку до учасника клубу");
        System.out.println("Введіть 3, щоб видалити тваринку з учасника клубу");
        System.out.println("Введіть 4, щоб видалити учасника з клубу");
        System.out.println("Введіть 5, щоб видалити конкретну тваринку зі всіх власників");
        System.out.println("Введіть 6, щоб вивести на екран зооклуб");
        System.out.println("Введіть 7, щоб вийти з програми");
    }

    public static void main(String[] args) {
        ZooClub zooClub = new ZooClub();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();

            switch (scanner.nextInt()) {

                case 1: {
                    zooClub.addZooClubMember();
                    break;
                }

                case 2: {
                    zooClub.addAnimal();
                    break;
                }

                case 3: {
                    zooClub.removeAnimal();
                    break;
                }

                case 4: {
                    zooClub.removeZooClubMember();
                    break;
                }

                case 5: {
                    zooClub.removeAnimalFromAllMembers();
                    break;
                }

                case 6: {
                    zooClub.viewZooClub();
                    break;
                }

                case 7: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Введіть число від 1 до 7");
                    break;
                }
            }
        }

    }
}
