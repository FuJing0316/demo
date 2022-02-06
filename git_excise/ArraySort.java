import java.util.Arrays;
public class ArraySort{
	
	//冒泡排序：将数组从小到大排序
	public static void main(String[] args){
		
		//定义数组
		int[] arr = {8,5,3,7,9};
		System.out.println("排序前：" + Arrays.toString(arr));
				
		//外层循环：控制遍历的次数
		for(int i = 0;i<arr.length-1;i++){
			//内层循环：控制元素比较，升序移动
			for(int j=0; j < arr.length-1-i;j++){
				//内层循环里的逻辑：两元素比较 交换元素
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			
		}
		System.out.println("排序后：" + Arrays.toString(arr));		
	}
}