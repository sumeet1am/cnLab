import java.util.Scanner;

public class CRC {

    private static final int POLYNOMIAL = 0x1021;

    // Function to calculate CRC-CCITT
    public static String crcCCITT(String data) {
        int crc = 0xFFFF;

        for (char ch : data.toCharArray()) {
            crc ^= (ch << 8);
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc = crc << 1;
                }
                crc &= 0xFFFF; // Keep CRC 16-bit
            }
        }
        return String.format("%04X", crc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sender data: ");
        String inputData = sc.nextLine().trim();

        String crc = crcCCITT(inputData);
        String transmittedData = inputData + crc;

        System.out.println("Transmitting data with CRC: " + transmittedData);

        System.out.print("Enter the received data (message + CRC): ");
        String receivedData = sc.nextLine().trim();

        String receivedMessage = receivedData.substring(0, receivedData.length() - 4);
        String receivedCRC = receivedData.substring(receivedData.length() - 4);

        String calculatedCRC = crcCCITT(receivedMessage);

        if (calculatedCRC.equals(receivedCRC)) {
            System.out.println("Data is intact.");
            System.out.println("Received Message: " + receivedMessage);
        } else {
            System.out.println("Data is corrupted. Message discarded.");
        }

        sc.close();
    }
}
