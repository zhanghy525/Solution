public class Test1{
	public static void main(String[] args){

		//test();
		//test(34);
		//test(34,55);
		test(78,99,10);

	}
	/**
		�ɱ�Σ���������������0-������
		�ɱ�εײ��������ʵ�ֵ�

		ע���֪ʶ�㣺
			1��һ����������ֻ�ܴ���һ���ɱ��
			2���ɱ��ֻ�ܷ��ڲ��������
			3����ǰ�������治Ҫ�ٴγ���һ���ȼ۵��������͵Ĳ���
	*/
	public static void test(int ... data){
		for(int x : data){
			System.out.println(x);
		}
	}


}