import java.time.LocalDate;

public class CeilingFan {
    private int speed;
    private boolean reversed;
    private final LocalDate christmasDay = LocalDate.of(LocalDate.now().getYear(), 12, 25);
    private LocalDate currentLocalDate;


    public CeilingFan() {
        speed = 0;
        reversed = false;
        currentLocalDate = LocalDate.now();
    }

    public void pullSpeedCord() {
        if (currentLocalDate.isEqual(christmasDay)) {
            System.out.println("Ceiling fan is off on Christmas day.");
            return;
        }

        speed++;
        if (speed > 3) {
            speed = 0;
        }
        System.out.println("Ceiling fan speed is " + speed);
    }

    public void pullDirectionCord() {
        if (currentLocalDate.isEqual(christmasDay)) {
            System.out.println("Ceiling fan is off on Christmas day.");
            return;
        }

        reversed = !reversed;
        System.out.println("Ceiling fan direction is " + (reversed ? "reversed" : "forward"));
    }
    public void reset() {
        speed = 0;
        reversed = false;
    }

    public void setCurrentDate(LocalDate localDate){
        this.currentLocalDate = localDate;
    }

    public LocalDate getChristmasDay(){
        return this.christmasDay;
    }

    public String toString() {
        String direction = reversed ? "reverse" : "forward";
        String status = LocalDate.now().isEqual(christmasDay) ? "off" : "on";
        return "Ceiling fan is " + status + " and spinning " + direction + " at speed " + speed;
    }

    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 0

        fan.pullSpeedCord();
        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 1

        fan.pullSpeedCord();
        fan.pullSpeedCord();

        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 3
        fan.pullSpeedCord();

        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 0

        fan.pullDirectionCord();
        fan.pullSpeedCord();
        System.out.println(fan); // Ceiling fan is on and spinning reverse at speed 1

        fan.pullSpeedCord();
        fan.pullSpeedCord();

        System.out.println(fan); // Ceiling fan is on and spinning reverse at speed 3
        fan.pullSpeedCord();

        fan.reset();

        fan.pullSpeedCord();
        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 1

        fan.pullSpeedCord();
        fan.pullSpeedCord();

        System.out.println(fan); // Ceiling fan is on and spinning forward at speed 3
        fan.pullSpeedCord();

        //Christmas
        fan.setCurrentDate(fan.getChristmasDay());
        System.out.println(fan); // Ceiling fan is off on Christmas day
        fan.pullSpeedCord();

    }
}
