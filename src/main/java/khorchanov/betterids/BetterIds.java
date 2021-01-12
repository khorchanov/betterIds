package khorchanov.betterids;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public final class BetterIds {

    private static String grammar = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN0123456789";
    private static final int base = grammar.length();
    public static final String EMPTY_STRING = "";

    public static void shuffle(int secret) {
        Random r = new Random(secret);
        List<String> list = Arrays.asList(grammar.split(EMPTY_STRING));
        Collections.shuffle(list, r);
        StringJoiner joiner = new StringJoiner(EMPTY_STRING);
        list.forEach(joiner::add);
        grammar = joiner.toString();
    }

    public static final String fromId(long id) {
        long quotient = id / base;
        int remainder = (int) (id % base);
        if (quotient == 0) {
            return String.valueOf(grammar.charAt(remainder));
        } else {
            return fromId(quotient) + grammar.charAt(remainder);
        }
    }

    public static final int toId(String num) {
        int val = 0;
        int power = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = grammar.indexOf(num.charAt(i));
            val += digit * power;
            power = power * base;
        }
        return val;
    }
}
