package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BinarySearch {

    @Autowired
    SortAlgorithm sortAlgorithm;

//    public BinarySearch(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }




    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int getValue(int[] numbers, int numberToFind){
        sortAlgorithm.sort(numbers,numberToFind);
    return 3;
}
}
