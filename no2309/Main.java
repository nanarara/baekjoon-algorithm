package com.no2309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

			for (int i = 0; i < 9; i++) {
				for (int j = i + 1; j < 9; j++) {
					int sum = 0;
					if (i != j) {
						for (int k = 0; k < 9; k++) {
							if (k != i && k != j) {
								sum += arr[k];
							}
						}
					}
					if (sum == 100) {
						for (int k = 0; k < 9; k++) {
							if (k != i && k != j) {
								System.out.println(arr[k]);
							}
						}
						return;
					}
				}
			}
			
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
