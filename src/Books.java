import java.io.Serializable;

public class Books implements Serializable {
    private String nameBooks;
    private String nameAuthor;
    public Books(String nameBooks, String nameAuthor) {
        this.nameBooks = nameBooks;
        this.nameAuthor = nameAuthor;
    }
    public String toString(){
        return new StringBuffer("Название_книги: ")
                .append(this.nameBooks).append(" ")
                .append("Автор: ")
                .append(this.nameAuthor).toString();
    }
}
