import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TeslaPOJO {
    private YearMonth date;

    private Integer sales;

    public TeslaPOJO (String date, Integer sales) {
        YearMonth dates = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
        this.date = dates;
        this.sales = sales;
    }

    public YearMonth getDate() {
        return date;
    }
    public void setDate(YearMonth date) {
        this.date = date;
    }
    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Report [date=" + date + ", sales=" + sales + "]";
    }

}
