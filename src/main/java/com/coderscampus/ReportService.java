package com.coderscampus;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReportService {

    String[] files = {"src/main/resources/model3.csv", "src/main/resources/modelS.csv", "src/main/resources/modelX.csv"};
    FileService service;

    public ReportService() {
        this.service = new FileService();
    }

    public void show() throws IOException {
        if (files == null || files.length == 0) {
            System.out.println("Error. Please Resubmit File.");
            return;
        }


        for (String filename : this.files) {
            List<Sales> model = this.service.read(filename);


            Map<Integer, Integer> yearlySales = model.stream().collect(
                    Collectors.groupingBy(sale -> sale.getDate().getYear(), Collectors.summingInt(Sales::getSales)));


            System.out.println(getModelName(filename) + " Annual Sales Report");
            System.out.println("---------------------------");
            yearlySales.forEach((year, totalSales) -> System.out.println(year + " -> " + totalSales));
            System.out.println();

            System.out.println("The best month for " + getModelName(filename) + " was: " +
                    model.stream()
                         .max(Comparator.comparingInt(Sales::getSales))
                         .orElse(null)
                         .getDate());
            System.out.println("The worst month for " + getModelName(filename) + " was: " +
                     Objects.requireNonNull(model.stream()
                            .min(Comparator.comparingInt(Sales::getSales))
                            .orElse(null))
                            .getDate());
            System.out.println();
        }
    }

        //for formatting purposes
    private String getModelName(String filename) {
        return filename.substring(filename.lastIndexOf("/") + 1).replace(".csv", "");
    }
}

