// Þükrü Can Mayda - 150120031

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class SmartLight extends SmartObject implements LocationControl, Programmable{

    private boolean hasLightTurned;
    private Calendar programTime = new GregorianCalendar();
    private boolean programAction;

    public SmartLight(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
    }

    public void turnOnLight() {
        if (controlConnection()) {
            if (!hasLightTurned) {
                hasLightTurned = true;
                Calendar currentTime = new GregorianCalendar();
                System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            } else {
                System.out.println("Smart Light - " + getAlias() + " has been already turned on");
            }
        }
    }

    public void turnOffLight() {
        if (controlConnection()) {
            if (hasLightTurned) {
                hasLightTurned = false;
                Calendar currentTime = new GregorianCalendar();
                System.out.println("Smart Light - " + getAlias() + " is turned off now (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            else {
                System.out.println("Smart Light - " + getAlias() + " has been already turned off");
            }
        }

    }
    @Override
    public boolean testObject() {
        if (controlConnection()) {
            System.out.println("Test is starting for SmartLight");
            System.out.println("This is SmartLight device " + getAlias());
            super.SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean shutDownObject() {
        if (controlConnection()) {
            super.SmartObjectToString();
            if (hasLightTurned) {
                turnOffLight();
            }
            return true;
        }
        else {
            return false;
        }
    }

    public void onLeave() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            System.out.println("On Leave -> Smart Light - " + getAlias());
            turnOffLight();
        }
    }

    public void onCome() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            System.out.println("On Come -> Smart Light - " + getAlias());
            turnOnLight();
        }
    }
    @Override
    public void setTimer (int seconds) {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            programTime = new GregorianCalendar();
            programAction = true;
            if (hasLightTurned) {
                System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            else {
                System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            programTime.add(Calendar.SECOND, seconds);
        }
    }

    @Override
    public void cancelTimer() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            System.out.println("Smart light - " + getAlias() + " will be turned on now! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            programTime = null;
        }
    }
    @Override
    public void runProgram() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            if (getProgramTime() != null) {
                if (getProgramTime().get(Calendar.SECOND) == currentTime.get(Calendar.SECOND) && getProgramTime().get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE)) {
                    if (programAction) {
                        turnOffLight();
                        System.out.println("runProgram -> Smart Light - " + getAlias());
                        System.out.println("Smart light - " + getAlias() + " is turned off now! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
                        setProgramTime(null);
                    } else {
                        turnOnLight();
                        System.out.println("runProgram -> Smart Light - " + getAlias());
                        System.out.println("Smart light - " + getAlias() + " is turned on now! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
                        setProgramTime(null);
                    }
                }
            }
        }
    }

    public boolean isHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }
}
