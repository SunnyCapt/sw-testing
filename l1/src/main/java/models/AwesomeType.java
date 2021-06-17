package models;

public class AwesomeType {
    public String key;

    public AwesomeType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        System.out.println(this.key.length());
        return this.key.length();
    }
}