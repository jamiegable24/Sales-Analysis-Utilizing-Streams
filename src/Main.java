import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        SalesApplication saleService = new SalesApplication();
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("---------------------------");

        saleService.readFile("model3.csv");
        List<TeslaPOJO> salesForModel3 = saleService.getSales();
        printSales(salesForModel3);
        getBestMonth(salesForModel3);
        getWorstMonth(salesForModel3);

        System.out.println(" ");
        System.out.println("Model S Yearly Sales Report");
        System.out.println("---------------------------");
        saleService.readFile("modelS.csv");
        List<TeslaPOJO> salesForModelS = saleService.getSales();
        printSales(salesForModelS);
        getBestMonth(salesForModelS);
        getWorstMonth(salesForModelS);


        System.out.println(" ");
        System.out.println("Model X Yearly Sales Report");
        System.out.println("---------------------------");
        saleService.readFile("modelX.csv");
        List<TeslaPOJO> salesForModelX = saleService.getSales();
        printSales(salesForModelX);
        getBestMonth(salesForModelX);
        getWorstMonth(salesForModelX);


    }

    private static void getWorstMonth(List<TeslaPOJO> sales) {


        Optional<TeslaPOJO> worstMonth = sales.stream()

                .min(Comparator.comparing(TeslaPOJO::getSales));

        worstMonth.ifPresent(report ->

        {
            System.out.println("The worst month for sales was: " +
                    report.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        });
    }

    public static void getBestMonth(List<TeslaPOJO> bMonth) {
        Optional<TeslaPOJO> bestMonth = bMonth
                .stream()
                .max(Comparator.comparing(TeslaPOJO::getSales));

        bestMonth.ifPresent(report -> {
            System.out.println("The best month for sales was: " +
                    report.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        });
    }


    public static void printSales(List<TeslaPOJO> list) {

        Map<Integer, Integer> salesforModel3ReportMap = list.stream()
                .distinct()
                .collect(Collectors.groupingBy(item -> item.getDate().getYear(), Collectors.summingInt(TeslaPOJO::getSales)));

        salesforModel3ReportMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

}