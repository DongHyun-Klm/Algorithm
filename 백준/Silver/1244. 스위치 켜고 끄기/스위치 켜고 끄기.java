import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), number;
		boolean[] swit = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (sc.nextInt() == 1)
				swit[i] = true;
			else
				swit[i] = false;
		}
	
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			switch (sc.nextInt()) {
			case 1:
				number = sc.nextInt();
				for (int j = 1; j * number - 1 < swit.length; j++) {
					swit[j * number - 1] = !swit[j * number - 1];
				}
				break;
			case 2:
				number = sc.nextInt() - 1;
				swit[number] = !swit[number];
				if (number == swit.length - 1 || number == 0)
					break;
				int hand = 1;
				while (true) {
					if (swit[number - hand] == swit[number + hand]) {
						swit[number - hand] = !swit[number - hand];
						swit[number + hand] = !swit[number + hand];
					} else
						break;
					if (number + hand == swit.length - 1 || number - hand == 0)
						break;
					hand++;
				}
				break;
			}

		}

		for (int j = 0; j < swit.length; j++) {
		    if (swit[j] == true)
		        System.out.print("1 ");
		    else
		        System.out.print("0 ");
		    if ((j + 1) % 20 == 0)
		        System.out.println();
		}

	}
}
