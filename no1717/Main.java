package com.no1717;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] parent;
	static int[] depth;

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);

			parent = new int[N + 1];
			depth = new int[N + 1];

			for (int i = 0; i < N + 1; i++) {
				parent[i] = -1;
				depth[i] = 1;
			}

			for (int i = 0; i < M; i++) {
				String[] str1 = br.readLine().split(" ");
				int a = Integer.parseInt(str1[0]);
				int b = Integer.parseInt(str1[1]);
				int c = Integer.parseInt(str1[2]);

				if (a == 0) {
					merge(b, c);
				} else if (a == 1) {
					if (find(b) == find(c)) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}

			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	static int find(int n) {
		// parent �迭�� n�� �ٷ� �� ��Ʈ ����� ���� �����Ѵ�.
		// �ʱ� ���� -1�� �����ϱ� ������ parent[n] == -1 �̶�� �ڱ� �ڽ��� ��Ʈ �̴�.
		if (parent[n] < 0)
			return n;

		parent[n] = find(parent[n]);
		return parent[n];
	}

	static void merge(int a, int b) {
		a = find(a); // a�� ��Ʈ ���� ã��
		b = find(b); // b�� ��Ʈ ���� ã��
		if (a == b)
			return; // �� ��Ʈ ���� �����Ƿ� �� ������ ����
		if (depth[a] == depth[b]) {
			parent[b] = a; // b�� ������ ��Ʈ a �ڽ����� �߰� ,
			depth[a]++;
		} else if (depth[a] > depth[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}

	}
}
