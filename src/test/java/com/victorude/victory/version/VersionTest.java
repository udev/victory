package com.victorude.victory.version;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @BeforeAll
    static void setLogLevel() {
        Version.setTestLogLevel(Level.FINE);
    }

    @Test
    void compareMajorOrdinal() {
        int result;
        Version majorLess = new Version("1.0.0");
        Version majorMore = new Version("2.0.0");

        // major ordinal test
        result = majorLess.compare(majorMore);
        assertEquals(-1, result, "major: less than comparison failed");
        result = majorMore.compare(majorLess);
        assertEquals(1, result, "major: greater than comparison failed");
    }

    @Test
    void compareMinorOrdinal() {
        int result;
        Version minorLess = new Version("1.1.0");
        Version minorMore = new Version("1.2.0");

        // minor ordinal test
        result = minorLess.compare(minorMore);
        assertEquals(-1, result, "minor: less than comparison failed");
        result = minorMore.compare(minorLess);
        assertEquals(1, result, "minor: greater than comparison failed");
    }

    @Test
    void comparePatchOrdinal() {
        int result;
        Version patchLess = new Version("1.1.1");
        Version PatchMore = new Version("1.1.2");

        // patch ordinal test
        result = patchLess.compare(PatchMore);
        assertEquals(-1, result, "patch: less than comparison failed");
        result = PatchMore.compare(patchLess);
        assertEquals(1, result, "patch: greater than comparison failed");
    }

    @Test
    void comparePreReleaseOrdinal() {
        int result;
        Version preReleaseLess = new Version("1.1.1-alpha");
        Version preReleaseMore = new Version("1.1.1-beta");

        // pre-release ordinal test
        result = preReleaseLess.compare(preReleaseMore);
        assertEquals(-1, result, "pre-release: less than comparison failed");
        result = preReleaseMore.compare(preReleaseLess);
        assertEquals(1, result, "pre-release: greater than comparison failed");
    }

    @Test
    void compareMissingVersion() {
        int result;
        Version missingVersion = new Version("");

        // missing version test
        result = missingVersion.compare(new Version("1"));
        assertEquals(-1, result, "missing version comparison failed");
    }

    @Test
    void compareUnicode() {
        int result;
        Version unicodeVersion = new Version("一.二.三");

        // unicode test
        result = unicodeVersion.compare(new Version("三.二.一"));
        assertEquals(-1, result, "unicode version comparison failed");
    }

    @Test
    void compareEmoji() {
        int result;

        // emoji test
        result = new Version("💩.🎃.🥧").compare(new Version("👀.💦.🤪"));
        assertEquals(1, result, "unicode version comparison failed");
    }

    @Test
    void compareNull() {
        String version = "1.0.1";
        Version equal = new Version(version);

        // pass an illegal argument
        assertThrows(IllegalArgumentException.class,
                () -> equal.compare(new Version(null)));
    }

    @Test
    void compare() {
        int result;
        String equalString = "1.2.3.4";
        Version equal = new Version(equalString);

        // equality test
        result = equal.compare(new Version(equalString));
        assertEquals(0, result, "equals comparison failed");
    }

    @Test
    void equals() {
        String equalString = "1.2.3.4";
        Version equal = new Version(equalString);
        assertTrue(equal.equals(new Version(equalString)), "versions should be equal");
        assertFalse(equal.equals(new Version(equalString + "1")), "versions should not be equal");
    }
}