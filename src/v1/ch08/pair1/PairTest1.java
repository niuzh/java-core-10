package v1.ch08.pair1;

public class PairTest1 {

	public static void main(String[] args) {
		String[] words={"mary","had","a","little","lamb"};
		Pair<String> mm=ArrayAlg.minMax(words);
		System.out.println("min="+mm.getFirst());
		System.out.println("max="+mm.getSecond());
	}

}
class ArrayAlg{
	public static Pair<String> minMax(String[] a) {
		if(a==null||a.length==0)return null;
		String min=a[0];
		String max=a[0];
		for (String string : a) {
			if(min.compareTo(string)>0)min=string;
			if(max.compareTo(string)<0)max=string;
		}
		return new Pair<String>(min, max);
	}
}
