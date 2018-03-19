import java.util.*;
/*
	键是什么样的键 ： 先入为主的键
	值是什么样的值 ： 后来替换的值
*/
public class TestHashSet5Plus{
	public static void main(String[] args){
		Map<Student,String> map = new HashMap<>();
		Student s1 = new Student("ETOAK");
		Student s2 = new Student("BDQN");
		map.put(s1,"很渣哦~");
		map.put(s2,"超赞哦~");
		System.out.println(map);
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