package com.coderscampus;

import java.io.IOException;

public class SalesReportGenerator {

    public static void main(String[] args) {


        ReportService service = new ReportService();
        try {
            service.show();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}