package swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class D4_Solution_1824 {
	static boolean[][][][] visited; 
	static class Point {
		public Point() {}
		int x,y,dir,memo;
		public Point(int x, int y, int dir, int memo) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.memo = memo;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", memo=" + memo + "]";
		}
	}
}