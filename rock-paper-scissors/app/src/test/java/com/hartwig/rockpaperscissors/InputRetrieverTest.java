package com.hartwig.rockpaperscissors;

import org.junit.Test;
import static org.junit.Assert.*;
import com.hartwig.rockpaperscissors.cli.BooleanInputRetriever;


public class InputRetrieverTest {
	@Test 
    public void checkBooleanInputRetrieverHasValidInputs() {
        BooleanInputRetriever booleanInputRetriever = new BooleanInputRetriever();
        assertNotNull("Retriever should have valid options", booleanInputRetriever.validOptions());
    }

    @Test 
    public void checkValidBooleanInputRetrieverInputs() {
        BooleanInputRetriever booleanInputRetriever = new BooleanInputRetriever();
        for (String option : booleanInputRetriever.validOptions()) {
        	assertTrue(option + " is a valid option", booleanInputRetriever.validInput(option));
        	
        }
    }

    //todo fill below 2 tests for MoveInputInterpreter

}
