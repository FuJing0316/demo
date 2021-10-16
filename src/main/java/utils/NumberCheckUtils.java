package utils;

import java.math.BigDecimal;

/**
 * @Author: fujing
 * @Date: 2021/10/16
 * @Description:
 * @Version: 1.0
 */
public class NumberCheckUtils {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.0");
        BigDecimal b = new BigDecimal("0.00");
        BigDecimal c = new BigDecimal("0");

        System.out.println(isZeroValueOrEmpty(a)); //true
        System.out.println(isZeroOrEmpty(b));//false
        System.out.println(isZeroOrEmpty(c));//true
    }

    /**
     * 检查BigDecimal数值是否为null或0（不区分精度，0和0.0、0.00认为是相同的，均为0）
     * @param num
     * @return
     */
    public static boolean isZeroValueOrEmpty(BigDecimal num){
        if (num == null || BigDecimal.ZERO .compareTo(num) == 0){
            return true;
        }
        return false;
    }

    /**
     * 检查BigDecimal是否为null或0(区分精度，BigDecimal.ZERO精度为0）
     * @param num
     * @return
     */
    public static boolean isZeroOrEmpty(BigDecimal num){
        if (num == null || BigDecimal.ZERO .equals(num)){
            return true;
        }
        return false;
    }

}
