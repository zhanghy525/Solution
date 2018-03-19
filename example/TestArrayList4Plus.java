import java.util.*;
public class TestArrayList4Plus{
	public static void main(String[] args){
		ArrayList<Student> list = new ArrayList<>();

		Student stu1 = new Student("张三");
		//Student stu2 = new Student("李四");

		list.add(stu1);

		System.out.println(list.size());

		list.remove(stu1);//remove(Object) -> equals
		System.out.println(list.size());//0
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}

	@Override
	public boolean equals(Object obj){
		//return true;//即使是内存里面完全不同的两个对象 也被视为相等对象
		return false;//即使是内存里面的同一个对象 也被视为不同的两个对象

	}
}



















