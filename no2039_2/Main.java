package com.no2039_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		try {
			int[] arr = new int[9];
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);

			int sum = 0;
			for (int i = 0; i < 9; i++) {
				sum += arr[i];
			}

			// 두 난쟁이 키의 합 = (9개를 총 더한 값 - 100)
			sum = sum - 100;
			int except1 = 0;
			int except2 = 0;
			boolean isQuit = false;

			for (int i = 0; i < 8; i++) {
				for (int j = i; j < 9; j++) {
					if (sum == arr[i] + arr[j]) {
						// 이 두 난쟁이를 빼면 답.
						except1 = i;
						except2 = j;
						isQuit = true;
						break;
					}
				}
				if (isQuit)
					break;
			}

			for (int i = 0; i < 9; i++) {
				if (i != except1 && i != except2) {
					System.out.println(arr[i]);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
