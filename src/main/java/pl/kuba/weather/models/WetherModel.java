package pl.kuba.weather.models;

public class WetherModel {
    private WeatherDetails main;
    private WeatherDetails1 clouds;
    private Weather[] weather;

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public WeatherDetails1 getClouds() {
        return clouds;
    }

    public void setClouds(WeatherDetails1 clouds) {
        this.clouds = clouds;
    }

    public WeatherDetails getMain() {
        return main;
    }

    public void setMain(WeatherDetails main) {
        this.main = main;
    }

    public static class WeatherDetails {
        private double temp;
        private int pressure;

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
    public static class WeatherDetails1 {
        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }
    public static class Weather {
        private String icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
