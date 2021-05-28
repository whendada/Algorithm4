package Unit1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * P80
 * Dijkstra 双栈算术表达式求值法
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.add(s);
            else if (s.equals("-")) ops.add(s);
            else if (s.equals("*")) ops.add(s);
            else if (s.equals("/")) ops.add(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                //弹出的第一个数
                double v = vals.pop();
                //弹出的第二个数，然后再 push 回去
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                vals.push(v);
            }
            //既不是操作符也不是右括号，则作为值 push 到栈
            else vals.push(Double.parseDouble(s));
        }
        StdOut.print(vals.pop());
    }
}
