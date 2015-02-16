package com.ppolivka.invisparams.string.impl;

import com.ppolivka.invisparams.enums.InvisibleCharacter;
import com.ppolivka.invisparams.string.InvisibleString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Invisible String that is using binary conversion to invisible characters
 *
 * @author ppolivka
 * @since 0.0.1
 */
@SuppressWarnings("UnusedDeclaration")
public class BinaryInvisibleString implements InvisibleString {

    private List<InvisibleCharacter> characters;

    public BinaryInvisibleString() {
        initCollection(null);
    }

    public BinaryInvisibleString(InvisibleCharacter[] characters) {
        initCollection(Arrays.asList(characters));
    }

    public BinaryInvisibleString(List<InvisibleCharacter> characters) {
        initCollection(characters);
    }

    public BinaryInvisibleString(String text) {
        initCollection(convertText(text));
    }

    private void initCollection(List<InvisibleCharacter> invisibleCharacters){
        characters = new ArrayList<>();
        if(invisibleCharacters!=null){
            characters.addAll(invisibleCharacters);
        }
    }

    @Override
    public void add(InvisibleCharacter invisibleCharacter){
        characters.add(invisibleCharacter);
    }

    @Override
    public void addAll(List<InvisibleCharacter> invisibleCharacters){
        characters.addAll(invisibleCharacters);
    }

    @Override
    public void addAll(InvisibleCharacter[] invisibleCharacters){
        Collections.addAll(characters, invisibleCharacters);
    }

    @Override
    public void append(String text){
        characters.addAll(convertText(text));
    }

    @Override
    public void clear(){
        characters.clear();
    }

    @Override
    public String getVisibleString() {
        return new String(toPrimitives(convertToText()));
    }

    @Override
    public String getInvisibleString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(InvisibleCharacter invisibleCharacter:characters){
            stringBuilder.append(invisibleCharacter.getCharacter());
        }
        return stringBuilder.toString();
    }

    private List<InvisibleCharacter> convertText(String text){
        List<InvisibleCharacter> invisibleCharacters = new ArrayList<>();
        for (byte b : text.getBytes()) {
            for ( int mask = 0x01; mask != 0x100; mask <<= 1 ) {
                boolean value = ( b & mask ) != 0;
                if(value){
                    invisibleCharacters.add(InvisibleCharacter.B);
                } else {
                    invisibleCharacters.add(InvisibleCharacter.C);
                }
            }
        }
        return invisibleCharacters;
    }

    private Byte[] convertToText(){
        List<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < characters.size(); i += 8) {
            int b = 0;
            for (int j = Math.min(i + 7, characters.size()-1); j >= i; j--) {
                boolean value = characters.get(j).equals(InvisibleCharacter.B);
                b = (b << 1) | (value ? 1 : 0);
            }
            bytes.add((byte) b);
        }
        return bytes.toArray(new Byte[bytes.size()]);
    }

    byte[] toPrimitives(Byte[] oBytes)
    {
        byte[] bytes = new byte[oBytes.length];
        for(int i = 0; i < oBytes.length; i++){
            bytes[i] = oBytes[i];
        }
        return bytes;
    }

}
