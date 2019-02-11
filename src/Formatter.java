import java.io.*;
import java.util.ArrayList;

public class Formatter {
    private String text;

    public Formatter(String filepath) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            sb.append(line);
            sb.append(' ');
        }

        text = sb.toString();

        //INIT COMMAND GROUP
        punctuate();
        formatSpaces();
    }

    private void punctuate() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
                out.append(' ');
            }
            out.append(text.charAt(i));
        }
        text = out.toString();
    }

    private void formatSpaces() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != ' ') {
                out.append(text.charAt(i));
            } else if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') {
                out.append(text.charAt(i));
            } else {
                continue;
            }
        }
        text = out.toString();
    }

    //API
    public String getText() {
        return this.text;
    }
}
