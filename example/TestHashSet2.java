import java.util.*;
/*
	HashSet所谓的唯一 不是真正的唯一 而是"唯一"
		即便是内存当中完全不同的两个对象
			也有可能被HashSet视作同一个对象 从而拒之门外
*/
public class TestHashSet2{
	public static void main(String[] args){
		Set<String> set = new HashSet<>();
		String str1 = new String("ETOAK");
		String str2 = new String("ETOAK");
		System.out.println(str1 == str2);//false
		set.add(str1);
		set.add(str2);
		System.out.println(set.size());//1
		/*
		Set<Integer> set = new HashSet<>();
		Integer num1 = new Integer(222);
		Integer num2 = new Integer(222);
		System.out.println(num1 == num2);//false
		set.add(num1);
		set.add(num2);
		System.out.println(set.size());//1
		*/
	}
}