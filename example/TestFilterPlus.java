import java.io.*;
//Filter => 过滤器 => 筛子
/*
	比较器 过滤器 这些接口 其实都是为了提供一个方法而存在的
	比较器为了提供compare()
	过滤器为了提供accept()
	然而在JDK8.0当中 这些接口都可以被lambda取代
	Java当中逐步的支持函数式编程
*/
public class TestFilterPlus{
	public static void main(String[] args){
		File dir = new File("c:\\windows\\system32");
		File[] fs = dir.listFiles( x -> x.isFile() && x.getName().toLowerCase().endsWith(".dll") );
		System.out.println(fs.length);
	}
}