package ch01_network;

import java.net.InetAddress;

public class Test_InetAddress {
	public static void main(String[] args) {
		try {
			InetAddress ias[] = InetAddress.getAllByName(args[0]);
			
			for (int i = 0; i < ias.length; i++) {
				System.out.println(ias[i].getHostName());
				System.out.println(ias[i].getHostAddress());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
