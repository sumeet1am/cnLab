import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RSA {
    BigInteger p, q, n, phi, e, d;
    int bitLen = 1024;
    Random r = new Random();

    RSA() {
        p = BigInteger.probablePrime(bitLen, r);
        q = BigInteger.probablePrime(bitLen, r);

        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitLen / 2, r);
        while (!phi.gcd(e).equals(BigInteger.ONE))
            e = e.add(BigInteger.ONE);

        d = e.modInverse(phi);

        System.out.println("Public key is " + e);
        System.out.println("Private key is " + d);
    }

    byte[] encrypt(byte[] msg) {
        return new BigInteger(msg).modPow(e, n).toByteArray();
    }

    byte[] decrypt(byte[] msg) {
        return new BigInteger(msg).modPow(d, n).toByteArray();
    }

    static String bytesToString(byte[] b) {
        String s = "";
        for (byte x : b) s += x;
        return s;
    }

    public static void main(String[] args) throws Exception {
        RSA rsa = new RSA();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the plain text: ");
        String msg = br.readLine();

        System.out.println("Encrypting string: " + msg);
        System.out.println("Plain text bytes: " +
                bytesToString(msg.getBytes()));

        byte[] enc = rsa.encrypt(msg.getBytes());
        System.out.println("Encrypted Bytes: " +
                bytesToString(enc));

        byte[] dec = rsa.decrypt(enc);
        System.out.println("Decrypting Bytes: " +
                bytesToString(dec));

        System.out.println("Decrypted string: " +
                new String(dec, StandardCharsets.UTF_8));
    }
}
