package demo;

/**
 * @Author: fujing
 * @Date: 2021/10/17
 * @Description: 1、枚举类也是类，一样有属性、方法和构造方法。
 *               2、每个被枚举的成员，默认是public static finnal 的，可以通过枚举类名直接使用它们。
 *               3、当你需要使用一组常量时，建议使用枚举类
 * @Version: 1.0
 */
public enum EventEnum {
    //枚举类的4个实例对象
    KEYPRESS("keypress", 1), KEYRELEASE("keyrelease", 2), KEYLEFT("keyleft", 3), KEYRIGHT("keyright", 4);

    //枚举对象属性
    private String name;
    private int serioNo;

    //枚举类构造方法
    EventEnum(String name, int serioNo) {
        this.name = name;
        this.serioNo = serioNo;
    }

    public void excute() {

        EventEnum[] values = EventEnum.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println("values[i].toString()[]===》" + values[i].toString());
            System.out.println(values[i].name);
            System.out.println(values[i].serioNo);
            System.out.println("=============================");
        }

    }

}
