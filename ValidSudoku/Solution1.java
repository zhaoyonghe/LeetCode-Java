package ValidSudoku;
import java.util.BitSet;
public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet bs = new BitSet(9);
		bs.set(1);
		System.out.println(bs.cardinality());
		System.out.println(bs.toString());
		bs.set(2);
		System.out.println(bs.cardinality());
		System.out.println(bs.toString());
		bs.set(3, 7);
		System.out.println(bs.cardinality());
		System.out.println(bs.toString());
		bs.clear(2, 4);
		System.out.println(bs.cardinality());
		System.out.println(bs.toString());
		long begintime;
		long endtime;
		long costTime;
		begintime = System.nanoTime();
		for(int i = 0; i < 100000; i++) {
			bs.cardinality();
		}
		endtime = System.nanoTime();
		costTime = (endtime - begintime)/1000;
		System.out.println(costTime);
		begintime = System.nanoTime();
		for(int i = 0; i < 100000; i++) {
			for(int j = 0; j < 9; j++) {
				bs.get(j);
			}
		}
		endtime = System.nanoTime();
		costTime = (endtime - begintime)/1000;
		System.out.println(costTime);


		
	}

}
