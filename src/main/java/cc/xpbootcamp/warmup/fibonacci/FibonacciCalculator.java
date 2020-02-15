package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {

    public Long calculate(int position){
        if(position == 1 || position == 2){
            return 1L;
        }
        return calculate(position - 2) + calculate(position - 1);
    }
}
