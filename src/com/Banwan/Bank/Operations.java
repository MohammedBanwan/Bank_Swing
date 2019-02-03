package com.Banwan.Bank;

import java.util.HashMap;

public class Operations {
	HashMap<Integer, String> Owners = new HashMap<Integer, String>();
	HashMap<Integer, Integer> Balance = new HashMap<Integer, Integer>();
	
	void fillData() {
		Owners.put(111111, "Mohammed");
		Owners.put(222222, "Bilal");
		Owners.put(333333, "Noor");
		Owners.put(444444, "Ali");
		Balance.put(111111, 10000000);
		Balance.put(222222, 20000000);
		Balance.put(333333, 30000000);
		Balance.put(444444, 40000000);
	}
	
}
