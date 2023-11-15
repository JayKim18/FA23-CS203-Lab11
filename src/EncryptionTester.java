
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
        String encryptedFilePath = "src/encrypted.txt";
        String decryptedFilePath = "src/decrypted.txt";
        String inputFilePath = "src/encryptMe.txt";
        String outputFilePath = "src/newEncrypted.txt";
		
        int shift = 1; // Says how much you would like to shift
	try{
		Encrypter encrypter = new Encrypter(shift);

		encrypter.encrypter(inputFilePath, outputFilePath);

		encrypter.decrypt(encryptedFilePath, decryptedFilePath);

		System.out.println("Encryption and Decryption completed successfully.");
	} catch (Exception e){
		System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
	}
}
