package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gb.Lesson6.ArraysClass;

public class TestArray {

    @Test
    public void testArrayAfterFour(){
        int in[] = {1,5,12,6,8,4,5,6,8};
        int out[] = {5,6,8};
        Assertions.assertArrayEquals(out, ArraysClass.selectAfterFour(in));
    }

    @Test
    public void testArrayAfterFour2(){
        int in[] = {1,5,12,6,8,5,6,8};
        Assertions.assertThrows(RuntimeException.class, ()-> {
            ArraysClass.selectAfterFour(in);
        });
    }


    @Test
    public void testOnlyOneAndFourArray() {
        int[] in = new int[]{1, 3, 4, 5};
        Assertions.assertFalse(ArraysClass.onlyOneAndFourArray(in));
    }


    @Test
    public void testOnlyOneAndFourArray2() {
        int[] in = new int[]{1, 4, 1};
        Assertions.assertTrue(ArraysClass.onlyOneAndFourArray(in));
    }

}



