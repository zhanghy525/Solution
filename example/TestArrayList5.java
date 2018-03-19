import java.util.*;
public class TestArrayList5{
	/**
		谁主张谁举证：
			要被删除的那个对象会主动调用他自己类的equals方法
			和集合里面的每一个元素做比较
	*/
	public static void main(String[] args){

		ArrayList<Object> list = new ArrayList<>();

		Student stu = new Student("张三");
		Teacher tea = new Teacher("Tom");

		list.add(tea);
		System.out.println(list.size());//1

		list.remove(stu);//stu.equals(集合里面的每一个元素)
		//Student -> equals() -> 0
		//Teacher -> equals() -> 1
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
		return true;//即使完全不同的两个对象 也被视为相等的对象
	}
}

class Teacher{
	String name;
	public Teacher(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		return false;//即使内存里面相同的对象 也被视为不同的两个对象
	}
}