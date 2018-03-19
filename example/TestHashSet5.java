import java.util.*;
//如果添加元素的时候 认定元素重复
//那么集合当中究竟是新元素还是老元素？
/*
	HashSet先入为主 先到先得 后来的重复元素直接舍弃
	不会替换原有元素！
*/
public class TestHashSet5{
	public static void main(String[] args){
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("ETOAK");
		Student s2 = new Student("BDQN");
		set.add(s1);
		set.add(s2);
		System.out.println(set.size());
		System.out.println(set);
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public int hashCode(){
		return 1;
	}
	@Override
	public boolean equals(Object obj){
		return true;
	}
}