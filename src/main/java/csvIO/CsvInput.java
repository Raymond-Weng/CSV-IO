package csvIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvInput {
    private final File file;

    /**
     * create a object to input the file
     *
     * @param file the file to be read
     */
    public CsvInput(File file) {
        this.file = file;
    }

    /**
     * read the file
     *
     * @return the result of reading file, the format is [column][row]
     * @throws IOException if something wrong in reading file, this will be thrown
     */
    public String[][] read() throws IOException {
        //check the file is readable
        if (!file.canRead()) {
            throw new IOException();
        }

        //read the whole file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string = "";
        while (bufferedReader.ready()) {
            string = string + bufferedReader.readLine();
            if (bufferedReader.ready()) {
                string = string + "\n";
            }
        }

        //try split the long text in to an array
        String[] rows = string.split("\n");
        String[][] result = new String[rows[0].split(",").length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            String[] items = rows[i].split(",");
            for (int r = 0; r < items.length; r++) {
                result[r][i] = items[r];
            }
        }

        //close the IO object
        bufferedReader.close();

        //return the result
        return result;
    }
}
