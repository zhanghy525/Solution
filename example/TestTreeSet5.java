import java.util.*;
/*
	TreeSet的add() 和 remove() 都尊重compareTo()返回的结果
		如果compareTo()不能返回0 那么remove()将永远无法删除成功

	然而万恶的需求经常让compareTo()就不返回0
		此时如果想要删除元素 必须借助迭代器的car.remove();
*/
public class TestTreeSet5{
	public static void main(String[] args){
		Set<Teacher> set = new TreeSet<>();
		Teacher t1 = new Teacher("Jay");
		set.add(t1);
		set.remove(t1);
		set.remove(t1);
		set.remove(t1);
		System.out.println(set.size());//?
	}
}
class Teacher implements Comparable<Teacher>{
	String name;
	public Teacher(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public int compareTo(Teacher tea){
		return 1;
	}
}