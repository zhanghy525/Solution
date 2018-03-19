import java.util.*;

public class TestTreeSet9Plus{
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>((a,b) -> b-a);
		Collections.addAll(set,55,33,44,11,22);
		//我要降序！
		System.out.println(set);
	}
}
