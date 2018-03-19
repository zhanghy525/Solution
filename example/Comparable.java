import java.util.*;
//易途盛世大酒店只能点餐系统
/*
	如何借助多个属性有优先级别的形成排序规则
*/
public class TestTreeSet4{
	public static void main(String[] args){
		Set<Food> order = new TreeSet<>(new Comparator<Food>(){
			@Override
			public int compare(Food f1,Food f2){
				//当我们需要用多个属性综合得出比较规则的时候
				//那么请 优先尊重什么属性 就先描述假如什么属性不同！
				if(f1.type != f2.type)
					return f1.type - f2.type;
				if(f1.price != f2.price)
					return f2.price - f1.price;
				if(!f1.name.equals(f2.name))
					return f1.name.compareTo(f2.name);
				return 1;

				/*
				if(f1.type == f2.type){//类型相同
					if(f1.price == f2.price){
						if(f1.name.equals(f2.name)){
							return 1;
						}else{//
							return f1.name.compareTo(f2.name);
						}
					}else{//类型相同但是价格不同
						return f2.price - f1.price;
					}
				}else{//类型不同
					return f1.type - f2.type;
				}
				*/
			}
		});
		Food f1 = new Food("斩青龙",18,1);
		Food f2 = new Food("雪盖火山",18,1);
		Food f3 = new Food("龙虎斗",256,2);
		Food f4 = new Food("忍者神龟",550,2);
		Food f5 = new Food("82年的雪碧",20,0);
		Food f6 = new Food("茅台",2600,0);
		Food f7 = new Food("岩浆",20,3);
		Food f8 = new Food("米饭",5,4);
		Collections.addAll(order,f1,f2,f3,f4,f5,f6,f7,f8);
		order.forEach(System.out::println);
		order.forEach(x -> System.out.println(x.price));

		//商家决定 50元以上的菜品7折优惠
		List<Food> list = new ArrayList<>();
		for(Iterator<Food> car = order.iterator(); car.hasNext(); ){
			Food f = car.next();
			if(f.price > 50){
				car.remove();//1st.
				f.price = f.price * 7 / 10;//2nd.
				list.add(f);
			}
		}
		order.addAll(list);
		order.forEach(System.out::println);

		/*
		//黄瓜缺货 请删除斩青龙
		for(Iterator<Food> car = order.iterator(); car.hasNext(); ){
			Food f = car.next();
			if("斩青龙".equals(f.name)){
				car.remove();
			}
		}
		order.forEach(System.out::println);
		*/
	}
}
class Food{//菜 食物
	String name;
	int price;
	int type;//0.酒水 1.凉菜 2.热菜 3.汤品 4.主食
	private final static String[] data = "酒水,凉菜,热菜,汤品,主食".split(",");
	public Food(String name,int price,int type){
		this.name = name;
		this.price = price;
		this.type = type;
	}
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(data[type]).append(" : ").append(name).append(" ").append(price).append(" 元");
		return str.toString();
	}
	/*
		首先按照类型升序排列
		如果类型相同 则按照价格降序排列
		如果类型价格都相同 那么按照名字排序
		如果都都都一样 也不能舍弃 而要先来后到 反正都要
	*/

}
