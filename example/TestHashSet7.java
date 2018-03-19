import java.util.*;
/*
	关于删除元素 它根本不提供remove(int)
			get(int) remove(int) 都是List才有的！
	只提供了remove(Object) 它依然尊重三个步骤~
		hashCode() == equals()  添加尊重它 删除也尊重它!
*/
public class TestHashSet7{
	public static void main(String[] args){
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("Jay");
		Student s2 = new Student("Gay");
		set.add(s1);
		System.out.println(set.size());
		set.remove(s2);
		System.out.println(set.size());
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
	public boolean equals(Object obj){
		return true;
	}
	@Override
	public int hashCode(){
		return 1;
	}
}