import java.util.ArrayList;
import java.util.Collections;

public class locations {
    private ArrayList<Integer[]> location_ids = new ArrayList<Integer[]>();

    public void parseLine(String line) {
        String[] split = line.split("   ");
        //System.out.printf("Split: %s, %s\n", split[0], split[1]);
        appendLocations(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
    public void appendLocations(int location_a, int location_b) {
        Integer[] locations = {location_a, location_b};
        this.location_ids.add(locations);
    }
    public Integer[] getLocations(int index) {
        return this.location_ids.get(index);
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
        int total = 0;
        for (Integer[] locationId : this.location_ids) {
            if (locationId[0] < locationId[1]) {
                total += locationId[1] - locationId[0];
            } else {
                total += locationId[0] - locationId[1];
            }
        }
        return total;
    }
}
