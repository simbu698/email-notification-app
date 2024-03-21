import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IcsToJsonExample {

    public static void main(String[] args) {
        try {
            // Load ICS file
            BufferedReader br = new BufferedReader(new FileReader("your_calendar.ics"));

            // Parse the ICS file
            String line;
            Map<String, Object> event = new HashMap<>();
            List<Map<String, Object>> events = new ArrayList<>();
            boolean insideEvent = false;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("BEGIN:VEVENT")) {
                    insideEvent = true;
                } else if (line.startsWith("END:VEVENT")) {
                    insideEvent = false;
                    events.add(new HashMap<>(event));
                    event.clear();
                } else if (insideEvent) {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        event.put(parts[0], parts[1]);
                    }
                }
            }

            br.close();

            // Convert events to JSON
            System.out.println(events);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
