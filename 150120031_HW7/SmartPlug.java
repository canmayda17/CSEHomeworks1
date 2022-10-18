// Þükrü Can Mayda - 150120031

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SmartPlug extends SmartObject implements Programmable{

    private boolean status, programAction;
    Calendar programTime;

    public SmartPlug(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
    }

    public void turnOn() {
        if (controlConnection()) {
            if (!status) {
                status = true;
                Calendar currentTime = new GregorianCalendar();
                System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            else {
                System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
            }
        }
    }

    public void turnOff() {
        if (controlConnection()) {
            if (status) {
                status = false;
                Calendar currentTime = new GregorianCalendar();
                System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: "+ currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            else {
                System.out.println("Smart Plug - " + getAlias() + " has been already turned off");
            }
        }
    }

    @Override
    public boolean testObject() {
        if (controlConnection()) {
            System.out.println("Test is starting for SmartPlug");
            System.out.println("This is SmartPlug device " + getAlias());
            SmartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test completed for SmartPlug");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean shutDownObject() {
        if (controlConnection()) {
            SmartObjectToString();
            if (status) {
                turnOff();
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setTimer(int seconds) {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            programTime = new GregorianCalendar();
            programAction = true;
            if (status) {
                System.out.println("Smart plug - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            else {
                System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            }
            programTime.add(Calendar.SECOND, seconds);
        }
    }

    @Override
    public void cancelTimer() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            System.out.println("Smart plug - " + getAlias() + " will be turned on now! (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
            programTime = null;
            programAction = false;
        }
    }

    @Override
    public void runProgram() {
        if (controlConnection()) {
            Calendar currentTime = new GregorianCalendar();
            if (getProgramTime() != null) {
                if (!programAction && getProgramTime().get(Calendar.SECOND) == currentTime.get(Calendar.SECOND) && getProgramTime().get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE)) {
                    if (status) {
                        turnOff();
                        System.out.println("runProgram -> Smart Plug - " + getAlias());
                        System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
                        setProgramTime(null);
                    } else {
                        turnOn();
                        System.out.println("runProgram -> Smart Plug - " + getAlias());
                        System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: " + currentTime.get(Calendar.HOUR) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND) + ")");
                        setProgramTime(null);
                    }
                }
            }
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }
}