package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(0);

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int item = Integer.parseInt(st.nextToken());

			if (item > list.get(list.size() - 1))
				list.add(item);
			else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {
					int mid = (left + right) >> 1;
					if (list.get(mid) >= item) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				list.set(right, item);
//                System.out.println(left + " " + right);
			}
			System.out.println(list);
		}
		System.out.println(list.size() - 1);
	}
}
