package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileService {

    public List<Sales> read(String filename) throws IOException {
        List<Sales> data = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");


                YearMonth date = YearMonth.parse(row[0], formatter);
                int sales = Integer.parseInt(row[1]);

                data.add(new Sales(date, sales));
            }
        }

        return data;
    }
}