import java.util.*;

public class As1_Message {
    private final String machineType;
    private final String machineID;
    private final String warning;

    As1_Message(String fullMessage) {
        String[] messageParts = fullMessage.split(":");
        String firstHalf = messageParts[0];

        warning = messageParts[1].trim();
        machineID = firstHalf.replaceAll("\\D+","");
        machineType = firstHalf.substring(0, firstHalf.indexOf(machineID));
    }

    boolean scanWarning (String keyword) {
        String[] warningParts = warning.split(" ");
        return Arrays.asList(warningParts).contains(keyword) || keyword.equals(warning);
    }

    @Override public String toString() {
        return "As1_Message{" +
                "machineType='" + machineType + '\'' +
                ", machineID='" + machineID + '\'' +
                ", warning='" + warning + '\'' +
                '}';
    }
}
