package demo;

/**
 * @Author: fujing
 * @Date: 2021/10/17
 * @Description:
 * @Version: 1.0
 */
public class EnumTest {
    public static void main(String[] args) {
        EventEnum keyleft = EventEnum.KEYPRESS;
        System.out.println("其中一个枚举对象的name:" + keyleft.name());

        keyleft.excute();
    }
}
