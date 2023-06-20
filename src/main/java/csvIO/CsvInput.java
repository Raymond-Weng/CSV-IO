package csvIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvInput {
    File file;

    public CsvInput(File file) {
        this.file = file;
    }

    public String[][] read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string = "";
        while (bufferedReader.ready()) {
            string = string + bufferedReader.readLine();
            if (bufferedReader.ready()) {
                string = string + "\n";
            }
        }

        String[] strings = string.split("\n");
        String[][] result = new String[strings[0].split(",").length][strings.length];
        for (int i = 0; i < strings.length; i++) {
            String[] tempString = strings[i].split(",");
            for (int r = 0; r < tempString.length; r++) {
                result[r][i] = tempString[r];
            }
        }

        return result;
    }
}
