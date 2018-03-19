import java.util.*;
/*
	使用TreeSet 千万不要在添加元素之后
		直接修改那些参与排序的属性~ 否则会破坏整个树的结构
	[TreeSet很强大 能够在添加元素的时候 自动排序] -> 褒义
	[TreeSet不强大 只能在添加元素的时候 自动排序] -> 贬义

	如果需求决定一定要去修改
		那么三个步骤完成:
			1.删除(当心5)  2.修改属性  3.重新添加(当心6)
*/
public class TestTreeSet7{
	public static void main(String[] args){
		Set<A> set = new TreeSet<>();
		//创业初期 我们决定购入一辆奥迪轿车 用于商务接洽~
		A no1 = new A(4);
		set.add(no1);
		//后来 公司发展壮大 我们决定A8
		A no2 = new A(8);
		set.remove(no2);
		no2.num = 1;
		set.add(no2);
		/*
		set.add(no2);
		System.out.println(set);
		//再后来 我们觉得A8太难停车了！！！
		no2.num = 1;//奥迪A1
		*/
		System.out.println(set);
	}
}
class A implements Comparable<A>{//奥迪的一个系列
	int num;
	public A(int num){
		this.num = num;
	}
	@Override
	public int compareTo(A a){
		A a1 = this;
		A a2 = a;
		return a1.num - a2.num;
	}
	@Override
	public String toString(){
		return String.valueOf(num);
	}
}