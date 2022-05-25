package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143 {
	static int R, C;
	static int[] dx = { -1, 1, 0, 0 }; /// 위 아 오 왼
	static int[] dy = { 0, 0, 1, -1 };

	static class Shark {
		int x, y, d, s, z; // x,y,방향,크기

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.z = z;
		}

		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", d=" + d + ", s=" + s + ", z=" + z + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		/*
		 * 체크 1. 낚시왕이 오른쪽으로 한칸 이동한다 -> 총 열의 수 만큼 반복 2. 낚시왕이 땅이랑 가까운 상어를 잡는다 -> 낚시왕의 열에서
		 * 열이 가장 큰 것을 잡는다 3. 상어가 이동한다 -> 이동을 할 때 같은 위치면 크기가 큰 것이 먹음 , 추가적으로 벽이랑 부딪히면
		 * 반대방향으로 가야함.
		 * 
		 * 시간 초과가 포인트 -> 순환을 제거 자기자리로 돌아오는 경우를 %로 빼줌.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[][] map = new Shark[R + 1][C + 1];
		ArrayList<Shark> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
			list.add(map[r][c]);
		}

		int ans = 0;
		for (int i = 1; i <= C; i++) { // 열의 수만큼 반복

			for (int j = 1; j <= R; j++) { // 상어 잡기
				if (map[j][i] != null) {
					ans += map[j][i].z;
					list.remove(map[j][i]);
					map[j][i] = null; // 상어삭제
					break;
				}
			}
			for (Shark data : list) { // 상어 이동
				int x = data.x;
				int y = data.y;
				map[x][y] = null;
				if (data.d == 1 || data.d == 2) {
					data.s = data.s % (R * 2 - 2);
				} else {
					data.s = data.s % (C * 2 - 2);
				}
				for (int m = 0; m < data.s; m++) { // 속도만큼 반복
					x = x + dx[data.d - 1];
					y = y + dy[data.d - 1];
					if (x <= 0 || x >= R + 1 || y <= 0 || y >= C + 1) {
						if ((data.d - 1) % 2 == 0) { // 0 2 위 오른쪽일때
							data.d += 1;
						} else {
							data.d -= 1; // 1 3 아래 왼쪽일때
						}
						x = x + 2 * dx[data.d - 1];
						y = y + 2 * dy[data.d - 1];
					}
				}
				data.x = x;
				data.y = y;
			}

			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				Shark data = list.get(j);
				if (map[data.x][data.y] == null) {
					map[data.x][data.y] = data;
				} else {
					if (data.z > map[data.x][data.y].z) {
						list.remove(map[data.x][data.y]);
						map[data.x][data.y] = data;
					} else {
						list.remove(data);
					}
				}
			}

		}
		System.out.println(ans);

	}
}
