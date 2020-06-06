package com.infosupport.musicstore;

import static com.infosupport.musicstore.GuitarType.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuitarTypeTest {

    @Test
    @DisplayName("A Les Paul should have a humbucker, all other guitar types shouldn't.")
    void hasHumbucker() {
        assertThat(LES_PAUL.hasHumbucker()).isTrue();

        assertAll(
                () -> assertThat(CLASSICAL.hasHumbucker()).isFalse(),
                () -> assertThat(WESTERN.hasHumbucker()).isFalse(),
                () -> assertThat(TELECASTER.hasHumbucker()).isFalse(),
                () -> assertThat(STRATOCASTER.hasHumbucker()).isFalse()
        );
    }

    @Test
    @DisplayName("Telecasters, Stratocasters and Les Pauls should be solid bodies, all other guitar types shouldn't.")
    void isSolidBody() {
        assertAll(
                () -> assertThat(TELECASTER.isSolidBody()).isTrue(),
                () -> assertThat(STRATOCASTER.isSolidBody()).isTrue(),
                () -> assertThat(LES_PAUL.isSolidBody()).isTrue()
        );

        assertAll(
                () -> assertThat(CLASSICAL.isSolidBody()).isFalse(),
                () -> assertThat(WESTERN.isSolidBody()).isFalse()
        );
    }
}