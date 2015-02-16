package com.ppolivka.invisparams.enums;

/**
 * List of UTF browser invisible (zero width) characters
 *
 * @author ppolivka
 * @since 0.0.1
 */
public enum InvisibleCharacter {
    B('\u200B'),
    C('\u200C'),
    D('\u200D');

    final private char character;

    InvisibleCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
