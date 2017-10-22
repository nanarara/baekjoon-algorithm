package com.no5585;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			int input = Integer.parseInt(br.readLine());

			int money = 1000 - input;
			int result = 0;
			// 500, 100, 50, 10, 5, 1
			int m = money / 500;
			result += m;
			money = money % 500;

			int h = money / 100;
			result += h;
			money = money % 100;

			int f = money / 50;
			result += f;
			money = money % 50;

			int t = money / 10;
			result += t;
			money = money % 10;

			int ff = money / 5;
			result += ff;
			money = money % 5;

			result += money;

			System.out.println(result);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
