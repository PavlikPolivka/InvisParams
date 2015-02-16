package com.ppolivka.invisparams.string.impl;

import com.ppolivka.invisparams.enums.InvisibleCharacter;
import com.ppolivka.invisparams.string.InvisibleString;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test for invisible string class
 *
 * @author ppolivka
 * @since 0.0.1
 */
public class BinaryInvisibleStringTest {

    @Test
    public void toStringTest(){
        InvisibleString invisibleString = new BinaryInvisibleString(new InvisibleCharacter[]{InvisibleCharacter.B,InvisibleCharacter.C,InvisibleCharacter.D});
        invisibleString.add(InvisibleCharacter.B);
        String result = invisibleString.getInvisibleString();
        assertEquals(result.charAt(0),InvisibleCharacter.B.getCharacter());
        assertEquals(result.charAt(1), InvisibleCharacter.C.getCharacter());
        assertEquals(result.charAt(2), InvisibleCharacter.D.getCharacter());
        assertEquals(result.charAt(3),InvisibleCharacter.B.getCharacter());
    }

    @Test
    public void testEncode(){
        String encode = "This string will be encoded to invisible";
        InvisibleString invisibleString = new BinaryInvisibleString(encode);
        String result = invisibleString.getVisibleString();
        assertEquals(result,encode);
    }

}
