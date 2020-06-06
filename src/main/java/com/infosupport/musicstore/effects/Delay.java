package com.infosupport.musicstore.effects;

import java.util.Objects;

public class Delay implements Effect {
    private int time;

    public void setTime(int time) {
        this.time = time;
    }

    public Delay(int time) {
        this.time = time;
    }

    @Override
    public String description() {
        return String.format("Delay, time=%dms", time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delay delay = (Delay) o;
        return time == delay.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
