package java. java.baekjoon;

import java.util.Scanner;

public class Main_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num + 1];
		arr[0] = -999;
		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt();
		int[][] students = new int[studentNum][2];
		for (int i = 0; i < studentNum; i++) {
			int sex = sc.nextInt();
			if (sex == 1) {
				students[i][0] = sex;
				students[i][1] = sc.nextInt();
			} else if (sex == 2) {
				students[i][0] = sex;
				students[i][1] = sc.nextInt();
			}
		}

		for (int i = 0; i < studentNum; i++) {
			if (students[i][0] == 1) {
				int index = students[i][1];
				int j = index;
				while (index < arr.length) {
					if (arr[index] == 0) {
						arr[index] = 1;
					} else if (arr[index] == 1) {
						arr[index] = 0;
					}
					index += j;
				}
			}

			if (students[i][0] == 2) {
				int index = students[i][1];
				if (arr[index] == 0) {
					arr[index] = 1;
				} else if (arr[index] == 1) {
					arr[index] = 0;
				}
				int j = 1;
				while (((index + j) < arr.length && (index - j) > 0)) {
					if (arr[index - j] != arr[index + j])
						break;
					if (arr[index + j] == 0) {
						arr[index + j] = 1;
						arr[index - j] = 1;
					} else if (arr[index + j] == 1) {
						arr[index + j] = 0;
						arr[index - j] = 0;
					}
					j++;
				}
			}
		}

		for (int i = 1; i <= num; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
		sc.close();
	}

}
