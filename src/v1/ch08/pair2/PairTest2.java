package v1.ch08.pair2;

import v1.ch08.pair1.Pair;

public class PairTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class ArrayAlg{
	@SuppressWarnings("unchecked")
	public static <T extends Comparable> Pair<T> minmax(T[] a) {
		if(a==null||a.length==0)return null;
		T min=a[0];
		T max=a[0];
		for (int i = 0; i < a.length; i++) {
			if(min.compareTo(a[i])>0)min=a[i];
			if(max.compareTo(a[i])<0)max=a[i];
		}
		return new Pair<>(min, max);
	}
}
