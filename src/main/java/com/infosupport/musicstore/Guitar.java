package com.infosupport.musicstore;

import com.infosupport.musicstore.effects.Effect;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Guitar {
    private GuitarType guitarType;
    private String description;
    private List<Effect> activatedEffects;

    public Guitar(GuitarType guitarType, String description, List<Effect> activeEffects) {
        this.guitarType = guitarType;
        this.description = description;
        this.activatedEffects = activeEffects;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Guitar.class.getSimpleName() + "[", "]")
                .add("guitarType=" + guitarType)
                .add("description='" + description + "'")
                .add("availableEffects=" + activatedEffects)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return guitarType.equals(guitar.guitarType) &&
                description.equals(guitar.description) &&
                activatedEffects.equals(guitar.activatedEffects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guitarType, description, activatedEffects);
    }

    public GuitarType getGuitarType() {
        return guitarType;
    }

    public String getDescription() {
        return description;
    }

    public List<Effect> getActivatedEffects() {
        return activatedEffects;
    }
}
