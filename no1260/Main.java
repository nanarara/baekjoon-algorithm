package com.no1260_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;
	static int V;
	static int[][] arr;
	static boolean[] isVisited;

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]); // 정점수
			M = Integer.parseInt(str[1]); // 간선수
			V = Integer.parseInt(str[2]); // 시작점
			arr = new int[N + 1][N + 1];
			isVisited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				String[] temp = br.readLine().split(" ");
				int temp1 = Integer.parseInt(temp[0]);
				int temp2 = Integer.parseInt(temp[1]);
				arr[temp1][temp2] = 1;
				arr[temp2][temp1] = 1;
			}

			dfs(V);

			initVisited();
			System.out.println();

			bfs(V);

			br.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i < N + 1; i++) {
			if (arr[v][i] == 1 && !isVisited[i]) {
				dfs(i);
			}
		}
	}

	static void initVisited() {
		for (int i = 1; i < N + 1; i++) {
			isVisited[i] = false;
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(v);
		isVisited[v] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			for (int i = 1; i < N + 1; i++) {
				if (arr[temp][i] == 1 && !isVisited[i]) {
					queue.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}

}
