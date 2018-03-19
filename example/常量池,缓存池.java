public class TestArrayList0Plus1{
	public static void main(String[] args){

		//Integer会自动缓存-128到127之间所有的数字
		Integer num1 = -129;
		Integer num2 = -129;

		System.out.println(num1 == num2);//地址

		String str1 = "etoak";
		String str2 = "etoak";
		System.out.println(str1 == str2);
	}
}