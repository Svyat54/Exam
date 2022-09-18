import java.io.*;
import java.util.Scanner;

public class Library {
    public static void Library() throws IOException {
        System.out.println("""
                Главное меню
                1 - Создать клиента\s
                2 - Удалить клиента\s
                3 - Просмотр клиента
                4 - Просмотр доступных книг
                5 - Выдать книгу клиенту
                6 - Вернуть книгу в библиотеку
                7 - Добавить новую книгу
                8 - Удалить книгу
                0 - Завершить работу""");
        Scanner sc = new Scanner(System.in);
        int choiseGM;
        System.out.print("Выберите действие: ");
        choiseGM = sc.nextInt();
        switch (choiseGM) {
            case (1):
                System.out.print("Введите Имя: ");
                String name = sc.next();
                System.out.print("Введите Фамилию: ");
                String surName = sc.next();
                Clients clients = new Clients(name, surName);
                Writers.writeFiles(clients);
                System.out.println("Добавлен новый клиент - " + clients);
                break;
            case (2):
                Employee.dellClients();
                break;
            case (3):
                for (int i = 0; i < Employee.readFileClients().size(); i++) {
                    System.out.println(Employee.readFileClients().remove(i));
                }
                break;
            case (4):
                for (int i = 0; i < Employee.readFileBooks().size(); i++) {
                    System.out.println((i + 1) + ") " + Employee.readFileBooks().remove(i));
                }
                break;
            case (5):
                Employee.Reader();
            case (6):
                Employee.dellReaderList();
            case (7):
                System.out.print("Введите название книги вместо пробела используйте _: ");
                String nameBooks = sc.next();
                System.out.print("Введите автора книги, вместо пробела используйте _: ");
                String nameAuthor = sc.next();
                Books books = new Books(nameBooks, nameAuthor);
                Writers.writeBFiles(books);
                System.out.println("Добавлена новая книга - " + books);
            case (8):
                Employee.dellBooks();
            case (0):
                System.out.println("Вы вышли из системы!");
                break;
            default:
                System.out.println("До скорой встречи!");
                break;
        }
    }
}
