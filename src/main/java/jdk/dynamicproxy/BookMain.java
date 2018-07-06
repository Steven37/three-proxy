package jdk.dynamicproxy;

/**
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class BookMain {
    public  static  void main(String [] args){
        BookImpl bookImpl = new BookImpl();
        BookProxy bookProxy = new BookProxy();
        Book book = (Book)bookProxy.bind(bookImpl);
        book.addBook();
    }
}
