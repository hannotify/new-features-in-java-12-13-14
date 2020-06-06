package com.infosupport.musicstore.effects;

public interface Effect {
    default void apply() {
        System.out.println("Effect applied: " + description());
    }

    String description();
}
