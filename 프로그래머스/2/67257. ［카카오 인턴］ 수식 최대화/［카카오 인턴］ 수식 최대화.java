import java.util.*;
class Solution {
    public long solution(String expression) {
        List<Character> operators = Arrays.asList('+', '-', '*');
        Set<List<Character>> operatorPermutations = generateOperatorPermutations(operators);

        long maxPrize = 0;
        for (List<Character> permutation : operatorPermutations) {
            long prize = calculateExpression(expression, permutation);
            maxPrize = Math.max(maxPrize, prize);
        }
        return maxPrize;
    }

    private Set<List<Character>> generateOperatorPermutations(List<Character> operators) {
        Set<List<Character>> permutations = new HashSet<>();
        boolean[] visited = new boolean[operators.size()];
        List<Character> current = new ArrayList<>();
        generateHelper(operators, permutations, visited, current);
        return permutations;
    }

    private void generateHelper(List<Character> operators, Set<List<Character>> permutations, boolean[] visited, List<Character> current) {
        if (current.size() == operators.size()) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(operators.get(i));
                generateHelper(operators, permutations, visited, current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    private long calculateExpression(String expression, List<Character> operators) {
        String[] operands = expression.split("[+\\-*]");
        List<Long> numbers = new ArrayList<>();
        for (String operand : operands) {
            numbers.add(Long.parseLong(operand));
        }

        List<Character> operations = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operations.add(c);
            }
        }

        for (char op : operators) {
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i) == op) {
                    long num1 = numbers.get(i);
                    long num2 = numbers.get(i + 1);
                    long result = applyOperation(num1, num2, op);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, result);
                    operations.remove(i);
                    i--;
                }
            }
        }

        return Math.abs(numbers.get(0));
    }

    private long applyOperation(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}