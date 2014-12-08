package de.whs.drunkenjukebox.player;

import org.jboss.crypto.CryptoUtil;



public class HashPassword {
	public static void main(String[] args) {
		String hashedPassword = CryptoUtil.createPasswordHash("SHA-1", CryptoUtil.BASE64_ENCODING, null, "otto", "geheim");
		System.out.println(hashedPassword);
	}
}
