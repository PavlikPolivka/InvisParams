package com.ppolivka.invisparams.string;

import com.ppolivka.invisparams.enums.InvisibleCharacter;

import java.util.List;

/**
 * Representation of invisible string
 * This string is created from invisible characters
 *
 * @author ppolivka
 * @since 0.0.1
 */
@SuppressWarnings("UnusedDeclaration")
public interface InvisibleString {

    /**
     * Adds one invisible character.
     *
     * @param invisibleCharacter the invisible character
     */
    void add(InvisibleCharacter invisibleCharacter);

    /**
     * Add multiple invisible characters.
     *
     * @param invisibleCharacters the invisible characters
     */
    void addAll(List<InvisibleCharacter> invisibleCharacters);

    /**
     * Add multiple invisible characters.
     *
     * @param invisibleCharacters the invisible characters
     */
    void addAll(InvisibleCharacter[] invisibleCharacters);

    /**
     * Converts text to invisible characters and adds it.
     *
     * @param text the text
     */
    void append(String text);

    /**
     * Clears all characters.
     */
    void clear();

    /**
     * Returns decoded text from invisible characters.
     *
     * @return the string
     */
    String getVisibleString();

    /**
     * Returns string of invisible characters.
     *
     * @return the string
     */
    String getInvisibleString();
}
