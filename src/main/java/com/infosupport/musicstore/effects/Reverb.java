package com.infosupport.musicstore.effects;

import java.util.Objects;

public class Reverb implements Effect {
    private String name;
    private int roomSize;

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public Reverb(String name, int roomSize) {
        this.name = name;
        this.roomSize = roomSize;
    }

    @Override
    public String description() {
        return String.format("%s, roomSize=%d", name, roomSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reverb reverb = (Reverb) o;
        return roomSize == reverb.roomSize &&
                Objects.equals(name, reverb.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roomSize);
    }
}
