package leetcode_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class Solution {
    private List<List<String>> res=new ArrayList<>();
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    public List<List<String>> solveNQueens(int n) {
        if(n==0){
            return res;
        }
        //尝试在一个n皇后的问题中摆放第0行皇后的位置
        LinkedList<Integer> row = new LinkedList<>();
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        putQueen(n,0,row);
        return res;
    }

    private void putQueen(int n,int index, LinkedList<Integer> row){
        if(index == n){
            res.add(rowToResult(row,n));
            return;
        }

        /*
        尝试将皇后摆放至index行i列
        每列都试一下
        */
        for(int i=0;i<n;i++){
            if(!col[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){
                col[i]=true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                row.addLast(i);
                putQueen(n,index+1,row);
                //回朔
                row.removeLast();
                col[i]=false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
            }
        }
        return;

    }

    private List<String> rowToResult(LinkedList<Integer> row,int n){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] charArray = new char[n];
            Arrays.fill(charArray,'.');
            charArray[row.get(i)] = 'Q';
            temp.add(new String(charArray));
        }
        return temp;
    }
}
