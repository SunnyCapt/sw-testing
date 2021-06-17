package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Clothes {
    private String color;
    private String clotheName;
    private String clotheQuality;

    @Override
    public String toString() {
        return this.clotheName;
    }
}
