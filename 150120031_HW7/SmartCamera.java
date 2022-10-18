// Þükrü Can Mayda - 150120031

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>{

    private boolean status, nightVision;
    private int batteryLife;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
        super();
        setAlias(alias);
        setMacId(macId);
        this.nightVision = nightVision;
        this.batteryLife = batteryLife;

    }

    public void recordOn(boolean isDay) {
        if (controlConnection()) {
            if (isDay && nightVision) {
                if (!status) {
                    this.status = true;
                    System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
                } else {
                    System.out.println("Smart Camera - " + super.getAlias() + " has been already turned on");
                }
            }
            else if (!isDay && !nightVision) {
                System.out.println("Sorry! Smart Camera - " + super.getAlias() + " does not have night vision feature.");
            }
            else {
                if (!status) {
                    this.status = true;
                    System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
                } else {
                    System.out.println("Smart Camera - " + super.getAlias() + " has been already turned on");
                }
            }

        }
    }

    public void recordOff() {
        if (controlConnection()) {
            if (status) {
                this.status = false;
                System.out.println("Smart Camera - " + super.getAlias() + " is turned off now");
            }
            else {
                System.out.println("Smart Camera - " + super.getAlias() + " has been already turned off");
            }
        }
    }
    @Override
    public boolean testObject() {
        if (controlConnection()) {
            System.out.println("Test is starting for SmartCamera");
            System.out.println("This is SmartCamera device " + getAlias());
            SmartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test completed for SmartCamera");
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean shutDownObject() {
        if (controlConnection()) {
            recordOff();
            SmartObjectToString();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        if (hasMotion) {
            System.out.println("Motion detected!");
            recordOn(isDay);
            return true;
        }
        else {
            System.out.println("Motion not detected!");
            return false;
        }
    }

    @Override
    public int compareTo(SmartCamera o) {
        if (batteryLife > o.batteryLife) {
            return 1;
        }
        else if (batteryLife < o.batteryLife) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "SmartCamera -> " + getAlias() + "'s battery life is " + getBatteryLife() + " status is recording";
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }
}
