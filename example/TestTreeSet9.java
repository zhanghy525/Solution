import java.util.*;
/*
	我们迫切的需要一种能够脱离开一个类的类体
		还能制定这个类型比较规则的方式~

		Comparable   adj.  有能力比较的
		Comparator   n.    用来比较的工具（天平、跷跷板）
*/
public class TestTreeSet9{
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>(new QQB());
		Collections.addAll(set,55,33,44,11,22);
		//我要降序！
		System.out.println(set);
	}
}
class QQB implements Comparator<Integer>{
	@Override
	public int compare(Integer i1,Integer i2){
		//i1是新元素   i2是老元素
		return i2 - i1;
	}
}