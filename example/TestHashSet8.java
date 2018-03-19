import java.util.*;
/*
	使用HashSet 千万不要在添加元素之后
		直接修改参与生成哈希码的属性 否则会破坏整个哈希表的结构
		从而导致非常可怕的事情发生(删删不掉 添能添俩)

	如果需求决定 一定要去修改属性
		那么必须1删除 2修改 3重新添加(重新计算散列位置了)
*/
public class TestHashSet8{
	public static void main(String[] args){
		System.out.println("神说要有易途 于是便有了易途");
		Set<Teacher> etoak = new HashSet<>();
		System.out.println("神说要有周爹 于是便有了周爹");
		Teacher tea = new Teacher("Jay",16);
		System.out.println("意气风发的周老师毅然决然的加入了易途的创业团队");
		etoak.add(tea);
		System.out.println("时光荏苒 岁月如梭 转眼间 那个小伙老了");
		etoak.remove(tea);
		tea.age = 61;
		etoak.add(tea);

		System.out.println("易途繁重的教学任务 他已经无力承担了 易途董事会研究决定 开除他");
		etoak.remove(tea);
		etoak.remove(tea);
		etoak.remove(tea);
		etoak.remove(tea);
		etoak.remove(tea);
		System.out.println(etoak);
	}
}
class Teacher{
	String name;
	int age;
	public Teacher(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return name + " : " + age;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof Teacher)) return false;
		if(obj == this) return true;
		Teacher t1 = this;
		Teacher t2 = (Teacher)obj;
		return t1.age == t2.age && t1.name.equals(t2.name);
	}
	@Override
	public int hashCode(){
		return name.hashCode() + age;
	}
}