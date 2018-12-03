package com.victorude.victory.version;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * This class wraps a {@link String} semantic version and provides methods for comparing
 * against another Version instance.
 */
public class Version {

    /**
     * In memory representation of the semantic version string. ex: "1.2.3"
     */
    private final String version;

    /**
     * Pattern used to differentiate between integer and string ordinals.
     */
    private static final Pattern IS_INTEGER = Pattern.compile("\\d+");
    
    private static Logger logger;

    static {
        setTestLogLevel(Level.INFO);
    }

    /**
     * Creates a new {@link Version} instance.
     *
     * @param versionString the version information to store for comparison in the future.
     * @since 0.1.0
     */
    public Version(@NotNull String versionString) {
        this.version = versionString;
    }

    /**
     * Simple {@link String} comparison of two versions.
     *
     * @param other the {@link Version} to compare with this Version instance.
     * @return true if the versions match else false.
     * @since 0.1.0
     */
    public boolean equals(@NotNull Version other) {
        return this.version.equals(other.version);
    }

    /**
     * Compare two {@link Version} instances.
     *
     * @param other the {@link Version} to compare with this Version instance.
     * @return the value {@code 0} if this {@code Version} is
     * equal to the argument {@code Version}; a value less than
     * {@code 0} if this {@code Version} is numerically less
     * than the argument {@code Version}; and a value greater
     * than {@code 0} if this {@code Version} is numerically
     * greater than the argument {@code Version}.
     * @since 0.1.0
     */
    public int compare(@NotNull Version other) {

        //best case versions are exactly equal
        if (this.equals(other)) {
            return 0;
        }

        String[] versionArray = this.version.split("\\.");
        String[] otherArray = other.version.split("\\.");
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        Collections.addAll(s1, versionArray);
        Collections.addAll(s2, otherArray);

        Iterator<String> iter1 = s1.iterator();
        Iterator<String> iter2 = s2.iterator();

        while (iter1.hasNext() && iter2.hasNext()) {
            int comparison;
            String next1 = iter1.next();
            String next2 = iter2.next();
            if (ordinalsAreIntegers(next1, next2)) {
                // compare two integer ordinals
                comparison = Integer.valueOf(next1).compareTo(Integer.valueOf(next2));
            } else {
                // compare ordinals as strings
                comparison = getTypeResult(next1, next2);
            }
            if (comparison > 0) {
                logger.fine(String.format("This version is greater: %s > %s", this.version, other.version));
                return 1;
            } else if (comparison < 0) {
                logger.fine(String.format("Other version is greater: %s < %s", this.version, other.version));
                return -1;
            }
        }

        // case where version is equal up to provided ordinals but one has additional ordinals
        if (versionArray.length > otherArray.length) {
            logger.fine(String.format("This version is greater with outstanding ordinal: %s > %s", this.version, other.version));
            return 1;
        } else if (versionArray.length < otherArray.length) {
            logger.fine(String.format("Other version is greater with outstanding ordinal: %s < %s", this.version, other.version));
            return -1;
        }

        //versions must be exactly equal
        logger.fine(String.format("Versions must be exactly equal: %s > %s", this.version, other.version));
        return 0;
    }

    /**
     * Used to compare {@link String} version ordinals.
     * @param next1 ordinal from the {@link Version} that called {@link Version#compare(Version)}
     * @param next2 ordinal from the {@link Version} passed as an argument to {@link Version#compare(Version)}
     * @return the value {@code 0} if the {@link Version#compare(Version)} call originator {@code Version} is
     * equal to the argument {@code Version}; a value less than
     * {@code 0} if the originator {@code Version} is numerically less
     * than the argument {@code Version}; and a value greater
     * than {@code 0} if the originator {@code Version} is numerically
     * greater than the argument {@code Version}.
     * @since 0.1.0
     */
    private static int getTypeResult(String next1, String next2) {
        int result;
        if (IS_INTEGER.matcher(next1).matches()) {
            result = 1;
        } else if (IS_INTEGER.matcher(next2).matches()) {
            result = -1;
        } else {
            return next1.compareTo(next2);
        }
        return result;
    }

    /**
     * Determines if the provided {@link Version} ordinals are {@link Integer} or {@link String} values.
     * @param next1 ordinal from the {@link Version} that called {@link Version#compare(Version)}
     * @param next2 ordinal from the {@link Version} passed as an argument to {@link Version#compare(Version)}
     * @return true if both arguments are integers else false.
     */
    private boolean ordinalsAreIntegers(String next1, String next2) {
        return IS_INTEGER.matcher(next1).matches() && IS_INTEGER.matcher(next2).matches();
    }

    /**
     * Output comparison information to the console using standard log {@link Level}.
     * @param level Log {@link Level} to display output.
     * @see Level
     */
    public static void setTestLogLevel(Level level) {
        String loggerName = "com.victorude.victory";
        logger = Logger.getLogger(loggerName);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(level);
        logger.addHandler(handler);
        logger.setLevel(level);
    }
}
