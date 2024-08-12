// CounterReducerTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterReducerTest {

    @Test
    void shouldReturnInitialStateWhenUnknownActionIsPassed() {
        CounterState initialState = new CounterState(0);
        CounterState newState = CounterReducer.reduce(initialState, null); // Simulate unknown action
        assertEquals(initialState, newState);
    }

    @Test
    void shouldHandleIncrementAction() {
        CounterState initialState = new CounterState(0);
        CounterState newState = CounterReducer.reduce(initialState, CounterReducer.ActionType.INCREMENT);
        assertEquals(new CounterState(1), newState);
    }

    @Test
    void shouldHandleDecrementAction() {
        CounterState initialState = new CounterState(1);
        CounterState newState = CounterReducer.reduce(initialState, CounterReducer.ActionType.DECREMENT);
        assertEquals(new CounterState(0), newState);
    }

    @Test
    void shouldHandleResetAction() {
        CounterState initialState = new CounterState(10);
        CounterState newState = CounterReducer.reduce(initialState, CounterReducer.ActionType.RESET);
        assertEquals(new CounterState(0), newState);
    }

    @Test
    void shouldNotMutateState() {
        CounterState initialState = new CounterState(0);
        CounterState newState = CounterReducer.reduce(initialState, CounterReducer.ActionType.INCREMENT);
        assertNotSame(initialState, newState); // Ensure that the state is not mutated
    }
}
