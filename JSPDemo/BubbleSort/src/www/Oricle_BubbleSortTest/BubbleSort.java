package www.Oricle_BubbleSortTest;

import java.util.Date;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = 0;
		int k = 0;
		String s = "sdsa"+new Date().toString();
		String[] ss = s.split("#");
		System.out.println(ss[1]);
		int [] array = new int [10];
		//创建数组存储随机数并输出
		System.out.println("排序前的数组为：");
       for (int i = 0; i < array.length; i++) {
		array[i] = (int) (Math.random()*100+1);
		System.out.print(array[i]+" ");
	}
       System.out.println();
       //冒泡排序
       for (k = 0; k < array.length - 1 ; k++) {
		for (l = 0; l < array.length - 1 - k ; l++) {
			if (array[l] > array[l+1]) {				
				int temp = array[l];
				array[l] = array[l+1];
				array[l+1] = temp;			
				}
		}
	}
       System.out.println("排序后的数组为：");
       for (int o = 0; o < array.length; o++) {
   		System.out.print(array[o]+" ");
   	}
	}

}
