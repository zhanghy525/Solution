public class Test1{
	public static void main(String[] args){

		//test();
		//test(34);
		//test(34,55);
		test(78,99,10);

	}
	/**
		可变参：参数个数可以是0-无数个
		可变参底层基于数组实现的

		注意的知识点：
			1：一个方法里面只能存在一个可变参
			2：可变参只能放在参数的最后
			3：当前类体里面不要再次出现一个等价的数组类型的参数
	*/
	public static void test(int ... data){
		for(int x : data){
			System.out.println(x);
		}
	}


}