package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_21_AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            }
            else if (asteroid < 0) {
                // asteroid is negative
                // destroy all the asteroids which have lower positive value than the current asteroid's absolute value
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                // if the stack top has positive value and current asteroid has equal absolute value,
                // then both will destroy each other
                // we don't need to insert into the stack
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
                // if all the asteroid has been destroyed or asteroid is moving to same opposite direction
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                // if asteroid is negative and stack.peek() > abs(asteroid)
                // this asteroid will be destroyed and will not be inserted into the stack
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i=size-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
