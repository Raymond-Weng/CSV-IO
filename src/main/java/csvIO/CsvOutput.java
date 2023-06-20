package csvIO;

import java.io.*;

public class CsvOutput {
    public CsvOutput(File file, String[][] table) throws IOException {
        String string = "";
        for (int i = 0; i < table.length; i++){
            for(int r = 0; r < table[0].length; r++){
                string = string + table[i][r];
                if(r + 1 != table[0].length){
                    string = string + ",";
                }
            }
            if(i + 1 != table.length){
                string = string + "\n";
            }
        }


//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

    }
}
