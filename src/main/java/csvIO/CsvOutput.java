package csvIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvOutput {
    private final File file;

    /**
     * create the object to write the file
     *
     * @param file the will to be written
     */
    public CsvOutput(File file) {
        this.file = file;
    }

    /**
     * REPLACE the file
     *
     * @param table the things to be written into the file, the format is [column][row]
     * @throws IOException if something wrong when writing the file, this will be thrown
     */
    public void write(String[][] table) throws IOException {
        //change the array into the format of csv file
        String string = "";
        for (int i = 0; i < table.length; i++) {
            for (int r = 0; r < table[0].length; r++) {
                string = string + table[r][i];
                if (r + 1 != table[0].length) {
                    string = string + ",";
                }
            }
            if (i + 1 != table.length) {
                string = string + "\n";
            }
        }

        //write the string in to the file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(string);

        //close the IO object
        bufferedWriter.close();
    }
}
