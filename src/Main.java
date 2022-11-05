import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        System.out.println("1.Decipher 2.Encrypt");
        int algorithm = scan.nextInt();
        System.out.println("Enter messages in capital letters only and no spaces:");
        String encrypt = in.nextLine();
        System.out.println("Enter keyword:");
        String key = in.nextLine();
        int saveindexes = 0;
        int messageindex = 0;
        Boolean checkmess = false;
        Boolean checkkey = false;
        String result = "";
        int scorekey = 0;
        int keyindex = 0;
        if (algorithm == 2) {
            for (int i = 0; i < encrypt.length(); i++) {
                if (scorekey == key.length()) {
                    scorekey = 0;
                }
                for (int w = 0; w < alphabet.length; w++) {
                    if (alphabet[w] == encrypt.charAt(i)) {
                        messageindex = w;
                        checkmess = true;
                    }
                    if (alphabet[w] == key.charAt(scorekey)) {
                        keyindex = w;
                        checkkey = true;
                    }
                    if (checkmess && checkkey) {
                        checkmess = false;
                        checkkey = false;
                        if ((messageindex + keyindex) < 26) {
                            saveindexes = messageindex + keyindex;
                        }
                        if ((messageindex + keyindex) > 25) {
                            saveindexes = (messageindex + keyindex) - 26;
                        }
                        break;
                    }
                }
                result = result + alphabet[saveindexes];
                saveindexes = 0;
                scorekey++;
            }
            System.out.println("Text:" + result);
        }
        if (algorithm == 1) {
            for (int i = 0; i < encrypt.length(); ++i) {
                if (scorekey == key.length()) {
                    scorekey = 0;
                }
                for (int w = 0; w < alphabet.length; ++w) {
                    if (alphabet[w] == encrypt.charAt(i)) {
                        messageindex = w;
                        checkmess = true;
                    }
                    if (alphabet[w] == key.charAt(scorekey)) {
                        keyindex = w;
                        checkkey = true;
                    }
                    if (checkmess && checkkey) {
                        if ((messageindex - keyindex) >= 0) {
                            saveindexes = messageindex - keyindex;
                        }
                        if ((messageindex - keyindex) < 0) {
                            saveindexes = messageindex + 26 - keyindex;
                        }
                        checkmess = false;
                        checkkey = false;
                        break;
                    }
                }
                result = result + alphabet[saveindexes];
                saveindexes = 0;
                ++scorekey;
            }
            System.out.println("Ciphertext:" + result);
        }
    }
}