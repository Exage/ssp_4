import java.util.ArrayList;
import java.util.List;

class Word {
  private String text;

  public Word(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }
}

public class Page {
  private List<Word> words;

  public Page() {
    words = new ArrayList<>();
  }

  public void addWord(Word word) {
    words.add(word);
  }

  public void removeWord(Word word) {
    words.remove(word);
  }

  public void printPage() {
    for (Word word : words) {
      System.out.print(word.getText() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Page page = new Page();
    page.addWord(new Word("Это"));
    page.addWord(new Word("пример"));
    page.addWord(new Word("агрегации."));
    page.printPage();
  }
}
