package com.jason.algorithm;

import java.util.*;
import java.util.Map.Entry;

public class tuijian {
public int[] recommend (String pro){
	String [] pro1=pro.split(",");
	int[] pro2=new int[pro1.length];
	for (int i =0,len=pro1.length;i<len;i++)
	{pro2[i]=Integer.valueOf(pro1[i]);		
	}
	Random r=new Random();
	int[] re =new int[2];
	int c =r.nextInt(pro1.length-1)+1;
	re[0]=pro2[c];
	int cc=pro2[c];
	int rand;
	
	while(cc!=(rand =r.nextInt(10)+1)){
		re[1]=rand;
	}
	
	
	return re;
	
//	Map pro3 =new HashMap();
//	
//	for(int i =0 ,a=pro1.length;i<a;i++){
//		int c =Integer.valueOf(pro1[i]);
//		int count = 1;
////		double d =c/a;
//	    if (pro3.containsKey(c)) {//判断刚输入的单词是否已经存在  
//            count = (int)pro3.get(c)+1;//如果已经存在，新的个数就在已有的个数上加1  
//        }  
//	    pro3.put(c, count);//插入新的数据  
//	}
//	
//	Iterator it = pro3.entrySet().iterator(); 	
//	while (it.hasNext()){
//		 Entry entry = (Entry) it.next();  
//		int key=(int)entry.getKey();
//		int value=(int)entry.getValue();
//		
//		
//	}
	

}
//public static  void main (String[] args){
//	tuijian tj =new tuijian();
//	int [] s =tj.recommend("1,1,2,1,1,1,3,4,");
//	
//	for (int i =0,a=s.length;i<a;i++){
//		System.out.println(s[i]+"sasas");}		
//	
//
//}
}
