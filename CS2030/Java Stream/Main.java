import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.function.Function;

class Main {

    static boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, n).noneMatch(x -> n % x == 0);
    }

    static IntStream twinPrimes(int n) {
        return IntStream.iterate(2, x -> x + 1).limit(n - 1)
            .filter(x -> isPrime(x))
            .filter(x -> isPrime(x - 2) || isPrime(x + 2));
    }

    static String reverse(String str) {
        return Stream.<String>of(str.split(""))
            .reduce("", (a, b) -> b + a);
    }

    static long countRepeats(List<Integer> list) {
        return IntStream.range(0, list.size() - 1)
            .filter(x -> list.get(x).equals(list.get(x + 1))
                    ? x == 0
                        ? true
                        : !list.get(x).equals(list.get(x - 1))
                    : false)
            .count();
    }

    static UnaryOperator<List<Integer>> generateRule() {

        return (List<Integer> list) -> {
            IntStream streamIndexStore = IntStream.iterate(0, i -> i + 1).limit(list.size());
            
            IntStream ruleApplication = streamIndexStore.map((index) -> {

                // left end with neighbour != 0
                if (index == 0 && list.get(1) == 0) {
                    return 0;
                }
                
                // left end alive, neighbour alive
                if (index == 0 && list.get(index) == 1 && list.get(1) == 1) {
                    return 0;
                }

                //left end and check right only
                if (index == 0 && list.get(1) == 1) {
                    return 1;
                }

                // right end with neighbour != 0
                if (index == list.size() - 1 && list.get(list.size() - 2) == 0) {
                    return 0;
                }

                // right end alive, neighbour alive
                if (index == list.size() - 1 && list.get(index) == 1 && 
                        list.get(list.size() - 2) == 1) {
                    return 0;
                }

                // right and check left only
                if (index == list.size() - 1 && list.get(list.size() - 2) == 1) {
                    return 1;
                }

                // when cell is 0 and there is only 1 alive neighbouring cell
                if (list.get(index) == 0 && (list.get(index - 1) + list.get(index + 1) == 1)) {
                    return 1;
                }

                // when cell is 1;
                if (list.get(index) == 1) {
                    return 0;
                }

                return list.get(index);
            });

            return ruleApplication.boxed().toList();
        };
    }
    
     
    static Stream<String> gameOfLife(List<Integer> list, UnaryOperator<List<Integer>> rule, int n) {
        Stream<List<Integer>> result = Stream.iterate(list, (row) -> rule.apply(row)).limit(n);
        Stream<String> res = result.map(row -> {
            return row.stream()
                .map(cell -> cell == 1 ? "x" : ".")
                .reduce("", (x, y) -> x + y);
        });
        return res;
    }
    
}
