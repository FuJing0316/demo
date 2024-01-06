public class TwoArray{
	public static void main(String[] args){
		//声明一维数组
		int arr[] = new int[6];
		//二维数组:高维length必须先声明
		int[][] arr1 = new int[3][];
		//创建二维数组对象
		arr1[0] = new int[2];
		arr1[1] = new int[3];
		arr1[2] = new int[4];
		
		//赋值
		arr1[0][0] = 1;
		arr1[0][1] = 2;
		
		arr1[1][0] = 3;
		arr1[1][1] = 4;
		arr1[1][2] = 5;
		
		arr1[2][0] = 6;
		arr1[2][1] = 7;
		arr1[2][2] = 8;
		arr1[2][3] = 9;
		
		for(int i = 0;i<arr1.length;i++){
			for(int j = 0;j<arr1[i].length;j++){
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}