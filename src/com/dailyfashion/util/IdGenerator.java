package com.dailyfashion.util;

public class IdGenerator {
	public static String generateItemId() {
		return "ITM" + System.currentTimeMillis();
	}
}
