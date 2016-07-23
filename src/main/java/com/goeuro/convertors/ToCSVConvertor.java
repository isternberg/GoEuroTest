package com.goeuro.convertors;


import com.goeuro.entities.GoEuroData;

import java.io.*;
import java.util.List;

public class ToCSVConvertor {
    private static final String SEPARATOR = ",";
    public static void writeToCSV(List<GoEuroData> list)
    {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("output.csv"), "UTF-8")))
        {
            list.forEach(item->convertLine(bw,item));
            bw.flush();
        }
        catch (UnsupportedEncodingException | FileNotFoundException e) {}
        catch (IOException e){}
    }

    private static void convertLine(BufferedWriter bw, GoEuroData item){
        StringBuffer oneLine = new StringBuffer();
        appendData(item, oneLine);
        try {
            bw.write(oneLine.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
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
