import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesApplication {
    String path1 = "model3.csv";
    String path2 = "modelS.csv";
    String path3 = "modelX.CSV";


    List<TeslaPOJO> sales;

    List<TeslaPOJO> carList1 = new ArrayList<>();
    List<TeslaPOJO> carList2 = new ArrayList<>();
    List<TeslaPOJO> carList3 = new ArrayList<>();


    public SalesApplication() {
        this.sales = new ArrayList<>();
    }

    public List<TeslaPOJO> getSales() {
        return this.sales;
    }

    public void readFile(String fileName) throws IOException {
        this.sales.clear();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("Date")) {
                continue;
            }
            String date = line.split(",")[0];
            String sales = line.split(",")[1];

            TeslaPOJO sale = new TeslaPOJO(date, Integer.parseInt(sales));
            this.sales.add(sale);

        }
        reader.close();


    }
}
