package edu.course.lab01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CourseToolkitTest {

    // ===== isEven =====

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);
        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);
        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);
        assertTrue(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);
        assertTrue(result);
    }

    // ===== isPrime =====

    @Test
    void isPrimeReturnsFalseForNumberLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
        assertFalse(CourseToolkit.isPrime(-5));
    }

    @Test
    void isPrimeReturnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(13));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void isPrimeReturnsFalseForSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    // ===== isPalindrome =====

    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("hello"));
    }

    @Test
    void isPalindromeRespectsCaseAndSpaces() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
        assertFalse(CourseToolkit.isPalindrome("ab a"));
    }

    @Test
    void isPalindromeThrowsForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null));
    }

    // ===== average =====

    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{2, 3}), 0.0001);
    }

    @Test
    void averageHandlesNegativeNumbers() {
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -3}), 0.0001);
    }

    @Test
    void averageDoesNotMutateArray() {
        int[] values = {1, 2, 3};
        CourseToolkit.average(values);
        assertArrayEquals(new int[]{1, 2, 3}, values);
    }

    @Test
    void averageThrowsForNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{}));
    }
}