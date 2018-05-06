package com.accenture.javatest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KingSortTest
{
    @Test
    public void shouldReturnTheSameArrayWhenSortingAnNullArray()
    {
        String[] kings = null;
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnEmptyArray()
    {
        String[] kings = new String[0];
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithNullValues()
    {
        String[] kings = { null };
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithNoSpaceValue()
    {
        String[] kings = { "King" };
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithMoreThanOneSpacesValues()
    {
        String[] kings = { "King V I" };
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithNoKingNameValue()
    {
        String[] kings = { " IV" };
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithNoRomanNumber()
    {
        String[] kings = { "King " };
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnTheSameArrayWhenSortingAnBadFormattedArrayWithABadFormattedRomanNumber()
    {
        String[] kings = { "King King"};
        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);
        assertThat(actual, is(kings));
    }

    @Test
    public void shouldReturnAnOrderedKingsNamesList()
    {
        String[] kings = { "King V", "King I", "King III", "OtherKing X", "OtherKing II", "AnotherKing I", "AnotherKing X" };
        String[] expected = { "AnotherKing I", "AnotherKing X", "King I", "King III", "King V", "OtherKing II", "OtherKing X" };

        KingSort kingSort = new KingSort();
        String[] actual = kingSort.getSortedList(kings);

        assertThat(actual, is(expected));
    }
}
