import java.util.*;

public class As1_Message {
    private String machineType;
    private String machineID;
    private String warning;

    As1_Message(String fullMessage) {
        String[] messageParts = fullMessage.split(":");
        String firstHalf = messageParts[0];

        warning = messageParts[1].trim();
        machineID = firstHalf.replaceAll("\\D+","");
        machineType = firstHalf.substring(0, firstHalf.indexOf(machineID));
    }

    boolean scanWarning (String keyword) {
        String[] warningParts = warning.split(" ");
        return Arrays.asList(warningParts).contains(keyword);
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineID() {
        return machineID;
    }

    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        return "As1_Message{" +
                "machineType='" + machineType + '\'' +
                ", machineID='" + machineID + '\'' +
                ", warning='" + warning + '\'' +
                '}';
    }
}
