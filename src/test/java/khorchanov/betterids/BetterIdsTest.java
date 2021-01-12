package khorchanov.betterids;

import org.junit.jupiter.api.Test;

class BetterIdsTest {

    @Test
    public void test(){
        BetterIds.shuffle(10);
        int id = 213540698;
        assert (BetterIds.toId(BetterIds.fromId(id)) == id);
        String encoded = "hello";
        assert (BetterIds.fromId(BetterIds.toId(encoded)).equals(encoded));
    }
}