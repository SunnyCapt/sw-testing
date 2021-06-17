package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sound {
    private String soundName;

    @Override
    public String toString() {
        return this.soundName;
    }
}
