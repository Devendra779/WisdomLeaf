import java.util.Scanner;

public class SpeakingClock {

	public static void main(String[] args) {

		int h, m;
		Scanner sc = new Scanner(System.in);

		String time = sc.next();
		// splitting the string in parts when we encounter ":" in the string
		String tArr[] = time.split(":");

		h = Integer.parseInt(tArr[0]);
		m = Integer.parseInt(tArr[1]);

		if ((h >= 0 && h <= 24) && (m >= 0 && m <= 59)) {

			String specialWords[] = { "midday", "midnight" };
			if (h == 12 && m == 0) {
				System.out.println("its " + specialWords[0]);
			} else if ((h == 12) && (m >= 1 && m <= 59)) {
				System.out.println("its " + specialWords[0]+ " " + numToWords(m)+" "+ "minutes");
			} 
			else if ((h == 0) && m==0) {
				System.out.println("its " + specialWords[1]);
			} 
			else if ((h == 0) && (m >= 1 && m <= 59)) {
				System.out.println("its " + specialWords[1]+ " " + numToWords(m)+" "+ "minutes");
			} 
			else if (h != 12 && m == 0) {
				System.out.println("its " + numToWords(h) + " O' clock");
			} else {

				System.out.println("its " + numToWords(h) + " " + numToWords(m));

			}

		}

		else
			System.out.println("Invalid Input !");
	}

	static String numToWords(int n) {
		int n1 = n, n2 = n;
		int b = n1 % 10, a = n2 / 10;

		String result = "";

		String[] single_digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight","nine" };
		String[] two_digits = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens_multiple = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy","eighty", "ninety" };
		if (a == 1) {
			result = two_digits[b + 1];
		} else if (b == 0)
			result = tens_multiple[a];
		else
			result = tens_multiple[a] + " " + single_digits[b];

		return result;
	}
}
