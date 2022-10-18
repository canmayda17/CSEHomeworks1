import java.util.Calendar;

public class Project {

    private String projectName;
    private java.util.Calendar startDate;
    private boolean state;

    public Project(String pName, java.util.Calendar startDate, String state) {
        this.projectName = pName;
        this.startDate = startDate;
        if (state == "Open") {
            this.state = true;
        }
        else if (state == "Close") {
            this.state = false;
        }
    }

    public String getState() {
        if (state) {
            return "Open";
        }
        else if(!state) {
            return "Close";
        }
        else
            return "Please write Open or Close ";
    }

    public void setState(String state) {
        if (state == "Open") {
            this.state = true;
        }
        else if (state == "Close") {
            this.state = false;
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public boolean isState() {
        return state;
    }

    public void close() {
        this.state = false;
    }
}
