import java.util.*;
	/**
		ArrayList特点：
			有序：按照添加顺序
			不唯一：同一个元素可以存放多次
	*/
public class TestArrayList1{
	public static void main(String[] args){

		//如何创建一个集合对象
		//jdk5.0之前 默认王集合里面装的都是Object类型的对象
		//ArrayList list = new ArrayList();

		//jdk5.0开始 可以添加泛型
		//泛型：集合里面只能装某一种数据类型
		//ArrayList<Integer> list = new ArrayList<Integer>();

		//jdk7.0开始 后面的泛型会自动推断
		ArrayList<Integer> list = new ArrayList<>();


		//如何往集合里面添加元素
		//一次添加一个元素：
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2);
		//一次添加多个元素：
		Collections.addAll(list,6,7,8,9,10);


		//如何得到某一个元素：
		System.out.println(list.get(7));

		//如何得到集合的元素个数：
		System.out.println(list.size());

		//如何判断集合里面是否存在某一个元素：
		System.out.println(list.contains(5));
		//String -> contains()
		//ArrayList -> contains()

		//如何遍历集合对象
		//for + 下标
		for(int x = 0;x < list.size();x++){
			//x -> 下标
			//list.get(x) -> 元素
			//System.out.println(list.get(x));
		}

		//foreach
		for(Integer x : list){
			//x -》 元素
			System.out.println(x);
		}






		//System.out.println(list);//list.toString()
								//[元素1,元素2,元素3....]





	}

	//封装一个方法 一次往ArrayList集合里面添加多个元素
	//第一个参数：明确往哪个集合对象里面添加
	//第二个参数：明确往集合里面添加哪些元素

	//TestArrayList1.addAll(list,34,55,72,18,90);
	public static void addAll(ArrayList<Integer> jiHe,Integer ... data){
		for(Integer x : data){
			jiHe.add(x);
		}
	}


}