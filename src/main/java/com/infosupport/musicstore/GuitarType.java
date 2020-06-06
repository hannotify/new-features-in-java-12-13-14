package com.infosupport.musicstore;

public enum GuitarType {
    CLASSICAL,
    WESTERN,
    TELECASTER,
    STRATOCASTER,
    LES_PAUL;

    public boolean hasHumbucker() {
        boolean result;

        switch(this) {
            case CLASSICAL:
            case WESTERN:
            case TELECASTER:
            case STRATOCASTER:
                result = false;
                break;
            case LES_PAUL:
                result = true;
                break;
            default:
                throw new IllegalArgumentException("Unknown guitar type!");
        }

        return result;
    }

    public boolean isSolidBody() {
        switch(this) {
            case CLASSICAL:
            case WESTERN:
                return false;
            case TELECASTER:
            case STRATOCASTER:
            case LES_PAUL:
                return true;
            default:
                throw new IllegalArgumentException("Unknown guitar type!");
        }
    }
}
