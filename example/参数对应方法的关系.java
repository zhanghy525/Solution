public class TestDataType6{
	public static void main(String[] args){
		//double x = 45;
		//��short�� ��int�� long float ��double��
		//test(x);

		int x = 45;
		//��short��  ��int��  long  float  ��double��
		test(x);
	}

	//�Լ����巽��
	//���η� + �������� + ����ǩ������ + ������

	//�����Ƕ���ķ�����main������ͬһ�������ʱ��
	//��������static

	public static void test(short x){
		System.out.println("��short���͵Ĳ���");
	}

	public static void test(double x){
		System.out.println("��double���͵Ĳ���");
	}

	/*
	public static void test(double x){
		System.out.println("��double���Ͳ����ķ���");
	}

	public static void test(int x){
		System.out.println("��int���Ͳ����ķ���");
	}
	*/
}
