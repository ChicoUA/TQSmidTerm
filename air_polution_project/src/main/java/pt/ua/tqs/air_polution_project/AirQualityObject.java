package pt.ua.tqs.air_polution_project;

public class AirQualityObject {
    private int air_quality_index;
    private double pm10;
    private double pm25;
    private double o3;
    private double so2;
    private double no2;
    private double co;
    private int pollen_level_tree;
    private  int pollen_level_weed;
    private int  pollen_level_grass;
    private String city_name;

    public AirQualityObject(int air_quality_index, double pm10, double pm25, double o3, double so2, double no2, double co, int pollen_level_tree, int pollen_level_weed, int pollen_level_grass, String city_name) {
        this.air_quality_index = air_quality_index;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.o3 = o3;
        this.so2 = so2;
        this.no2 = no2;
        this.co = co;
        this.pollen_level_tree = pollen_level_tree;
        this.pollen_level_weed = pollen_level_weed;
        this.pollen_level_grass = pollen_level_grass;
        this.city_name = city_name;
    }

    public int getAir_quality_index() {
        return air_quality_index;
    }

    public double getPm10() {
        return pm10;
    }

    public double getPm25() {
        return pm25;
    }

    public double getO3() {
        return o3;
    }

    public double getSo2() {
        return so2;
    }

    public double getNo2() {
        return no2;
    }

    public double getCo() {
        return co;
    }

    public int getPollen_level_tree() {
        return pollen_level_tree;
    }

    public int getPollen_level_weed() {
        return pollen_level_weed;
    }

    public int getPollen_level_grass() {
        return pollen_level_grass;
    }

    public String getCity_name() {
        return city_name;
    }

    @Override
    public String toString() {
        return "AirQualityObject{" +
                "air_quality_index=" + air_quality_index +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", o3=" + o3 +
                ", so2=" + so2 +
                ", no2=" + no2 +
                ", co=" + co +
                ", pollen_level_tree=" + pollen_level_tree +
                ", pollen_level_weed=" + pollen_level_weed +
                ", pollen_level_grass=" + pollen_level_grass +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
