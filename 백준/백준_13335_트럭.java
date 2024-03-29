import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_13335_트럭 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList();

		int N = sc.nextInt();
		int W = sc.nextInt();
		int L = sc.nextInt(); 

		int time = 0;
		int weight = 0;
		int[] truck = new int[N]; 

		for (int i = 0; i < N; i++) {
			truck[i] = sc.nextInt();
		} 

		for (int i = 0; i < N; i++) { 
			while (true) {
				if (queue.isEmpty()) {// 다리에 아무것도 없으면
					queue.offer(truck[i]);
					time++; 
					weight += truck[i]; 
					break;

				} else if (queue.size() == W) {// 큐의 사이즈가 다리의 길이이면
					weight -= queue.remove();
					
				} else { //다리에 트럭이 있을 때
					if (weight + truck[i]> L) { //현재 트럭의 무게 + 다리에 있는 트럭의 무게가 최대 하중보다 크다면
						queue.offer(0);
						time++;
					
					} else { //최대하중보다 작다면
						queue.offer(truck[i]);
						time++;
						weight += truck[i];
						break ;

					}
				}
			}
		}
		System.out.println(time+W);

	}// end of main

}
