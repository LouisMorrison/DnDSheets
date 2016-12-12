package com.example.the_c.ddcharacterapp;

import java.util.ArrayList;

public class CircularList<E> extends ArrayList<E> {

    @Override
    public E get(int index) {
        if (index < 0) {
            index = index + size();
            return super.get(index);
        }
        else
            return super.get(index % size());
    }
}
