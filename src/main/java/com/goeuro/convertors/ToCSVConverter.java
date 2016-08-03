package com.goeuro.convertors;


import com.goeuro.entities.GoEuroData;
import com.goeuro.exceptions.CSVException;

import java.io.*;
import java.util.List;

public class ToCSVConverter {
    private static final String SEPARATOR = ",";
    private static final String CSV_FILE = "output.csv";
    private static final String ENCODING = "UTF-8";

    public static void writeToCSV(List<GoEuroData> list) throws CSVException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(CSV_FILE), ENCODING))) {
            for (GoEuroData item : list) {
                convertLine(bw, item);
            }
            bw.flush();
        } catch (IOException e) {
            throw new CSVException(e);
        }
    }

    private static void convertLine(BufferedWriter bw, GoEuroData item) throws CSVException {
        StringBuffer oneLine = new StringBuffer();
        appendData(item, oneLine);
        try {
            bw.write(oneLine.toString());
            bw.newLine();
        } catch (IOException e) {
            throw new CSVException(e);
        }
    }

    private static void appendData(GoEuroData item, StringBuffer oneLine) {
        oneLine.append(item.get_id());
        oneLine.append(SEPARATOR);
        oneLine.append(item.getName());
        oneLine.append(SEPARATOR);
        oneLine.append(item.getType());
        oneLine.append(SEPARATOR);
        oneLine.append(item.getGeo_position().getLatitude());
        oneLine.append(SEPARATOR);
        oneLine.append(item.getGeo_position().getLongitude());
    }
}
