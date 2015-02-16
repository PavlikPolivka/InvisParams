package com.ppolivka.invisparams.collection;

import com.ppolivka.invisparams.enums.InvisibleCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representation of invisible string
 * This string is created from invisible characters
 *
 * @author ppolivka
 * @since 0.0.1
 */
@SuppressWarnings("UnusedDeclaration")
public class InvisibleString {

    private List<InvisibleCharacter> characters;

    public InvisibleString() {
        initCollection(null);
    }

    public InvisibleString(InvisibleCharacter[] characters) {
        initCollection(characters);
    }

    public InvisibleString(List<InvisibleCharacter> characters) {
        initCollection(characters.toArray(new InvisibleCharacter[characters.size()]));
    }

    private void initCollection(InvisibleCharacter[] invisibleCharacters){
        characters = new ArrayList<>();
        if(invisibleCharacters!=null) Collections.addAll(characters, invisibleCharacters);
    }

    public void add(InvisibleCharacter invisibleCharacter){
        characters.add(invisibleCharacter);
    }

    public void addAll(List<InvisibleCharacter> invisibleCharacters){
        characters.addAll(invisibleCharacters);
    }

    public void addAll(InvisibleCharacter[] invisibleCharacters){
        Collections.addAll(characters, invisibleCharacters);
    }

    public void clear(){
        characters.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(InvisibleCharacter invisibleCharacter:characters){
            stringBuilder.append(invisibleCharacter.getCharacter());
        }
        return stringBuilder.toString();
    }
}
