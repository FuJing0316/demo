import java.util.Arrays;
public class ArraySort{
	
	//ð�����򣺽������С��������
	public static void main(String[] args){
		
		//��������
		int[] arr = {8,5,3,7,9};
		System.out.println("����ǰ��" + Arrays.toString(arr));
				
		//���ѭ�������Ʊ����Ĵ���
		for(int i = 0;i<arr.length-1;i++){
			//�ڲ�ѭ��������Ԫ�رȽϣ������ƶ�
			for(int j=0; j < arr.length-1-i;j++){
				//�ڲ�ѭ������߼�����Ԫ�رȽ� ����Ԫ��
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			
		}
		System.out.println("�����" + Arrays.toString(arr));		
	}
}