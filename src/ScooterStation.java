import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScooterStation {
    private List<Scooter> scooters;
    private int succeededRents;
    private int failedRents;

    public ScooterStation(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    @SuppressWarnings("unused")
    public void addScooter(Scooter scooter) {
        scooters.add(scooter);
    }

    @SuppressWarnings("unused")
    public void removeScooter(Scooter scooter) {
        scooters.remove(scooter);
    }

    @SuppressWarnings("UnusedReturnValue")
    public int rentScooter(int requiredBattery) {
        scooters.sort(Comparator.comparingInt(Scooter::getBattery));
        for (Scooter scooter : scooters) {
            if (scooter.getBattery() >= requiredBattery) {
                scooter.setRented(true);
                System.out.println("Scooter mit der ID " + scooter.getId() + " wurde erfolgreich vermietet.");
                succeededRents++;
                return scooter.getId();
            }
        }
        System.out.print("Es gibt keinen Scooter mit ausreichendem Akku");
        System.out.println(" oder alle passenden Scooter sind bereits verliehen. " + -1);
        failedRents++;
        return -1;
    }

    public void returnScooter(int id, int remainingBattery) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.setRented(false);
                scooter.setBattery(remainingBattery);
                System.out.print("Scooter mit folgender ID zurückgegeben: " + scooter.getId());
                System.out.println(" und so viel Akku ist noch da: " + scooter.getBattery());
                return;
            }
        }
        System.out.println("Scooter mit folgender ID " + id + " nicht gefunden.");

    }

    public void printStats() {
        System.out.println("Succeeded Rents: " + succeededRents);
        System.out.println("Failed Rents: " + failedRents);
    }

    @SuppressWarnings("unused")
    public ScooterStation() {
        this.scooters = new ArrayList<>();
    }

    @SuppressWarnings("unused")
    public List<Scooter> getScooters() {
        return scooters;
    }

    @SuppressWarnings("unused")
    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    @SuppressWarnings("unused")
    public Scooter findScooterById(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                return scooter;
            }
        }
        return null;
    }
}
// Erweitere das System so, dass man am Ende abfragen kann:
// Wie viele Mietanfragen waren erfolgreich und wie viele mussten mangels passender Scooter abgelehnt werden?