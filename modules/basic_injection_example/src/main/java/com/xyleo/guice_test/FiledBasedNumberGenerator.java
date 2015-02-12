package com.xyleo.guice_test;

import java.io.*;

/**
 * Created by J.D. Rosensweig on 2/10/15.
 */
public class FiledBasedNumberGenerator implements NumberGenerator {
    BufferedReader _bufferedReader;

    public FiledBasedNumberGenerator() {
    }

    public NumberGenerator setNumbersFile(File numbersFile)
            throws FileNotFoundException {
        _bufferedReader = new BufferedReader(new FileReader(numbersFile));
        return this;
    }

    @Override
    public int getNumber() throws IOException {
        return Integer.valueOf(_bufferedReader.readLine());
    }

    @Override
    public boolean hasNext(){
        boolean result = false;

        try {
            result = _bufferedReader.ready();
        } catch (IOException e) {
            result = false;
        }

        return result;
    }
}
