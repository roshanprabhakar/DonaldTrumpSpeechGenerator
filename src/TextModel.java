import java.util.ArrayList;
import java.util.HashMap;

public class TextModel {
    private HashMap<String, ArrayList<String>> map;

    public TextModel(Formatter formatter) {
        map = new HashMap<>();
        loadData(formatter.getText());
    }

    public void loadData(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(words[i + 1]);
        }
    }

    public String simulateNewWord(String startWord) {
        return map.get(startWord).get((int)(Math.random() * map.get(startWord).size()));
    }
}
