import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterStateTest {

    @Test
    void shouldInitializeWithZeroCount() {
        CounterState state = new CounterState();
        assertEquals(0, state.getCount(), "Initial count should be zero");
    }

    @Test
    void shouldInitializeWithGivenCount() {
        int initialCount = 5;
        CounterState state = new CounterState(initialCount);
        assertEquals(initialCount, state.getCount(), "Initial count should match the given value");
    }

    @Test
    void shouldSetCount() {
        CounterState state = new CounterState();
        int newCount = 10;
        state.setCount(newCount);
        assertEquals(newCount, state.getCount(), "Count should be updated to the new value");
    }

    @Test
    void shouldReturnTrueForEqualStates() {
        CounterState state1 = new CounterState(5);
        CounterState state2 = new CounterState(5);
        assertEquals(state1, state2, "Two states with the same count should be equal");
    }

    @Test
    void shouldReturnFalseForDifferentStates() {
        CounterState state1 = new CounterState(5);
        CounterState state2 = new CounterState(10);
        assertNotEquals(state1, state2, "Two states with different counts should not be equal");
    }

    @Test
    void shouldHaveSameHashCodeForEqualStates() {
        CounterState state1 = new CounterState(5);
        CounterState state2 = new CounterState(5);
        assertEquals(state1.hashCode(), state2.hashCode(), "Equal states should have the same hash code");
    }

    @Test
    void shouldHaveDifferentHashCodesForDifferentStates() {
        CounterState state1 = new CounterState(5);
        CounterState state2 = new CounterState(10);
        assertNotEquals(state1.hashCode(), state2.hashCode(), "Different states should have different hash codes");
    }
}
