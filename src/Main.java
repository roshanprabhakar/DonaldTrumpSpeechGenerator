public class Main {

    public static final String start = "Hello";

    public static void main(String[] args) {
        SpeechGenerator speech = new SpeechGenerator(new TextModel(new Formatter("AllSpeeches.txt")));
        System.out.println(speech.generateSpeech("Thank", 100));
    }
}
