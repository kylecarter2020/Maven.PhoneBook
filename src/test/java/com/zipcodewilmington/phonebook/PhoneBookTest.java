package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testHasEntryTrue(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";

        //When
        phoneBook.add(name, number);

        //Then
        Assert.assertTrue(phoneBook.hasEntry(name));

    }

    @Test
    public void testHasEntryFalse(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";
        String name2 = "Bob";
        phoneBook.add(name, number);

        //When
        boolean expected = phoneBook.hasEntry(name2);

        //Then
        Assert.assertFalse(expected);

    }

    @Test
    public void testAdd(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";

        //When
        phoneBook.add(name, number);
        String expected = name + " " + number + "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddNumberToExisting(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";
        String number2 = "302-444-4444";

        //When
        phoneBook.add(name, number);
        phoneBook.add(name, number2);
        String expected = name + " " + number2 + ", " + number + "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddMultipleEntries(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";
        String name2 = "Bob";
        String number2 = "302-444-4444";

        //When
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
        String expected = name2 + " " + number2 + "\n" + name + " " + number + "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddMultipleNumbers(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-444-4444","302-333-3333"};

        //When
        phoneBook.add(name, number);
        String expected = name + " " + number[0] + ", " + number[1] + ", " + number[2]+ "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetArrayListFor(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-333-3333"};
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);

        //When
        ArrayList<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(number2));
        ArrayList<String> actual = phoneBook.getArrayListFor(name2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testLookupByName(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String number = "302-555-5555";
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-333-3333"};

        //When
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
        String expected = number + "\n";
        String actual = phoneBook.lookup(name);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseLookup(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-333-3333"};
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-222-2222"};
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);

        //When
        String expected = name + "\n";
        String actual = phoneBook.reverseLookup("302-333-3333");

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveNumber(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-333-3333", "302-444-4444"};
        phoneBook.add(name, number);

        //When
        phoneBook.remove(name, "302-333-3333");
        String expected = "302-555-5555, 302-444-4444\n";
        String actual = phoneBook.lookup(name);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListNamesAndNumbers(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-333-3333"};
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-222-2222"};

        //When
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
        String expected = name2 + " " + number2[0] + ", " + number2[1] + "\n" + name + " " + number[0] + ", " + number[1] + "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListNames(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-333-3333"};
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-222-2222"};

        //When
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
        String expected = name2 + "\n" + name + "\n";
        String actual = phoneBook.listNames();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveRecord(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String[] number = new String[]{"302-555-5555","302-333-3333"};
        String name2 = "Bob";
        String[] number2 = new String[]{"302-444-4444","302-222-2222"};
        phoneBook.add(name, number);
        phoneBook.add(name2, number2);

        //When
        phoneBook.removeRecord(name2);
        String expected = name + " " + number[0] + ", " + number[1] + "\n";
        String actual = phoneBook.listNamesAndNumbers();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
