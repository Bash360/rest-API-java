package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Primary
public class BubbleSort  implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbersToSort,int numberToFind) {
        return numbersToSort;
    }
}
