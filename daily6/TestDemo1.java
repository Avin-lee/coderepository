package com.lee.july.day12;

/**
 * @Author Lee
 * @Create 2019/7/12 22:45
 * @Description 生成格雷码
 */
public class TestDemo1 {
    public String[] getGray(int n) {
        String[] ret = null;
        if(n == 1){
            ret = new String[]{"0","1"};
        }else{
            String[] strs = getGray(n-1);
            ret = new String[2*strs.length];
            for(int i=0; i<strs.length; i++){
                ret[i] = "0"+strs[i];
                ret[ret.length-1-i] = "1"+strs[i];
            }
        }
        return ret;
    }

}
