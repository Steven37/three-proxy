package cglib;

/**
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class BookMain {
    public static  void main(String [] args){
        Book book = new Book();
        BookCglib bookCglib = new BookCglib();
        Book bookProxy = (Book)bookCglib.getInstance(book);
        bookProxy.addBook();
    }
}