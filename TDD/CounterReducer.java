// CounterReducer.java
public class CounterReducer {

    public enum ActionType {
        INCREMENT,
        DECREMENT,
        RESET
    }

    public static CounterState reduce(CounterState state, ActionType action) {
        switch (action) {
            case INCREMENT:
                return new CounterState(state.getCount() + 1);
            case DECREMENT:
                return new CounterState(state.getCount() - 1);
            case RESET:
                return new CounterState(0);
            default:
                return state;
        }
    }
}
