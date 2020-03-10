package com.nkosinathi;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAssertMap() {
        Map<String, String> countries = new HashMap<String, String>();
        countries.put("India", "New Delhi");
        countries.put("UK", "London");
        
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("India", "New Delhi");
        expected.put("UK", "London");

        //1. Test equal, ignore order
        assertThat(countries, is(expected));

        //2. Test size
        assertThat(countries.size(), is(2));

        //3. Test map entry, best!
        assertThat(countries, IsMapContaining.hasEntry("India", "New Delhi"));

        //4. Test map key
        assertThat(countries, IsMapContaining.hasKey("UK"));

        //5. Test map value
        assertThat(countries, IsMapContaining.hasValue("London"));

    }

    @Test
    public void testAssertList(){
        List<String> contents = new ArrayList<String>();

        contents.add("Example");
        contents.add("Tutorial");
        contents.add("Program");

        List<String> expected = new ArrayList<String>();

        expected.add("Example");
        expected.add("Tutorial");
        expected.add("Program");

        //1. Test equal
        assertThat(contents, is(expected));

        //2. If lis has the value
        assertThat(contents, hasItems("Tutorial"));

        //3. Check list size
        assertThat(contents, hasSize(3));

        //4. List order
        // Ensure Correct order
        assertThat(contents, contains("Example", "Tutorial","Program"));

        // Can be any order
        assertThat(contents, containsInAnyOrder("Tutorial", "Program", "Example"));

        //5. check empty list
        assertThat(contents, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

    }

    @Test
    public void testAssertSet(){
        //my set is created from the string contents
        List<String> contents = new ArrayList<String>();

        contents.add("Example");
        contents.add("Tutorial");
        contents.add("Program");

        Set<String> readOnlySet = new HashSet<String>(contents);

        assertThat(new AppTest().equals(contents, readOnlySet), is(true));

    }

    private Boolean equals(List<String> contents, Set<String> readOnlySet) {
        if(contents == null || readOnlySet ==null){
            return false;
        }

        if(contents.size()!=readOnlySet.size()){
            return false;
        }

        return contents.containsAll(readOnlySet);
    }


}
