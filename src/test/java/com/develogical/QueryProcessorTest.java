package com.develogical;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();



    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void allTheTests() throws Exception {
        assertThat(queryProcessor.process("What is 27 plus 10"), equalTo("37"));
//        assertThat(queryProcessor.process("Which of the following numbers is the largest: 70, 34, 62?"), equalTo("70"));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
    }

}
