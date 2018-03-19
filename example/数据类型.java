import java.math.*;
public class TestDataType6{
	public static void main(String[] args){
		
		//整数类型的赋值方式：

		int num1 = 24;//通过十进制进行赋值 *****
		//=====================================
		int num2 = 024;//通过八进制进行赋值
		int num3 = 0x24;//通过十六进制进行赋值
		int num4 = 0b1011;//通过二进制进行赋值   jdk7.0

		System.out.println(num1);//24
		System.out.println(num2);//024 = 2 * 8(1) + 4 * 8(0) = 16 + 4 = 20
		System.out.println(num3);//0x24 = 2 * 16(1) + 4 * 16(0) = 32 + 4 = 36
		System.out.println(num4);

		//81 + 8 * 8(1) + 1 * 8(0) + 8 * 16(1) + 1 * 16(0) =
		//System.out.println(81 + 081 + 0x81);

		//二进制：0  1
		//八进制：0 -7
		//十六进制：0 - 9    a - f

		System.out.println(64_735_648);

		//System.out.println(2.0 - 1.1);//17.1

		BigDecimal b1 = new BigDecimal("2.0");
		BigDecimal b2 = new BigDecimal("1.1");

		BigDecimal b3 = b1.subtract(b2);

		System.out.println(b3);

		/**
		1:  2.0-1.1结果为多少？
			反正不是0.9

		2： 为什么会出现上面的结果？
			在java中任何一个整数都可以用二进制精确的表示出来
			但是不代表任何一个小数也可以在有限的位数里面
			表示出来 比如1.1出现了数值位的截取 导致数值不正确

		3： 怎么解决？
			数值扩大100倍 单位缩小100倍


		*/
		BigDecimal b1 = new BigDecimal("1.0");

		for (int x = 1; x <= 10; x++) {
			BigDecimal b2 = new BigDecimal("0.1");
			b1 = b1.add(b2);
			System.out.println(b1);
		}



	}
}