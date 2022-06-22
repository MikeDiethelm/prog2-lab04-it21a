/*
 * Test Class for Heart
 */
package ch.zhaw.prog2.heartbeat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ch.zhaw.prog2.heartbeat.parts.Valve;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch.zhaw.prog2.heartbeat.Heart.State;

class HeartTest {
    /**
     * This is a very simple test to check if Junit and Mockito are properly set up.
     */
    @Test
    void testTheTest() {
        Heart classUnderTest = new Heart();
        assertNotNull(classUnderTest.getState(), "The heart must have a state.");
    }

    /**
     * Tests a single heartbeat
     */
    @Test
    void testHeartBeat() throws Heart.HeartBeatDysfunctionException {
        Heart heart = new Heart();
        State startState = heart.getState();

        heart.executeHeartBeat();

        // after one heartbeat, the heart must be in the same state as before
        assertEquals(startState, heart.getState());
    }

    /**
     * Tests if the valves are open or closed depending on the status of the heart
     */
    @Test
    void testValveStatus() throws Heart.HeartBeatDysfunctionException {
        Heart heart = new Heart();

        heart.executeHeartBeat();

        State state = heart.getState();

        if (state.equals(Heart.State.DIASTOLE)) {
            for (Half half : heart.getHalves()) {
                assertFalse(half.isAtrioventricularValveOpen());
                assertTrue(half.isSemilunarValveOpen());
            }
        } else if ((state.equals(Heart.State.SYSTOLE))) {
            for (Half half : heart.getHalves()) {
                assertTrue(half.isAtrioventricularValveOpen());
                assertFalse(half.isSemilunarValveOpen());
            }
        }
    }

    /**
     * Tests if the hart throws the appropriate Exception, when malfunction was detected during hartBeat
     */
    @Test
    void testExecuteHeartBeatErrorBehaviour() {
        Heart heart = new Heart();
        // prepare error situation due to wrong initialization
        heart.setState(State.SYSTOLE);

        assertThrows(Heart.HeartBeatDysfunctionException .class, // verification using lambda
            () -> heart.executeHeartBeat());
    }

    /**
     * Tests if the hart throws the appropriate Exception, when malfunction was detected during hartBeat
     * with exception Stubbing
     */
    @Test
    void testExecuteHartBeatErrorBehaviourWithStubbing() throws Valve.IllegalValveStateException {
        //TODO implement
        fail();
    }

    /**
     * We test if Heart::executeHeartbeat() sends the right signals to both of its
     * halves.
     *
     * When Half::contractVentricle() is called, Half::closeAtrioventricularValve()
     * and Half::openSemilunarValve() must have been called earlier.
     *
     */
    @Test
    void testValvesBehavior() {
        //TODO implement
        fail();
    }

}
