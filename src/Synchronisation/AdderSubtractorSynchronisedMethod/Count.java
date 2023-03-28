package Synchronisation.AdderSubtractorSynchronisedMethod;

public class Count {
    private int count = 0;

    // implement multi-threading in the class itself
    public synchronized void incrementCount(int offset) {
        this.count += offset;
    }

    public int getCount() {
        return this.count;
    }
}
