package jdk.staticproxy;

/**
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class CountMain {

    public  static  void main(String [] args){
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}
