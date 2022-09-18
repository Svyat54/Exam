import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Writers {
    //Запись в файл без перезаписи подходит при новом клиенте или при удалении из "Читающих"
    public static void writeFiles(Clients client) throws IOException {
        Path paths = Paths.get("clients.txt");
        Files.writeString(paths,
                client.toString().concat("\n"),
                StandardOpenOption.APPEND);
    }
    public static void writeBFiles(Books books) throws IOException{
        Path paths = Paths.get("Books.txt");
        Files.writeString(paths,
                books.toString().concat("\n"),
                StandardOpenOption.APPEND);
    }
    //Перезаписывает файл клиентов
    public static void writeFilesClients(ArrayList<Clients> client) throws IOException {
        Path paths = Paths.get("clients.txt");
        FileWriter fw = new FileWriter(String.valueOf(paths), false);
        for (int i = 0; i < client.size(); i++) {
            fw.write(client.get(i) + "\n");
        }
        fw.close();
    }
    //Перезаписывает файл книг
    public static void writeFilesBooks(ArrayList<Books> books) throws IOException{
        Path paths = Paths.get("Books.txt");
        FileWriter fW = new FileWriter(String.valueOf(paths), false);
        for(int i = 0; i < books.size(); i++){
            fW.write(books.get(i) + "\n");
        }
        fW.close();
    }
    //Перезаписывает файл Читателей
    public static void writeFilesReader(ArrayList<String> readersList) throws IOException{
        Path paths = Paths.get("ReaderList.txt");
        FileWriter fW = new FileWriter(String.valueOf(paths), false);
        for(int i = 0; i < readersList.size(); i++){
            fW.write(readersList.get(i) + "\n");
        }
        fW.close();
    }
}
