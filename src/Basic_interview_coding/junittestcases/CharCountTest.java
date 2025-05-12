package Basic_interview_coding.junittestcases;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharCountTest {

    @Test
    public void testCountCharactersInEachWord() {
        List<String> list1 = Arrays.asList("Hello", "World", "Java", "Programming");
        Map<Object, Long> result = list1.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        assertEquals(2, result.get(5)); // "Hello" and "World" have 5 characters
        assertEquals(1, result.get(4)); // "Java" has 4 characters
        assertEquals(1, result.get(11)); // "Programming" has 11 characters
    }

    @Test
    public void testCountOccurrencesOfEachWord() {
        List<String> list2 = Arrays.asList("Hello", "World", "Java", "Programming", "Java", "Programming");
        Map<Object, Long> result = list2.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        assertEquals(1, result.get("Hello"));
        assertEquals(1, result.get("World"));
        assertEquals(2, result.get("Java"));
        assertEquals(2, result.get("Programming"));
    }

    @Test
    public void testCountOccurrencesOfEachCharacter() {
        String str = "Sagar Agrawal, Senior Software Engineer";
        Map<Object, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        assertEquals(5, result.get('a'));
        assertEquals(4, result.get('e'));
        assertEquals(3, result.get('S'));
        assertEquals(1, result.get(','));

    }
}