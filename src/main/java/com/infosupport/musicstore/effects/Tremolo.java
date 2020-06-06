package com.infosupport.musicstore.effects;

import java.util.Objects;

public class Tremolo implements Effect {
    private int depth, rate;

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Tremolo(int depth, int rate) {
        this.depth = depth;
        this.rate = rate;
    }

    @Override
    public String description() {
        return String.format("Tremolo, depth=%d, rate=%dms", depth, rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tremolo tremolo = (Tremolo) o;
        return depth == tremolo.depth &&
                rate == tremolo.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(depth, rate);
    }
}
