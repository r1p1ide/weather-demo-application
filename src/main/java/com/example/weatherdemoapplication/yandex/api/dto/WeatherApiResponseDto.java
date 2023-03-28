package com.example.weatherdemoapplication.yandex.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class WeatherApiResponseDto {

    @Data
    public static class Biomet {
        public int index;
        public String condition;
    }

    @Data
    public static class Country {
        public int id;
        public String name;
    }

    @Data
    public static class Day {
        public String _source;
        public int temp_min;
        public int temp_avg;
        public int temp_max;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class DayShort {
        public String _source;
        public int temp;
        public int temp_min;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class District {
        public int id;
        public String name;
    }

    @Data
    public static class Evening {
        public String _source;
        public int temp_min;
        public int temp_avg;
        public int temp_max;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class Fact {
        public int obs_time;
        public int uptime;
        public int temp;
        public int feels_like;
        public String icon;
        public String condition;
        public double cloudness;
        public int prec_type;
        public int prec_prob;
        public int prec_strength;
        public boolean is_thunder;
        public int wind_speed;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public String daytime;
        public boolean polar;
        public String season;
        public String source;
        public double soil_moisture;
        public int soil_temp;
        public int uv_index;
        public double wind_gust;
    }

    @Data
    public static class Forecast {
        public String date;
        public int date_ts;
        public int week;
        public String sunrise;
        public String sunset;
        public String rise_begin;
        public String set_end;
        public int moon_code;
        public String moon_text;
        public Parts parts;
        public ArrayList<Hour> hours;
        public Biomet biomet;
    }

    @Data
    public static class GeoObject {
        public District district;
        public Locality locality;
        public Province province;
        public Country country;
    }

    @Data
    public static class Hour {
        public String hour;
        public int hour_ts;
        public int temp;
        public int feels_like;
        public String icon;
        public String condition;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public boolean is_thunder;
        public String wind_dir;
        public double wind_speed;
        public double wind_gust;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int uv_index;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_period;
        public int prec_prob;
    }

    @Data
    public static class Info {
        public boolean n;
        public int geoid;
        public String url;
        public double lat;
        public double lon;
        public Tzinfo tzinfo;
        public int def_pressure_mm;
        public int def_pressure_pa;
        public String slug;
        public int zoom;
        public boolean nr;
        public boolean ns;
        public boolean nsr;
        public boolean p;
        public boolean f;
        public boolean _h;
    }

    @Data
    public static class Locality {
        public int id;
        public String name;
    }

    @Data
    public static class Morning {
        public String _source;
        public int temp_min;
        public int temp_avg;
        public int temp_max;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public int cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class Night {
        public String _source;
        public int temp_min;
        public int temp_avg;
        public int temp_max;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class NightShort {
        public String _source;
        public int temp;
        public double wind_speed;
        public double wind_gust;
        public String wind_dir;
        public int pressure_mm;
        public int pressure_pa;
        public int humidity;
        public int soil_temp;
        public double soil_moisture;
        public double prec_mm;
        public int prec_prob;
        public int prec_period;
        public double cloudness;
        public int prec_type;
        public double prec_strength;
        public String icon;
        public String condition;
        public int uv_index;
        public int feels_like;
        public String daytime;
        public boolean polar;
        public int fresh_snow_mm;
    }

    @Data
    public static class Parts {
        public DayShort day_short;
        public Morning morning;
        public NightShort night_short;
        public Day day;
        public Night night;
        public Evening evening;
    }

    @Data
    public static class Province {
        public int id;
        public String name;
    }

    @Data
    public static class Tzinfo {
        public String name;
        public String abbr;
        public boolean dst;
        public int offset;
    }

    @Data
    public static class Yesterday {
        public int temp;
    }

    private int now;
    private Date now_dt;
    private Info info;
    private GeoObject geo_object;
    private Yesterday yesterday;
    private Fact fact;
    private ArrayList<Forecast> forecasts;
}
