package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }


    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }
    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size();) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            queue.add(val);
            stack.push(val);
        }
        boolean ok = true;

        for (int i = 0; i < size; i++) {
            int qVal = queue.remove();
            int sVal = stack.pop();

            if (qVal != sVal) ok = false;

            queue.add(qVal);
        }

        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            stack.push(queue.poll());
        }
        for (int i = 0; i < size; i++) {
            queue.offer(stack.pop());
        }
        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val >= 0) {
                stack.push(val);
            } else {
                queue.offer(val);
            }
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }


    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> buffer = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x % 2 == 0) {
                queue.add(x);
            } else {
                buffer.addLast(x);
            }
        }
        while (!buffer.isEmpty()) {
            queue.add(buffer.removeFirst());
        }
    }
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max)
                max = s.length();
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        set.retainAll(new HashSet<>(list2));
        return set.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String v : map.values()) {
            if (!values.add(v)) return false; // повторення
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            result.put(e.getValue(), e.getKey()); // якщо дубль — один перезапише інший
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int val : map.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;

        for (int val : freq.keySet()) {
            int f = freq.get(val);
            if (f < minFreq || (f == minFreq && val < best)) {
                minFreq = f;
                best = val;
            }
        }
        return best;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : list) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        for (int c : freq.values()) {
            if (c > max) max = c;
        }

        return max;
    }

}
