import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Clients implements Serializable {
    private int id;
    private String name;
    private String surname;
    public Clients(String name, String surname){
        this.id = (int)(Math.random() * 100000);
        this.name = name;
        this.surname = surname;
    }
    public Clients(String id, String name, String surname){
        this.id = Integer.parseInt(id);
        this.name = name;
        this.surname = surname;
    }
    @Override
    public String toString() {
        return new StringBuffer("ID: ")
                .append(this.id).append(" Имя: ")
                .append(this.name).append(" Фамилия: ")
                .append(this.surname).toString();
    }
}
