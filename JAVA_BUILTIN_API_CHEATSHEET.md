# Java Built-in API Field Guide

Every JDK method and property actually used across all 222 `.java` files in `src/` — deduplicated and grouped by class, for quick interview revision.

**Coverage:** Array (42), BinarySearch/BinarySearchTree/Tries (31), BinaryTree (30), DP (35), Graph/Heap (27), LinkedList/Recursion/SlidingWindowAndTwoPointer/StackQueue (56). User-defined classes/methods (e.g. `ListNode`, custom `Solution` helpers) are excluded — this is JDK API surface only.

**Notably absent anywhere in the codebase:** `java.util.stream`, `Comparator.comparingInt`-style static factories, `LinkedHashMap`/`LinkedHashSet`, `Objects`, and the standalone `Stack` class (its role is played by `ArrayDeque` throughout).

---

## `String` — `java.lang`

| Method | Note |
|---|---|
| `s.length()` | char count |
| `s.charAt(i)` | indexed char |
| `s.toCharArray()` | to `char[]` |
| `s.substring(a[, b])` | slice |
| `s.split(regex)` | tokenize |
| `s.equals(o)` | content compare |
| `s.compareTo(o)` | lexicographic |
| `s.isEmpty()` | `""` check |
| `String.valueOf(x)` | `char[]`/`int` → `String` |
| `new String(char[])` | build from chars |

## `StringBuilder` — `java.lang`

| Method | Note |
|---|---|
| `new StringBuilder([s])` | ctor |
| `sb.append(x)` | chainable |
| `sb.toString()` | materialize |
| `sb.length()` | size |
| `sb.isEmpty()` | |
| `sb.setLength(n)` | truncate / backtrack |
| `sb.reverse()` | |
| `sb.charAt(i)` | |
| `sb.setCharAt(i, c)` | |

## `Math` — `java.lang`

| Method | Note |
|---|---|
| `Math.max(a, b)` | |
| `Math.min(a, b)` | |
| `Math.abs(x)` | |
| `Math.ceil(x)` | |

## `Integer` / wrappers — `java.lang`

| Method | Note |
|---|---|
| `Integer.MAX_VALUE` | sentinel |
| `Integer.MIN_VALUE` | sentinel |
| `Integer.compare(a, b)` | comparator body |
| `Integer.parseInt(s)` | |
| `Integer.toString(i)` | |
| `Integer::sum` | `BiFunction` for `map.merge()` |

## `Character` — `java.lang`

| Method | Note |
|---|---|
| `Character.isDigit(c)` | |
| `Character.isLetterOrDigit(c)` | |

## `System` & array property — `java.lang`

| Method | Note |
|---|---|
| `arr.length` | 1D / 2D — everywhere |
| `System.arraycopy(src, sp, dst, dp, len)` | row copy, space-opt DP |
| `System.out.print(x)` / `println(x)` | |

## `Arrays` — `java.util`

| Method | Note |
|---|---|
| `Arrays.sort(arr)` | |
| `Arrays.sort(arr, cmp)` | object / 2D arrays |
| `Arrays.fill(arr, v)` | sentinel init, e.g. `-1` |

## `Collections` — `java.util`

| Method | Note |
|---|---|
| `Collections.reverse(list)` | |
| `Collections.sort(list)` | |
| `Collections.sort(list, cmp)` | |

## `List` / `ArrayList` — `java.util`

| Method | Note |
|---|---|
| `new ArrayList<>()` | |
| `new ArrayList<>(coll)` | copy-ctor / snapshot |
| `list.add(e)` | |
| `list.addAll(coll)` | |
| `list.get(i)` | |
| `list.set(i, v)` | |
| `list.remove(i)` | backtracking pop |
| `list.size()` | |
| `list.isEmpty()` | |
| `list.sort(cmp)` | |
| `List.of(...)` | immutable factory |

## `Map` / `HashMap` / `TreeMap` — `java.util`

| Method | Note |
|---|---|
| `new HashMap<>()` | |
| `new TreeMap<>([cmp])` | sorted keys |
| `map.put(k, v)` | |
| `map.get(k)` | |
| `map.getOrDefault(k, d)` | |
| `map.containsKey(k)` | |
| `map.computeIfAbsent(k, fn)` | |
| `map.merge(k, v, fn)` | `null` return removes key |
| `map.values()` | |
| `map.entrySet()` | |
| `entry.getKey()` / `entry.getValue()` | |
| `map.size()` | |

## `Set` / `HashSet` — `java.util`

| Method | Note |
|---|---|
| `new HashSet<>()` | |
| `new HashSet<>(coll)` | dedupe a `List` |
| `set.add(e)` | |
| `set.contains(e)` | |
| `set.remove(e)` | |

## `Queue` / `Deque` / `ArrayDeque` — `java.util`

| Method | Note |
|---|---|
| `new ArrayDeque<>()` | doubles as stack or queue |
| `new LinkedList<>()` | as `Queue`, BFS |
| `dq.push(e)` / `dq.pop()` | stack semantics |
| `q.offer(e)` / `q.poll()` | queue semantics |
| `peek()` | |
| `isEmpty()` | |
| `size()` | |

## `PriorityQueue` — `java.util`

| Method | Note |
|---|---|
| `new PriorityQueue<>()` | min-heap, natural order |
| `new PriorityQueue<>((a, b) -> ...)` | custom order, e.g. max-heap |
| `pq.offer(x)` | |
| `pq.poll()` | |
| `pq.peek()` | |
| `pq.isEmpty()` | |
| `pq.size()` | |
