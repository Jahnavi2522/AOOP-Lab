// CounterState.java
public class CounterState {
    private int count;

    public CounterState() {
        this.count = 0;
    }

    public CounterState(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CounterState that = (CounterState) o;

        return count == that.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
