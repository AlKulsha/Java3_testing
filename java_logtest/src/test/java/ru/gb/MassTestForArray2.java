package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.Lesson6.ArraysClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MassTestForArray2 {
    public static Stream<Arguments> dataForOnlyOneAndFourArray(){
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{2,5,4,6,7,8}, false));
        list.add(Arguments.arguments(new int[]{1,4,4}, true));
        list.add(Arguments.arguments(new int[]{1,1,1,1}, false));
        list.add(Arguments.arguments(new int[]{4,4,4,4}, false));
        return list.stream();
    }


    @ParameterizedTest
    @MethodSource("dataForOnlyOneAndFourArray")
    public void massTestForFindOneOrFour(int[] in, boolean flag){
        Assertions.assertEquals(ArraysClass.onlyOneAndFourArray(in), flag);
    }


}
