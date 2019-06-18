package chen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈伟帅
 * @ClassName ReverseInt
 * @Date:Created 17:05 2019-5-29
 * @description 将 -2147483648 ~ 2147483647  其中某个数字的位置反转
 **/
public class ReverseInt {

    public int getReverseNum(int n) {
        //判断是否大于0
        long resule = 0;
        n = n < 0 ? 0 - n : n;
        List<Integer> num = new ArrayList<>();
        while (n > 9) {
            num.add(n % 10);
            n /= 10;
        }
        num.add(n);
        System.out.println(num);
        int len = num.size();
        for (int i = 0; i < len; i++) {
            resule += num.get(i) * Math.pow(10, i);
        }
        return 0;
    }

    public static void main(String[] args) {
        new ReverseInt().getReverseNum(-0);
    }


}
