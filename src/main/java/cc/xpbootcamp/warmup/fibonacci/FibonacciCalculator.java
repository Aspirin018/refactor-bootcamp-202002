package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {

    public long calculate(int position){
        if(position < 1 || position > 50) {
            throw new IllegalArgumentException(" illegal position.");
        }
        if(position == 1 || position == 2){
            return 1;
        }
        return calculate(position - 2) + calculate(position - 1);
    }
}
