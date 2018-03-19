public class TestDataType6{
	public static void main(String[] args){
		//double x = 45;
		//（short） 【int】 long float 【double】
		//test(x);

		int x = 45;
		//【short】  （int）  long  float  【double】
		test(x);
	}

	//自己定义方法
	//修饰符 + 返回类型 + 方法签名（名 + 参数）

	//当我们定义的方法和main方法在同一个类体的时候
	//尽量加上static

	public static void test(short x){
		System.out.println("传short类型的参数");
	}

	public static void test(double x){
		System.out.println("传double类型的参数");
	}

	/*
	public static void test(double x){
		System.out.println("传double类型参数的方法");
	}

	public static void test(int x){
		System.out.println("传int类型参数的方法");
	}
	*/
}
