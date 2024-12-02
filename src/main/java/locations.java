import java.util.ArrayList;
import java.util.Collections;

public class locations {
    private final ArrayList<Integer[]> location_ids = new ArrayList<>();
    private int total;

    public void parseLine(String line) {
        String[] split = line.split(" {3}");
        //System.out.printf("Split: %s, %s\n", split[0], split[1]);
        appendLocations(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
    public void appendLocations(int location_a, int location_b) {
        Integer[] locations = {location_a, location_b};
        this.location_ids.add(locations);
    }

    public void sort_locations() {
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer[] locationId : this.location_ids) {
                temp.add(locationId[i]);
            }
            Collections.sort(temp);
            for (int j = 0; j < temp.size(); j++) {
                this.location_ids.get(j)[i] = temp.get(j);
            }
            //System.out.println(temp);
        }
    }

    public int calculate_distance() {
        this.total = 0;
        for (Integer[] locationId : this.location_ids) {
            if (locationId[0] < locationId[1]) {
                this.total += locationId[1] - locationId[0];
            } else {
                this.total += locationId[0] - locationId[1];
            }
        }
        return this.total;
    }

    public int calculate_similarity() {
        this.total = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer[] locationId : this.location_ids) {
            temp.add(locationId[1]);
        }
        for (Integer[] locationId : this.location_ids) {
            this.total += locationId[0] * Collections.frequency(temp, locationId[0]);
        }
        return this.total;
    }
}
