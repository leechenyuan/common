package me.leechenyuan.common.gossip;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by L on 17/1/16.
 */
public class GossipTest {
    @Test
    public void regexText(){
        String text =
                "[2]/text()"
//                "[2]"
                ;
        String regex = "\\[\\d+\\]/{1,2}.*";
        boolean isMath = Pattern.matches(regex,text);

    }
}
