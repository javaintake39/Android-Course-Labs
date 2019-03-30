package com.example.mvplogin.model;

public class CountryPojo
{
    private String rank;
    private String country;
    private String population;
    private String flag;

    public CountryPojo()
    {}
    public CountryPojo(String rank, String country, String population, String flag) {
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    public String getRank() {
        return rank;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return rank+"\n"+country+"\n"+population+"\n"+flag;
    }
}

