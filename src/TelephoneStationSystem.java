import java.util.ArrayList;
import java.util.List;

class Subscriber {
  private String name;
  private String phoneNumber;
  private double accountBalance;
  private boolean active;

  public Subscriber(String name, String phoneNumber, double accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.accountBalance = accountBalance;
    this.active = true;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public double getAccountBalance() {
    return accountBalance;
  }

  public boolean isActive() {
    return active;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void payBill(double amount) {
    accountBalance += amount;
    System.out.println(name + " оплатил " + amount + ". Новый баланс: " + accountBalance);
  }

  public void requestChangeNumber(String newNumber, Administrator admin) {
    System.out.println(name + " запрашивает изменение номера на " + newNumber);
    admin.changePhoneNumber(this, newNumber);
  }

  public void requestServiceCancellation(Administrator admin) {
    System.out.println(name + " запрашивает отключение услуг.");
    admin.disableSubscriber(this);
  }

  @Override
  public String toString() {
    return "Subscriber{" +
            "name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", accountBalance=" + accountBalance +
            ", active=" + active +
            '}';
  }
}

class Administrator {
  private String name;

  public Administrator(String name) {
    this.name = name;
  }

  public void changePhoneNumber(Subscriber subscriber, String newNumber) {
    System.out.println("Администратор " + name + " меняет номер абонента " + subscriber.getName());
    subscriber.setPhoneNumber(newNumber);
  }

  public void disableSubscriber(Subscriber subscriber) {
    System.out.println("Администратор " + name + " отключает абонента " + subscriber.getName());
    subscriber.setActive(false);
  }

  public void modifyServices(Subscriber subscriber, String serviceDetails) {
    System.out.println("Администратор " + name + " изменяет услуги для " + subscriber.getName() + ": " + serviceDetails);
  }
}

public class TelephoneStationSystem {
  private List<Subscriber> subscribers;
  private Administrator administrator;

  public TelephoneStationSystem(Administrator admin) {
    this.administrator = admin;
    subscribers = new ArrayList<>();
  }

  public void addSubscriber(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void printSubscribers() {
    for (Subscriber s : subscribers) {
      System.out.println(s);
    }
  }

  public static void main(String[] args) {
    Administrator admin = new Administrator("Иванов");
    TelephoneStationSystem system = new TelephoneStationSystem(admin);

    Subscriber sub1 = new Subscriber("Alice", "123-456", 50.0);
    Subscriber sub2 = new Subscriber("Bob", "234-567", 30.0);

    system.addSubscriber(sub1);
    system.addSubscriber(sub2);

    System.out.println("Начальное состояние абонентов:");
    system.printSubscribers();

    sub1.payBill(20.0);

    sub2.requestChangeNumber("345-678", admin);

    sub2.requestServiceCancellation(admin);

    System.out.println("\nСостояние абонентов после операций:");
    system.printSubscribers();
  }
}
