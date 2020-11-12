package uz.pdp;

public class Weather {
private double temp;

    public Weather(double temp) {
        this.temp = temp;
    }

    public Weather() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                '}';
    }

    //private double temp;
//    "main": {
//        "temp": 274.82,
//                "feels_like": 270.7,
//                "temp_min": 274.26,
//                "temp_max": 275.15,
//                "pressure": 1030,
//                "humidity": 87
//    },
}
