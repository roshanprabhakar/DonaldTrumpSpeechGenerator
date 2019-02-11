public class SpeechGenerator {

    private TextModel model;

    public SpeechGenerator(TextModel model) {
        this.model = model;
    }

    public String generateSpeech(String start, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        sb.append(' ');
        String next;
        int wordCount = 0;
        for (int i = 0; i < length; i++) {
            next = model.simulateNewWord(start);
            start = next;
            sb.append(next);
            sb.append(' ');
            wordCount++;
            if (wordCount >= 20) {
                sb.append("\n");
                wordCount -= 20;
            }
        }
        return sb.toString();
    }
}
