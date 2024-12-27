import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

class Bus {
    private String driver;
    private int numBus;
    private int numRoute;
    private String brand;
    private LocalDate startExploit;
    private float mileage;

    Bus() {
    }

    Bus(String driver, int numBus, int numRoute, String brand, LocalDate startExploit, float mileage) {
        this.driver = driver;
        this.numBus = numBus;
        this.numRoute = numRoute;
        this.startExploit = startExploit;
        this.mileage = mileage;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getNumBus() {
        return numBus;
    }

    public void setNumBus(int numBus) {
        this.numBus = numBus;
    }

    public int getNumRoute() {
        return numRoute;
    }

    public void setNumRoute(int numRoute) {
        this.numRoute = numRoute;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getStartExploit() {
        return startExploit;
    }

    public void setStartExploit(LocalDate startExploit) {
        this.startExploit = startExploit;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "ФИО водителя='" + driver + '\'' +
                ", номер автобуса=" + numBus +
                ", номер маршрута=" + numRoute +
                ", марка='" + brand + '\'' +
                ", начало эксплуатации=" + startExploit +
                ", пробег=" + mileage +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Bus> arr = new ArrayList<>(
                Arrays.asList(
                        new Bus("Ромашкан Данил Алексеевич", 1, 12, "Мазда", LocalDate.parse("2024-12-01"), 8432),
                        new Bus("Авагян Давид Грагатович", 2, 8, "Мерседес", LocalDate.of(2024,11,1), 13423),
                        new Bus("Данюшис Максим Витальевич", 3, 12, "Мерседес", LocalDate.parse("2024-11-15"), 9432)
                ));

        System.out.println("Список автобусов с одинаковым маршрутом:\n" + getByNumRoute(arr, 12));
        System.out.println("Список автобусов, которые эскплуатируются дольше указаного срока:\n" + getByStartExploit(arr, "2024-11-21"));
        System.out.println("Список автобусов, пробег которых больше указаного:\n" + getByMileage(arr, 9000));
    }

    public static ArrayList<String> getByNumRoute(ArrayList<Bus> arr, int numRoute) {
        ArrayList<String> result = new ArrayList<>();
        for(Bus i : arr) {
           if(i.getNumRoute() == numRoute) {
               result.add(i.toString());
           }
        }
        return result;
    }

    public static ArrayList<String> getByStartExploit(ArrayList<Bus> arr, String date) {
        ArrayList<String> result = new ArrayList<>();
        LocalDate dateStart = LocalDate.parse(date);
        for(Bus i : arr) {
            if(i.getStartExploit().isAfter(dateStart)) {
                result.add(i.toString());
            }
        }
        return result;
    }

    public static ArrayList<String> getByMileage(ArrayList<Bus> arr, float mileage) {
        ArrayList<String> result = new ArrayList<>();
        for(Bus i : arr) {
            if(i.getMileage() > mileage) {
                result.add(i.toString());
            }
        }
        return result;
    }
}