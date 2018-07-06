package jdk.staticproxy;

/**
 * 1、定义一个接口类，说明业务逻辑
 * @Author tannanlin
 * @Date 2018/7/5
 */
public interface Count {
    /**
     * 查询账户
     */
    public void queryCount();

    /**
     * 修改账户
     */
    public void updateCount();
}
