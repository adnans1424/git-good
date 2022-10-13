import java.util.Iterator;

public class FibonacciGenerator implements Iterator<Integer> {
    private int max;
    private int n = 0;
    private int a = 0;
    private int b = 1;

    FibonacciGenerator(int max) {
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        return n < max;
    }

    @Override
    public Integer next() {
        int x;
        if (n == 0)
            x = 0;
        else
            x = a + b;

        a = b;
        b = x;
        n++;
        return x;

    }
}
