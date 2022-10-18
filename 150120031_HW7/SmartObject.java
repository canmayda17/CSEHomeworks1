// Þükrü Can Mayda - 150120031

public abstract class SmartObject {

    private String alias, macId, IP;
    private boolean connectionStatus;

    public SmartObject() {

    }

    public boolean connect(String IP) {
        this.IP = IP;
        connectionStatus = true;
        System.out.println(getAlias() + " connection established");
        return isConnectionStatus();
    }

    public boolean disconnect() {
        connectionStatus = false;
        this.IP = IP;
        return isConnectionStatus();
    }

    public void SmartObjectToString() {
        System.out.println("  MacId: " + this.macId);
        System.out.println("  IP: " + this.IP);
    }

    public boolean controlConnection() {
        if (connectionStatus) {
            return true;
        }
        else {
            System.out.println("This device is not connected. SmartCamera -> " + getAlias());
            return false;
        }
    }

    public abstract boolean testObject();

    public abstract boolean shutDownObject();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}