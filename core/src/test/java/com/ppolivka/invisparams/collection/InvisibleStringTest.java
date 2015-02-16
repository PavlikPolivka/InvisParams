package com.ppolivka.invisparams.collection;

import com.ppolivka.invisparams.enums.InvisibleCharacter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test for invisible string class
 *
 * @author ppolivka
 * @since 0.0.1
 */
public class InvisibleStringTest {

    @Test
    public void toStringTest(){
        InvisibleString invisibleString = new InvisibleString(new InvisibleCharacter[]{InvisibleCharacter.B,InvisibleCharacter.C,InvisibleCharacter.D});
        invisibleString.add(InvisibleCharacter.B);
        String result = invisibleString.toString();
        assertEquals(result.charAt(0),InvisibleCharacter.B.getCharacter());
        assertEquals(result.charAt(1),InvisibleCharacter.C.getCharacter());
        assertEquals(result.charAt(2),InvisibleCharacter.D.getCharacter());
        assertEquals(result.charAt(3),InvisibleCharacter.B.getCharacter());
    }

}
