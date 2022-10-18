// Þükrü Can Mayda - 150120031
// The purpose of this program is to show some informations about smart home technologies.

import java.util.ArrayList;

public class SmartHome {

    private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();

    public SmartHome() {

    }

    public boolean addSmartObject(SmartObject smartObject) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Adding new SmartObject");
        System.out.println("--------------------------------------------------------------------------");
        smartObject.connect("10.0.0." + (smartObjectList.size() + 100));
        smartObject.testObject();
        return smartObjectList.add(smartObject);
    }

    public boolean removeSmartObject(SmartObject smartObject) {
        return smartObjectList.remove(smartObject);
    }

    public void controlLocation(boolean onCome) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("LocationControl: OnCome");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject s : smartObjectList) {
            if (LocationControl.class.isAssignableFrom(s.getClass())) {
                if (onCome) {
                    ((LocationControl) s).onCome();
                }
                else {
                    ((LocationControl) s).onLeave();
                }
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("LocationControl: hasMotion, isDay");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject s : smartObjectList) {
            if (MotionControl.class.isAssignableFrom(s.getClass())) {
                ((MotionControl) s).controlMotion(hasMotion,isDay);
            }
        }
    }

    public void controlProgrammable() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: runProgram");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject s : smartObjectList) {
            if (s instanceof SmartPlug && ((SmartPlug) s).isProgramAction()) {
                ((SmartPlug) s).runProgram();
            }

        }
        for (SmartObject s : smartObjectList) {
            if (s instanceof SmartLight && ((SmartLight) s).isProgramAction()) {
                ((SmartLight) s).runProgram();
            }
        }
    }

    public void controlTimer(int seconds) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: Timer = " + seconds + " seconds");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject s : smartObjectList) {
            if (Programmable.class.isAssignableFrom(s.getClass())) {
                if (seconds > 0) {
                    ((Programmable) s).setTimer(seconds);
                }
                else {
                    ((Programmable) s).cancelTimer();
                }
            }
        }
    }

    public void controlTimerRandomly() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        for (SmartObject s : smartObjectList) {
            if (s instanceof SmartLight) {
                int random = (int) (Math.random() * 3);
                if (random == 0) {
                    ((Programmable) s).cancelTimer();
                } else if (random == 1) {
                    ((Programmable) s).setTimer(5);
                } else if (random == 2) {
                    ((Programmable) s).setTimer(10);
                }
            }
        }
        for (SmartObject s : smartObjectList) {
            if (s instanceof SmartPlug) {
                int random = (int) (Math.random() * 3);
                if (random == 0) {
                    ((Programmable) s).cancelTimer();
                } else if (random == 1) {
                    ((Programmable) s).setTimer(5);
                } else if (random == 2) {
                    ((Programmable) s).setTimer(10);
                }
            }
        }

    }

    public void sortCameras() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort Smart Cameras");
        System.out.println("--------------------------------------------------------------------------");
        ArrayList<SmartCamera> smartCameras = new ArrayList<SmartCamera>();
        for (SmartObject s : smartObjectList) {
            if (s instanceof SmartCamera) {
                smartCameras.add((SmartCamera) s);
            }
        }
        for (SmartObject s : smartCameras) {
            System.out.println(s.toString());
        }
    }

    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }
}