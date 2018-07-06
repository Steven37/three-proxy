package jdk.dynamicproxy;

/**
 * 2、实现业务逻辑接口 创建业务实现类
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class BookImpl implements  Book {
    @Override
    public void addBook() {
        System.out.println("增加图书————");
    }
}
