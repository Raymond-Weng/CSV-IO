package csvIO;

import java.io.File;
import java.io.IOException;

public class CsvEdit {
    private final File file;

    /**
     * create the object to edit the file
     *
     * @param file the file to be edited
     */
    public CsvEdit(File file) {
        this.file = file;
    }

    /**
     * edit the file
     *
     * @param newString the new string to replace the item
     * @param row       the row of the item, count from 0
     * @param column    the column, count from 0
     * @throws IOException this will be thrown if something in file IO is wrong
     */
    public void edit(String newString, int row, int column) throws IOException {
        //read
        String table[][] = new CsvInput(file).read();

        //edit
        table[column][row] = newString;

        //write
        new CsvOutput(file).write(table);
    }
}
