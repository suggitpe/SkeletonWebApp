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
        assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
//    assertThat(queryProcessor.process(""), equalTo(""));
    }

}
