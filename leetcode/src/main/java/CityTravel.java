import java.util.Vector;

public class CityTravel {

    static volatile int minIdx = 0;
    static volatile double minDis = 0;

    public static void PrintNearestCity(Vector<String> cities, String query) {

        int size = cities.size();
        String finalQuery = query;
        new Thread(() -> {
            for (int i = 0; i < size / 2; i++) {
                if(!cities.get(i).equals(finalQuery)){
                    double temDis = DistCalc.getDistance(cities.get(i), finalQuery);
                    if(minDis == 0 || temDis < minDis){
                        minDis = temDis;
                        minIdx = i;
                    }
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = size / 2; i < size; i++) {
                if(!cities.get(i).equals(finalQuery)){
                    double temDis = DistCalc.getDistance(cities.get(i), finalQuery);
                    if(minDis == 0 || temDis < minDis){
                        minDis = temDis;
                        minIdx = i;
                    }
                }
            }
        }).start();

        query = cities.get(minIdx) + " " + minDis;
    }

}

