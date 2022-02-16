package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.Lesson6.ArraysClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MassTestForArray1 {

    public static Stream<Arguments> dataForAfterFour(){
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1,2,3,4,5,6}, new int[]{5,6}));
        list.add(Arguments.arguments(new int[]{1,2,3,4}, new int[]{}));
        list.add(Arguments.arguments(new int[]{1,2,4,3}, new int[]{3}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForAfterFour")
    public void massTestForArray1(int[] in, int[] out){
        Assertions.assertArrayEquals(out, ArraysClass.selectAfterFour(in));
    }
}
