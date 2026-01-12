import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordRepository {

    private static final Set<String> wordSet = new HashSet<>();

    // 정적 초기화 블록 - 클래스가 처음 로드될 때 자동 실행
    static {
        loadWords("src/main/resources/words.txt");
    }

    // 파일에서 단어 로드 (private static)
    private static void loadWords(String fileName) {
        System.out.println("WordRepository 초기화 중...");

        try (BufferedReader reader = new BufferedReader(
            new FileReader(fileName, StandardCharsets.UTF_8))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();  // 소문자로 통일

                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("파일 로드 실패: " + e.getMessage());
            throw new ExceptionInInitializerError("WordRepository 초기화 실패: " + e.getMessage());
        }
    }

    public static boolean hasWord(String word) {
        return wordSet.contains(word);
    }
}
