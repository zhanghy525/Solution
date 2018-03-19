import java.util.*;
//构造方法可以传参:分组组数,加载因子
/*
	分组组数 int 默认为16 可以随意的指定
			但是最终一定会是不小于它的2的n次方
			MUST BE A POWER OF TWO ...

	加载因子 float 默认值0.75F 可以随意指定 可以大于1.0F

	加载因子是为了调整阈值的
		达到某个条件的最小临界值 => 达到扩容条件的最小临界值
		阈值 = (int)(分组组数*加载因子)

	HashSet还需要扩容吗？
		HashSet 哈希表 = 数组+链表 哈希表 = 链表的数组
		HashSet之所以要扩容 不是为了不扩不行 而是要活的更好

	怎么扩： 原本16组 扩容后32组 每次都会*2

	你要明白 每次扩容之后 原本在某个小组的元素 未必还应该在那个位置


*/
public class TestHashSet9{
	public static void main(String[] args){
		Set<Integer> set = new HashSet<>(16,0.75F);
	}
	public static void show(int x){
		//请打印不小于98的最小的7的倍数
		//System.out.println((93/7+1)*7);

		//打印不小于x的最小的2的n次方数
		/*
		int ok = 1;
		while(ok < x){
			ok <<= 1;//ok = ok << 1;   ==  ok = ok * 2;
		}
		System.out.println(ok);
		*/
	}
}