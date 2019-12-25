import java.util.*;

public class Solution {

	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
    
        String temp = sc.nextLine();
        int n = Integer.valueOf(temp);

    	for(int i = 0; i < n; i++) {
        	String ns = sc.nextLine();
        	//System.out.println(ns);
        	String[] ss = ns.split("\\s");
        	
        	int[] is = new int[12];
        
        	for(int ii = 0; ii < 12; ii++) {
        		is[ii] = Integer.valueOf(ss[ii + 1]);
        	}
        	
        	int count = 0;
        	
        	boolean dp[][] = new boolean[12][12];
        	
        	for(int j = 1; j <= 10; j++) {
        		if(is[j] > is[j - 1] && is[j] > is[j + 1]) count += 1;
        	}
        	
        	for(int j = 1; j <= 9; j++) {
        		if(is[j] > is[j - 1] && is[j] > is[j + 2] && is[j + 1] > is[j - 1] && is[j + 1] > is[j + 2]) count += 1;
        	}
        	
        	for(int off = 2; off <= 9; off++) {
        		for(int j = 1; j + off <= 10; j++) {
        			boolean flag = true;
        			int sm = Math.max(is[j - 1], is[j + off + 1]);
        			for(int k = j; k <= j + off; k++) {
        				if(is[k] <= sm) {
        					flag = false;
        					break;
        				}
        			}
        			if(flag) count += 1;
        		}
        	}

    		System.out.print(ss[0] + " ");
    		System.out.println(count);

    	}


    }

}