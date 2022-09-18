import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private static ArrayList<Clients> clients;
    private static ArrayList<Books> books;
    public Employee() {
        clients = new ArrayList<>();
        books = new ArrayList<>();
    }
    public ArrayList<Books> getBooks() {return books;}
    //Добавление Клиента
    public static void addClients(Clients client){ clients.add(client);}
    //Добавление Книги
    public static void addBooks(Books book){books.add(book);}
    //Чтение файла и внесение данных в массив, из массива перевод в аррейлист
    public static ArrayList readFileClients() throws IOException {
        ArrayList<Clients> clients = new ArrayList<>();
        String str;
        String[] arrStr;
        BufferedReader bR = new BufferedReader(new FileReader("clients.txt"));
        while ((str = bR.readLine()) != null){
            arrStr = str.split(" ");
            clients.add(new Clients(arrStr[1] ,arrStr[3], arrStr[5]));
        }
        return clients;
    }
    //Чтение книг из файла
    public static ArrayList readFileBooks() throws IOException{
        ArrayList<Books> books = new ArrayList<>();
        String str;
        String[] arrStr;
        BufferedReader bR = new BufferedReader(new FileReader("Books.txt"));
        while ((str = bR.readLine()) != null){
            arrStr = str.split(" ");
            books.add(new Books(arrStr[1], arrStr[3]));
        }
        return books;
    }
    //Удаление из файла "Читателей" клиентов и книг и возврат их в свои файлы
    public static void dellReaderList() throws IOException{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> readerList = new ArrayList<>();
        String str;
        String[] arrStr;
        BufferedReader bR = new BufferedReader(new FileReader("ReaderList.txt"));
        while ((str = bR.readLine()) != null) {readerList.add(str);}
        System.out.println("Кто возвращает книгу?");
        for(int i = 0; i < readerList.size(); i++) {
            System.out.println((i + 1) +") " + readerList.get(i));
        }
        System.out.println("0 - \"Выход\"");
        System.out.print("Введите номер: ");
        int choice = sc.nextInt();
        if (choice == 0 || choice > readerList.size()) {System.out.println("Выход");}
        else
            //выбранный вариант переписываем в исходные файлы
            str = readerList.get(choice - 1);
        arrStr = str.split(" ");
        Clients clients = new Clients(arrStr[1], arrStr[3], arrStr[5]);
        Writers.writeFiles(clients);
        Books books = new Books(arrStr[11], arrStr[13]);
        Writers.writeBFiles(books);
        //удаляем выбранный вариант
        readerList.remove(choice - 1);
        //Переписываем файл
        Writers.writeFilesReader(readerList);
        System.out.println("Книга возвращена");
    }
    public static ArrayList newFileReader(int clients, int books) throws IOException {
        ArrayList<String> arreysString = new ArrayList<>();
        System.out.println(readFileClients().get(clients) + " " + readFileBooks().get(books));
        arreysString.add(readFileClients().get(clients) + " | Read Book | " + readFileBooks().get(books));
        return arreysString;
    }
    //Удаление клиентов
    public static void dellClients() throws IOException {
        ArrayList<Clients> clients = Employee.readFileClients();
        Scanner sc = new Scanner(System.in);
        System.out.println("Кого из клиентов удаляем?");
        for(int i = 0; i < clients.size(); i++){
            System.out.println((i + 1) +")" + Employee.readFileClients().remove(i));
        }
        System.out.println("0 - \"Выход\"");
        System.out.print("Введите номер: ");
        int choice = sc.nextInt();
        if (choice == 0 || choice > clients.size()) {System.out.println("Выход");}
        else
            System.out.println("Удалён клиент " + clients.get(choice - 1).toString());
        clients.remove(choice - 1);
        Writers.writeFilesClients(clients);
    }
    //Удаление книги
    public static void dellBooks() throws IOException {
        ArrayList<Books> books = Employee.readFileBooks();
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую книгу удаляем?");
        for(int i = 0; i < books.size(); i++){
            System.out.println((i + 1) +")" + Employee.readFileBooks().remove(i));
        }
        System.out.println("0 - \"Выход\"");
        System.out.print("Введите номер: ");
        int choice = sc.nextInt();
        if (choice == 0 || choice > books.size()) {System.out.println("Выход");}
        else
            System.out.println("Удалена книга " + books.get(choice - 1).toString());
        books.remove(choice - 1);
        Writers.writeFilesBooks(books);
    }
    //Выбираем читателя, после книгу и выдаём её, книга и читатель удаляются из файла и записываются в новый
    public static void Reader() throws IOException{
        ArrayList<Clients> clients = Employee.readFileClients();
        ArrayList<Books> books = Employee.readFileBooks();
        Scanner sc = new Scanner(System.in);
        System.out.println("Для выдачи книги необходимо выбрать клиента и книгу из списка");
        System.out.println("0 - \"Выход из системы\"");
        System.out.println("Кому выдаём книгу?");
        for(int i = 0; i < clients.size(); i++){
            System.out.println((i + 1) +") " + Employee.readFileClients().remove(i));
        }
        System.out.print("Введите номер: ");
        int choiceClients = sc.nextInt();
        System.out.println();
        System.out.println("Какую книгу выдаём?");
        for(int i = 0; i < books.size(); i++){
            System.out.println((i + 1) + ") " + Employee.readFileBooks().remove(i));
        }
        System.out.print("Введите номер: ");
        int choiceBooks = sc.nextInt();
        if(choiceClients == 0 || choiceClients > clients.size() || choiceBooks == 0 || choiceBooks > clients.size()) {System.out.println("Выход из системы");}
        if(choiceClients != 0 && choiceBooks != 0) {
            //Запись в новый файл
            Writers.writeFilesReader(Employee.newFileReader((choiceClients - 1), (choiceBooks - 1)));
            //удаляет из общего файла клиента и книгу
            clients.remove((choiceClients - 1));
            books.remove((choiceBooks - 1));
            Writers.writeFilesClients(clients);
            Writers.writeFilesBooks(books);
        }
    }
}
