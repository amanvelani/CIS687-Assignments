public class shiftCipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args){
        String str = "ewljazlnnzmvylylhrmhz";
        System.out.println(str.length());
        for(int i = 1; i <= 26; i++){
            System.out.println("Key: " + i);
            System.out.println("Plaintext: " + decrypt(str, i));
        }
    }

    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int ii = 0; ii < cipherText.length(); ii++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(ii));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            message += replaceVal;
        }
        return message;
    }
}
