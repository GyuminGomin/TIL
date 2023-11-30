package simple_test_java.my_test.src.t20231130.practice2;

public class Nation {

    private String country;
    private String capital;
    
    public String getCountry() {
        return country;
    }
    public String getCapital() {
        return capital;
    }

    public Nation(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Nation [country=" + country + ", capital=" + capital + "]";
    }
    
}
