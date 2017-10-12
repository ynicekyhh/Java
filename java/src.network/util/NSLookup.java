package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String host = null;

		try {
			while (true) {
				System.out.print(">");

				host = scanner.nextLine();

				if("exit".equals(host)) {
					break;
				}

				InetAddress[] inetAddresses;

				inetAddresses = InetAddress.getAllByName(host);

				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(inetAddress.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
