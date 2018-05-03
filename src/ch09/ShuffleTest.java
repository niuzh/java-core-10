package ch09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbewrs=new ArrayList<>();
		for (int i = 0; i <=49; i++) {
			numbewrs.add(i);
		}
		Collections.shuffle(numbewrs);
		List<Integer> winningCombination=numbewrs.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
	}

}
