package csvIO;

import com.sun.istack.internal.NotNull;

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
     * @param column    the column of the item, count from 0
     * @throws IOException this will be thrown if something in file IO is wrong
     */
    public void edit(String newString, int row, int column) throws IOException {
        //read
        String[][] table = new CsvInput(file).read();

        //edit
        table[column][row] = newString;

        //write
        new CsvOutput(file).write(table);
    }

    public void compareToEdit(@NotNull String[][] newTable) throws IOException {
        //read
        String[][] table = new CsvInput(file).read();

        //check the size
        if(newTable.length != table.length || newTable[0].length != table[0].length){
            throw new RuntimeException("The sizes of two array are not same.");
        }

        //compare and edit
        for (int i = 0; i < table.length; i++){
            for(int r = 0; r < table.length; r++){
                if(!newTable[i][r].equals(table[i][r])){
                    this.edit(newTable[i][r], r, i);
                }
            }
        }
    }
}
