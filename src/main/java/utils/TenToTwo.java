package utils;

import java.util.Scanner;
public class TenToTwo{
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ��ʮ��������");
		
		int number = scan.nextInt();
		String str = "";
		
		while(number != 0){
			int i = number % 2;
			str = i + str;
			number = number / 2;
			
		}
		System.out.println("תΪ������Ϊ��" + str);
	}
}