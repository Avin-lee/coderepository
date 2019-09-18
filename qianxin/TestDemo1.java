package com.lee.qianxin;

/**
 * @Author Avin lee
 * @Create 2019/9/16 19:45 by IntelliJ IDEA
 * @Description 连续最长数字字串
 */
public class TestDemo1 {
    public static String find_longest_num_str(String input) {
        int max = 0;
        int count = 0;
        int end = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }
        return input.substring(end - max + 1, end + 1);
    }
}
