package debug;

import org.junit.Test;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/18
 * @description:
 */
public class Debug {
    private int getGCD(int a,int b){
        if(b == 0){
            return a;
        }
        return getGCD(b,a%b);

    }
    @Test
    public void debug(){

        System.out.println(getGCD(0,0));
    }
}
