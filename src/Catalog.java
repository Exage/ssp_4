import java.util.ArrayList;
import java.util.List;

public class Catalog {

  public class LendingRecord {
    private String bookTitle;
    private String readerName;
    private String lendingDate;

    public LendingRecord(String bookTitle, String readerName, String lendingDate) {
      this.bookTitle = bookTitle;
      this.readerName = readerName;
      this.lendingDate = lendingDate;
    }

    public String getBookTitle() {
      return bookTitle;
    }

    public String getReaderName() {
      return readerName;
    }

    public String getLendingDate() {
      return lendingDate;
    }

    @Override
    public String toString() {
      return "LendingRecord{" +
              "bookTitle='" + bookTitle + '\'' +
              ", readerName='" + readerName + '\'' +
              ", lendingDate='" + lendingDate + '\'' +
              '}';
    }
  }

  private List<LendingRecord> records;

  public Catalog() {
    records = new ArrayList<>();
  }

  public void addRecord(String bookTitle, String readerName, String lendingDate) {
    LendingRecord record = new LendingRecord(bookTitle, readerName, lendingDate);
    records.add(record);
  }

  public void printRecords() {
    if (records.isEmpty()) {
      System.out.println("Нет записей о выдаче книг.");
      return;
    }
    for (LendingRecord record : records) {
      System.out.println(record);
    }
  }

  public List<LendingRecord> findRecordsByReader(String readerName) {
    List<LendingRecord> result = new ArrayList<>();
    for (LendingRecord record : records) {
      if (record.getReaderName().equalsIgnoreCase(readerName)) {
        result.add(record);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Catalog catalog = new Catalog();

    catalog.addRecord("Война и мир", "Иванов И.И.", "2024-02-20");
    catalog.addRecord("Преступление и наказание", "Петров П.П.", "2024-02-21");
    catalog.addRecord("Мастер и Маргарита", "Иванов И.И.", "2024-02-22");

    System.out.println("Все записи каталога:");
    catalog.printRecords();

    System.out.println("\nЗаписи для читателя 'Иванов И.И.':");
    List<Catalog.LendingRecord> records = catalog.findRecordsByReader("Иванов И.И.");
    for (Catalog.LendingRecord rec : records) {
      System.out.println(rec);
    }
  }
}
