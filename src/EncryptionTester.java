
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
        String encryptedFilePath = "src/encrypted.txt";
        String decryptedFilePath = "src/decrypted.txt";
        String inputFilePath = "src/encryptMe.txt";
        String outputFilePath = "src/newEncrypted.txt";
		
        int shift = 1; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

	try{
		enc.encrypt(inputFilePath, outputFilePath);
		System.out.println("Encryption complete. Encrypted text: " + enc);

		Encrypter dec = new Encrypter(shift);
		dec.decrypt(encryptedFilePath, decryptedFilePath);
		System.out.println("Decryption complete. Decrypted text: " + dec);

	} catch (Exception e){
		e.printStackTrace();
	}
	}


}
