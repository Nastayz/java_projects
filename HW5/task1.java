// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что один человек может иметь несколько телефонов.

package HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonebook = new HashMap<>();
        phonebook.put("Victor", List.of("8 917 886 11 11", "8 917 886 66 11"));
        phonebook.put("Alena", List.of("8 917 992 22 22", "8 917 992 33 22"));
        phonebook.put("Alexandr", List.of("8 917 312 33 33", "8 917 312 22 33"));
        phonebook.put("Peter", List.of("8 917 322 44 44", "8 917 322 11 44"));
        phonebook.put("Ivan", List.of("8 917 332 55 55", "8 917 332 33 55"));

        menu(phonebook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Если хотите выйте хотите перестать вводить номера, введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonebook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonebook);
                        break;
                    case "add":
                        add(phonebook);
                        break;
                    case "all":
                        allBook(phonebook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonebook;
    }
}