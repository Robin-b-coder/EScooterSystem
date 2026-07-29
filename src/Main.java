import java.util.ArrayList;
import java.util.List;

void main() {
    List<Scooter> scooters = new ArrayList<>(List.of(
            new Scooter(80, false),
            new Scooter(50, false),
            new Scooter(30, false),
            new Scooter(10, false)
    ));

    ScooterStation scooterStation = new ScooterStation(scooters);
    scooterStation.rentScooter(60);
    scooterStation.rentScooter(90);
    scooterStation.rentScooter(70);
    scooterStation.rentScooter(20);

    System.out.println("Trying to return scooter with id 1. remaining Battery is 20%.");
    scooterStation.returnScooter(1, 20);


    scooterStation.rentScooter(20);

    scooterStation.printStats();

}
