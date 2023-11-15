import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
        String message = readFile(inputFilePath);
        this.encrypted = encryptText(message, shift);
        writeFile(this.encrypted, encrpytedFilePath);
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
        String encryptedMessage = readFile(messageFilePath);
        this.encrypted = decryptText(encryptedMessage, shift);
        writeFile(this.encrypted, decryptedFilePath);
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))){
            While (scanner.hasNextLine()){
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (IOEception e){
            throw new IOException("Error reading the file", e);
        }
        //TODO: Read file from filePath
        return content.toString();
    }

    private static String encryptText(String text, int shift){
        StringBuilder encryptedText = new StringBuilder();
        for (char ch: text.toCharArray()){
            if (Character.isLetter(ch)){
                char base = (Character.isUpperCase(ch)) ? 'A' : 'a';
                encryptedText.append((char) ((ch - base + shift) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    private static String decryptText(String text, int shift){
        return encryptText(text, 26 - shift);
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) throws IOException {
        //TODO: Write to filePath
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(data);
        } catch (IOException e){
            throw new IOException("Error writing to the file", e);
        }
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
