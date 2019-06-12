package cn.edu.cuit.study.constant;

import java.util.Random;

/**
 * 随机生成6位数的账号
 * @author zjj
 */
public class RandomCode {
    public static int RanCode(){
        int code = 0;
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        for(int i = 0; i < 6; i++)
            code = code * 10 + array[i];
        return code;

    }

}
