import java.util.*;

class Candy {
    private String name;
    private List<String> consist;
    private float sugarToPer;
    private float price;
    private float weight;

    public Candy(String name, List<String> consist, float sugarToPer, float price, float weight) {
        this.name = name;
        this.consist = consist;
        this.sugarToPer = sugarToPer;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConsist() {
        return consist;
    }

    public void setConsist(List<String> consist) {
        this.consist = consist;
    }

    public float getSugarToPer() {
        return sugarToPer;
    }

    public void setSugarToPer(float sugarToPer) {
        this.sugarToPer = sugarToPer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", consist=" + consist +
                ", sugarToPer=" + sugarToPer +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}

class Giftbox {
    private List<Candy> candys = new LinkedList<>();
    private float totalWeight;

    public Giftbox() {
    }

    public void setCandys(List<Candy> candys) {
        this.candys = candys;
    }

    public void setWeight(float weight) {
        this.totalWeight = weight;
    }

    public List<Candy> getCandys() {
        return candys;
    }

    public float getWeight() {
        return totalWeight;
    }

    public void addCandy(Candy candy) {
        this.candys.add(candy);
        this.totalWeight += candy.getWeight();
    }

    public void sortByArgs(String args) {
        if (args.equals("Price")) {
            candys.sort(Comparator.comparing(Candy::getPrice));
        } else if (args.equals("SugarToPer")) {
            candys.sort(Comparator.comparing(Candy::getSugarToPer));
        } else if (args.equals("Weight")) {
            candys.sort(Comparator.comparing(Candy::getWeight));
        }
    }


    @Override
    public String toString() {
        return "Конфеты: " + candys +
                ", общий вес: " + totalWeight +
                " грамм.";
    }
}

public class Main {
    public static void main(String[] args) {
        Giftbox gift = new Giftbox();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Добавить конфету\n2. Посмотреть все конфеты\n3. Отсортировать по цене\n4. Отсортровать по весу\n5. Отсортировать по содержанию сахара\n6. выйти");
            int choice = scanner.nextInt();

            if (choice == 1) {
                String name;
                ArrayList<String> consist = new ArrayList<>();
                float sugarToPer;
                float price;
                float weight;
                System.out.print("Введите название: ");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Введите состав:");
                int number = 1;
                while (true) {
                    System.out.print(number + ". ");
                    String product = scanner.nextLine();
                    if (product.isEmpty()) {
                        break;
                    }
                    consist.add(product);
                    number++;
                }
                System.out.print("Введите содержание сахара в процентах: ");
                sugarToPer = scanner.nextFloat();
                System.out.print("Введите цену: ");
                price = scanner.nextFloat();
                System.out.print("Введите вес: ");
                weight = scanner.nextFloat();
                gift.addCandy(new Candy(name, consist, sugarToPer, price, weight));
                System.out.println("Готово. Вы будете возвращены в главное меню.");
            } else if (choice == 2) {
                System.out.println(gift.toString());
            } else if (choice == 3) {
                gift.sortByArgs("Price");
            } else if (choice == 4) {
                gift.sortByArgs("Weight");
            } else if (choice == 5) {
                gift.sortByArgs("SugarToPer");
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Некорреткный ввод.");
            }

        }
    }
}