public class Scooter {
    private int id;
    private static int nextId = 0;
    private int battery;
    private boolean isRented;

    public Scooter(int battery, boolean isRented) {
        this.id = ++nextId;
        this.battery = battery;
        this.isRented = isRented;
    }

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public static int getNextId() {
        return nextId;
    }

    @SuppressWarnings("unused")
    public static void setNextId(int nextId) {
        Scooter.nextId = nextId;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @SuppressWarnings("unused")
    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        this.isRented = rented;
    }
}
