package com.infosupport.musicstore;

import com.infosupport.musicstore.effects.Delay;
import com.infosupport.musicstore.effects.Effect;
import com.infosupport.musicstore.effects.Reverb;
import com.infosupport.musicstore.effects.Tremolo;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GuitarTest {
    private Guitar lesPaul, lesPaul2;
    private Guitar telecaster, telecaster2;

    @BeforeEach
    void setup() {
        lesPaul = new Guitar(GuitarType.LES_PAUL,
                "The Gibson Les Paul is a solid body electric guitar that was first sold by the Gibson Guitar" +
                        " Corporation in 1952. \n" +
                        "The Les Paul was designed by Gibson president Ted McCarty, factory " +
                        "manager John Huis and their team with input from and endorsement by guitarist Les Paul.\n" +
                        "Its typical design features a solid mahogany body with a carved maple top and a single cutaway, a " +
                        "mahogany set-in neck with a rosewood fretboard, two pickups with independent volume and tone " +
                        "controls, and a stoptail bridge, although variants exist.",
                List.of(new Tremolo(5, 1500), new Reverb("HallReverb", 180)));
        lesPaul2 = new Guitar(GuitarType.LES_PAUL,
                "The Gibson Les Paul is a solid body electric guitar that was first sold by the Gibson Guitar" +
                        " Corporation in 1952. \n" +
                        "The Les Paul was designed by Gibson president Ted McCarty, factory " +
                        "manager John Huis and their team with input from and endorsement by guitarist Les Paul.\n" +
                        "Its typical design features a solid mahogany body with a carved maple top and a single cutaway, a " +
                        "mahogany set-in neck with a rosewood fretboard, two pickups with independent volume and tone " +
                        "controls, and a stoptail bridge, although variants exist.",
                List.of(new Tremolo(5, 1500), new Reverb("HallReverb", 180)));

        telecaster = new Guitar(GuitarType.TELECASTER,
                String.format("The Fender Telecaster, colloquially known as the Tele, is the world's first commercially " +
                        "successful solid-body electric guitar. Its simple yet effective design and revolutionary sound " +
                        "broke ground and set trends in electric guitar manufacturing and popular music." +
                        "%n%nIntroduced for " +
                        "national distribution as the Broadcaster in the autumn of 1950, it was the first guitar of its " +
                        "kind manufactured on a substantial scale and has been in continuous production in one form or " +
                        "another since its first incarnation."),
                List.of(new Delay(440)));
        telecaster2 = new Guitar(GuitarType.TELECASTER,
                String.format("The Fender Telecaster, colloquially known as the Tele, is the world's first commercially " +
                        "successful solid-body electric guitar. Its simple yet effective design and revolutionary sound " +
                        "broke ground and set trends in electric guitar manufacturing and popular music." +
                        "%n%nIntroduced for " +
                        "national distribution as the Broadcaster in the autumn of 1950, it was the first guitar of its " +
                        "kind manufactured on a substantial scale and has been in continuous production in one form or " +
                        "another since its first incarnation."),
                List.of(new Delay(440)));

        System.out.println(lesPaul);
        System.out.println(telecaster);
    }

    @Test
    @DisplayName("equals() should return true for identical guitars, false otherwise.")
    void testEquals() {
        assertThat(lesPaul).isEqualTo(lesPaul2);
        assertThat(telecaster).isEqualTo(telecaster2);
        assertThat(lesPaul).isNotEqualTo(telecaster);
        assertThat(telecaster2).isNotEqualTo(lesPaul2);
    }

    @Test
    @DisplayName("hashCode() should return the same values for identical guitars, and different values otherwise.")
    void testHashCode() {
        assertThat(lesPaul.hashCode()).isEqualTo(lesPaul2.hashCode());
        assertThat(telecaster.hashCode()).isEqualTo(telecaster2.hashCode());
        assertThat(lesPaul.hashCode()).isNotEqualTo(telecaster.hashCode());
        assertThat(telecaster2.hashCode()).isNotEqualTo(lesPaul2.hashCode());
    }

    @Test
    @DisplayName("TODO")
    void testEffects() {
        List.of(lesPaul, telecaster).forEach(g ->
                g.getActivatedEffects().forEach(e -> {
                    e.apply();

                    if (e instanceof Tremolo) {
                        var tremolo = (Tremolo) e;
                        tremolo.setRate(750);
                    } else if (e instanceof Reverb) {
                        var reverb = (Reverb) e;
                        reverb.setName("StadiumReverb");
                        reverb.setRoomSize(47500);
                    } else if (e instanceof Delay) {
                        var delay = (Delay) e;
                        delay.setTime(220);
                    }

                    e.apply();
                })
        );
    }
}