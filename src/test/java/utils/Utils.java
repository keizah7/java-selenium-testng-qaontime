package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String randomText(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static int randomInt(int min, int max) {
		Random r = new Random();

		return r.nextInt((max - min) + 1) + min;
	}
}
