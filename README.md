# Java Built-in API Field Guide

> **StriverJavaA2Z · interview revision**

Every JDK method and property actually used across **222 LeetCode solutions** in `src/` — deduplicated and grouped by class. Each entry shows a runnable example (parameters, then calls with their `→` outputs) and common interview use cases.

## Contents

- [String](#string) · `java.lang`
- [StringBuilder](#stringbuilder) · `java.lang`
- [Math](#math) · `java.lang`
- [Integer / wrappers](#integer--wrappers) · `java.lang`
- [Character](#character) · `java.lang`
- [System & array property](#system--array-property) · `java.lang`
- [Arrays](#arrays) · `java.util.Arrays`
- [Collections](#collections) · `java.util.Collections`
- [List / ArrayList](#list--arraylist) · `java.util.{List, ArrayList}`
- [Map / HashMap / TreeMap](#map--hashmap--treemap) · `java.util.{Map, HashMap, TreeMap}`
- [Set / HashSet](#set--hashset) · `java.util.{Set, HashSet}`
- [Queue / Deque / ArrayDeque](#queue--deque--arraydeque) · `java.util.{Queue, Deque, ArrayDeque, LinkedList}`
- [PriorityQueue](#priorityqueue) · `java.util.PriorityQueue`

---

## String
`java.lang`

### `s.length()` — char count
```
// returns int — number of chars
s = "abcdefgh"
s.length() → 8
```
**Use cases**
- Loop bounds when scanning a string char by char
- Palindrome check with two pointers (i vs length-1-i)
- Base case for recursion on substrings

### `s.charAt(i)` — indexed char
```
i : int — mandatory (0-based index)
s = "abcdefgh"
s.charAt(0) → 'a'
s.charAt(3) → 'd'
```
**Use cases**
- Comparing characters at two pointers in two-pointer / sliding-window problems
- Building a frequency map of characters
- Checking the current character during DFS/backtracking over a string

### `s.toCharArray()` — to char[]
```
// returns char[]
s = "cba"
s.toCharArray() → ['c','b','a']
```
**Use cases**
- Sorting characters to check anagrams
- In-place-style manipulation that arrays make easier than String
- Feeding a char[] to `Arrays.sort` before comparing two strings

### `s.substring(a[,b])` — slice
```
a : int — mandatory (start, inclusive)
b : int — optional  (end, exclusive)
s = "abcdefgh"
s.substring(3)   → "defgh"
s.substring(3,5) → "de"
```
**Use cases**
- Extracting the sub-problem string for recursive DP (e.g. palindrome partitioning)
- Splitting a string around a delimiter index found during a scan
- Isolating a candidate palindromic substring to validate

### `s.split(regex)` — tokenize
```
regex : String — mandatory (delimiter pattern)
// returns String[]
s = "a,b,c"
s.split(",")  → ["a","b","c"]
"1 2  3".split(" +") → ["1","2","3"]
```
**Use cases**
- Parsing space- or comma-separated input into tokens
- Splitting a sentence into words for word-count / reverse-words problems
- Breaking a path string like "a/b/../c" into components

### `s.equals(o)` — content compare
```
o : Object — mandatory
// returns boolean (compares CONTENT, not reference)
"abc".equals("abc") → true
"abc".equals("abd") → false
```
**Use cases**
- Comparing string contents safely instead of using `==`
- Checking two words are identical while building anagram groups
- Validating parsed tokens against expected keywords

### `s.compareTo(o)` — lexicographic
```
o : String — mandatory
// returns int: <0, 0, or >0
"apple".compareTo("banana") → -1
"b".compareTo("a")          → 1
"a".compareTo("a")          → 0
```
**Use cases**
- Custom comparator body when sorting an array of strings
- Finding lexicographically smallest / largest string among candidates
- Tie-breaking rules in interval / scheduling problems keyed by string fields

### `s.isEmpty()` — "" check
```
// returns boolean (true when length == 0)
"".isEmpty()  → true
"a".isEmpty() → false
```
**Use cases**
- Recursion base case once a substring has been fully consumed
- Guarding against empty tokens after a split
- Early-return validation on function entry

### `String.valueOf(x)` — char[]/int → String
```
x : any (int, char, char[], boolean…) — mandatory
// static; returns String
String.valueOf(42)                  → "42"
String.valueOf(new char[]{'h','i'}) → "hi"
```
**Use cases**
- Converting a computed int result to a String for output
- Turning a char[] back into a String after in-place edits
- Building a hashable key from a numeric or char value

### `new String(char[])` — build from chars
```
char[] — mandatory
// constructor; returns String
new String(new char[]{'h','i'}) → "hi"
```
**Use cases**
- Materializing a final answer after manipulating a char[] in place
- Reconstructing a word from a subset of characters

---

## StringBuilder
`java.lang`

### `new StringBuilder([s])` — ctor
```
s : String — optional (initial content)
new StringBuilder()     → ""
new StringBuilder("ab") → "ab"
```
**Use cases**
- Starting an accumulator for a result string built across many appends
- Seeding with an existing string before reversing or editing it

### `sb.append(x)` — chainable
```
x : any — mandatory; returns the same builder (chainable)
sb = "ab"
sb.append("c")           → "abc"
sb.append('d').append(9) → "abcd9"
```
**Use cases**
- Accumulating chars/tokens in a loop instead of concatenating Strings (avoids O(n²))
- Building the current path in DFS/backtracking over a grid or tree
- Assembling digits during math-to-string conversion

### `sb.toString()` — materialize
```
// returns String snapshot of current content
sb = "abc"
sb.toString() → "abc"
```
**Use cases**
- Finalizing the builder into the return value
- Converting to String to store as a key in a Map/Set

### `sb.length()` — size
```
// returns int
sb = "abc"
sb.length() → 3
```
**Use cases**
- Checking accumulated size before appending a separator
- Loop bound when scanning the builder's current content

### `sb.isEmpty()`
```
// returns boolean (Java 15+)
sb = ""
sb.isEmpty() → true
```
**Use cases**
- Skipping a leading separator on the first append
- Guarding output formatting when nothing has been added yet

### `sb.setLength(n)` — truncate/backtrack
```
n : int — mandatory (new length)
sb = "abcd"
sb.setLength(2) → "ab"
```
**Use cases**
- Undoing the last append during backtracking (cheaper than deleteCharAt)
- Trimming a trailing separator before converting to String

### `sb.reverse()`
```
// reverses in place, returns the builder
sb = "abc"
sb.reverse() → "cba"
```
**Use cases**
- Reversing digits of an integer built as a string
- Reversing words / characters for "reverse string" style problems

### `sb.charAt(i)`
```
i : int — mandatory (index)
sb = "abc"
sb.charAt(1) → 'b'
```
**Use cases**
- Inspecting a character mid-build without materializing a String

### `sb.setCharAt(i,c)`
```
i : int  — mandatory (index)
c : char — mandatory (replacement)
sb = "abc"
sb.setCharAt(1,'X') → "aXc"
```
**Use cases**
- Flipping a single digit/character in place (e.g. carrying an addition)
- Patching one position after a comparison, without rebuilding the whole string

---

## Math
`java.lang`

### `Math.max(a,b)`
```
a, b : int/long/double — mandatory; returns the larger
Math.max(3, 7)   → 7
Math.max(-2, -9) → -2
```
**Use cases**
- Tracking a running maximum in DP transitions (max subarray / profit)
- Expanding a sliding window's right bound
- Picking the larger of two recursive branch results

### `Math.min(a,b)`
```
a, b : int/long/double — mandatory; returns the smaller
Math.min(3, 7) → 3
```
**Use cases**
- Tracking a running minimum (min cost path, buy price for stock problems)
- Clamping an index so it doesn't exceed array bounds

### `Math.abs(x)`
```
x : int/long/double — mandatory; returns |x|
Math.abs(-4) → 4
Math.abs(4)  → 4
```
**Use cases**
- Computing distance / absolute difference between two values
- Normalizing a negative modulo result

### `Math.ceil(x)`
```
x : double — mandatory; returns double rounded UP
Math.ceil(2.1) → 3.0
Math.ceil(2.0) → 2.0
// integer ceil of a/b: (a + b - 1) / b
```
**Use cases**
- Computing binary-search midpoints / bounds that must round up
- Calculating page / group counts from a total split into chunks

---

## Integer / wrappers
`java.lang`

### `Integer.MAX_VALUE` — sentinel
```
// constant int
Integer.MAX_VALUE → 2147483647
int best = Integer.MAX_VALUE; // seed a running min
```
**Use cases**
- Initializing a "running minimum" variable before the first comparison
- Sentinel for "infinity" in shortest-path / DP cost arrays

### `Integer.MIN_VALUE` — sentinel
```
// constant int
Integer.MIN_VALUE → -2147483648
int best = Integer.MIN_VALUE; // seed a running max
```
**Use cases**
- Initializing a "running maximum" variable before the first comparison
- Sentinel for "negative infinity" in max-subarray style DP

### `Integer.compare(a,b)` — comparator body
```
a, b : int — mandatory; returns -1 / 0 / 1 (overflow-safe)
Integer.compare(3, 7) → -1
Integer.compare(7, 3) → 1
Integer.compare(5, 5) → 0
```
**Use cases**
- Body of a lambda comparator when sorting boxed Integer arrays/lists
- Avoiding overflow vs. hand-writing `a-b` in a comparator

### `Integer.parseInt(s)`
```
s : String — mandatory; returns int (throws if non-numeric)
Integer.parseInt("42") → 42
Integer.parseInt("-7") → -7
```
**Use cases**
- Converting a split token from input text into a usable int
- Parsing digits out of a string-based math problem

### `Integer.toString(i)`
```
i : int — mandatory; returns String
Integer.toString(42) → "42"
```
**Use cases**
- Converting a computed int to String for concatenation or output
- Building a hash key that mixes numbers and text

### `Integer::sum` — BiFunction for merge()
```
// method reference == (a,b) -> a + b
Integer.sum(2, 3) → 5
map.merge(k, 1, Integer::sum) // count++ in one call
```
**Use cases**
- Method reference passed to `map.merge(k, 1, Integer::sum)` for frequency counting
- Combining accumulated totals in a reduce-style aggregation

---

## Character
`java.lang`

### `Character.isDigit(c)`
```
c : char — mandatory; returns boolean
Character.isDigit('7') → true
Character.isDigit('a') → false
```
**Use cases**
- Validating characters while parsing numbers embedded in a string
- Skipping / keeping digit characters when filtering a string

### `Character.isLetterOrDigit(c)`
```
c : char — mandatory; returns boolean
Character.isLetterOrDigit('a') → true
Character.isLetterOrDigit('#') → false
```
**Use cases**
- Filtering out punctuation / spaces before a palindrome check ("valid palindrome")
- Validating alphanumeric-only strings

---

## System & array property
`java.lang`

### `arr.length` — 1D / 2D — everywhere
```
// field, not a method — no ()
int[] arr = {5, 6, 7};
arr.length     → 3
int[][] grid = new int[4][6];
grid.length    → 4   // rows
grid[0].length → 6   // cols
```
**Use cases**
- Loop bounds for any array traversal, 1D or 2D (rows / cols)
- Base case / termination check in recursive array processing

### `System.arraycopy(src,sp,dst,dp,len)` — row copy, space-opt DP
```
src : source array      sp : src start index
dst : destination array dp : dst start index
len : count to copy
int[] src = {1,2,3,4};
int[] dst = new int[4];
System.arraycopy(src,1,dst,0,3);
dst → {2,3,4,0}
```
**Use cases**
- Copying a DP row forward when reducing a 2D table to O(n) space
- Fast bulk-copying a row / column out of a 2D grid

### `System.out.print/println(x)`
```
x : any — mandatory
System.out.print("hi")   → hi    // no newline
System.out.println("hi") → hi\n  // with newline
```
**Use cases**
- Debug-printing intermediate state while tracing an algorithm
- Printing the final answer in a driver / main method

---

## Arrays
`java.util.Arrays`

### `Arrays.sort(arr)`
```
arr : array — mandatory; sorts ASCENDING in place
int[] arr = {3, 1, 2};
Arrays.sort(arr);
arr → {1, 2, 3}
```
**Use cases**
- Sorting a primitive array before a two-pointer or greedy pass
- Preparing values for binary search

### `Arrays.sort(arr, cmp)` — object/2D arrays
```
arr : Object[] / 2D array   cmp : Comparator
// NOTE: comparator needs boxed/objects, not int[]
Integer[] a = {3, 1, 2};
Arrays.sort(a, (x, y) -> y - x);  // descending
a → {3, 2, 1}
// intervals sorted by start:
Arrays.sort(iv, (p, q) -> p[0] - q[0]);
```
**Use cases**
- Sorting intervals by start time before a merge-intervals pass
- Sorting a 2D array of pairs (e.g. by second column) for greedy scheduling

### `Arrays.fill(arr, v)` — sentinel init, e.g. -1
```
arr : array   v : fill value — both mandatory
int[] dp = new int[4];
Arrays.fill(dp, -1);
dp → {-1, -1, -1, -1}
```
**Use cases**
- Initializing a memo / DP array to -1 to mark "uncomputed"
- Resetting a visited / distance array before a BFS/DFS run

---

## Collections
`java.util.Collections`

### `Collections.reverse(list)`
```
list : List — mandatory; reverses in place
List<Integer> l = [1, 2, 3];
Collections.reverse(l);
l → [3, 2, 1]
```
**Use cases**
- Reversing a result list built root-to-leaf back into leaf-to-root order
- Reversing a path collected during backtracking before returning it

### `Collections.sort(list)`
```
list : List — mandatory; ascending, in place
List<Integer> l = [3, 1, 2];
Collections.sort(l);
l → [1, 2, 3]
```
**Use cases**
- Sorting a List in natural order before scanning it

### `Collections.sort(list, cmp)`
```
list : List   cmp : Comparator — both mandatory
List<Integer> l = [3, 1, 2];
Collections.sort(l, (a, b) -> b - a);
l → [3, 2, 1]
```
**Use cases**
- Sorting a List of custom objects / pairs by a chosen field
- Applying tie-breaking rules via a multi-key comparator

---

## List / ArrayList
`java.util.{List, ArrayList}`

### `new ArrayList<>()`
```
// empty, growable list
List<Integer> l = new ArrayList<>();
l → []
```
**Use cases**
- Starting an empty result container to fill during traversal
- Building an adjacency-list bucket for a graph node

### `new ArrayList<>(coll)` — copy-ctor / snapshot
```
coll : Collection — mandatory (copies its elements)
new ArrayList<>(List.of(1, 2)) → [1, 2]
res.add(new ArrayList<>(path)); // snapshot in backtracking
```
**Use cases**
- Taking an immutable snapshot of the current backtracking path before adding it to results
- Copying a collection to safely mutate it independently

### `list.add(e)`
```
e : element — mandatory; appends to end
l = [1];
l.add(2);
l → [1, 2]
```
**Use cases**
- Appending to a result list or DFS/backtracking path
- Growing an adjacency-list entry for a graph edge

### `list.addAll(coll)`
```
coll : Collection — mandatory; appends all
l = [1];
l.addAll(List.of(2, 3));
l → [1, 2, 3]
```
**Use cases**
- Merging one sub-result list into an aggregate results list
- Combining neighbor lists during graph construction

### `list.get(i)`
```
i : int — mandatory (index); returns element
l = [10, 20, 30];
l.get(1) → 20
```
**Use cases**
- Random access into a list during DP or two-pointer scans
- Reading a neighbor from an adjacency list during graph traversal

### `list.set(i, v)`
```
i : int (index)   v : new value — both mandatory
l = [1, 2, 3];
l.set(0, 9);
l → [9, 2, 3]
```
**Use cases**
- Updating a DP table cell stored as a List instead of an array
- Overwriting a value in place during simulation

### `list.remove(i)` — backtracking pop
```
i : int — removes by INDEX (not value, for int lists)
l = [1, 2, 3];
l.remove(l.size() - 1); // pop last
l → [1, 2]
```
**Use cases**
- Undoing the last `add` when backtracking out of a DFS branch
- Removing a processed element from a working list

### `list.size()`
```
// returns int
l = [1, 2, 3];
l.size() → 3
```
**Use cases**
- Loop bound when iterating a List
- Checking the current depth of a backtracking path against target length

### `list.isEmpty()`
```
// returns boolean
[].isEmpty()  → true
[1].isEmpty() → false
```
**Use cases**
- Base case check before recursing further
- Guarding against processing an empty adjacency bucket

### `list.sort(cmp)`
```
cmp : Comparator — mandatory; sorts in place
l = [3, 1, 2];
l.sort((a, b) -> a - b);
l → [1, 2, 3]
```
**Use cases**
- Sorting a list in place with a custom comparator before a greedy / two-pointer pass

### `List.of(...)` — immutable factory
```
varargs — returns an IMMUTABLE list (add() throws)
List.of(1, 2, 3) → [1, 2, 3]
int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; // grid moves
```
**Use cases**
- Quickly constructing a fixed, read-only literal list (e.g. direction pairs for grid traversal)

---

## Map / HashMap / TreeMap
`java.util.{Map, HashMap, TreeMap}`

### `new HashMap<>()`
```
// empty map, O(1) average get/put, no key order
Map<String,Integer> m = new HashMap<>();
m → {}
```
**Use cases**
- Building a frequency map for characters / numbers
- Memoization cache keyed by recursive-call parameters
- Index map for two-sum style "value → index" lookups

### `new TreeMap<>([cmp])` — sorted keys
```
cmp : Comparator — optional; keys kept SORTED, O(log n)
TreeMap<Integer,String> t = new TreeMap<>();
t.put(3,"c"); t.put(1,"a"); t.put(2,"b");
t.keySet()      → [1, 2, 3]
t.firstKey()    → 1
t.ceilingKey(2) → 2
```
**Use cases**
- Keeping keys sorted automatically for range queries (calendar / interval books)
- Finding nearest key via floorKey / ceilingKey navigation

### `map.put(k,v)`
```
k : key   v : value — both mandatory (overwrites if present)
m.put("a", 1);
m → {"a"=1}
```
**Use cases**
- Inserting / updating a frequency count or memo result
- Recording parent / visited info during BFS/DFS

### `map.get(k)`
```
k : key — mandatory; returns value or null if absent
m = {"a"=1};
m.get("a") → 1
m.get("b") → null
```
**Use cases**
- Looking up a previously memoized subproblem result
- Reading a stored index / count for a given key

### `map.getOrDefault(k,d)`
```
k : key   d : default when absent — both mandatory
m = {"a"=1};
m.getOrDefault("a", 0) → 1
m.getOrDefault("b", 0) → 0
m.put(c, m.getOrDefault(c,0) + 1); // count
```
**Use cases**
- Frequency counting with a default of 0 when the key hasn't been seen
- Reading a memoized value with a safe fallback instead of null

### `map.containsKey(k)`
```
k : key — mandatory; returns boolean
m = {"a"=1};
m.containsKey("a") → true
m.containsKey("b") → false
```
**Use cases**
- Checking two-sum style complement lookups
- Checking whether a subproblem has already been memoized

### `map.computeIfAbsent(k,fn)`
```
k : key   fn : Function computing the value if missing
Map<Integer,List<Integer>> g = new HashMap<>();
g.computeIfAbsent(0, x -> new ArrayList<>()).add(1);
g → {0=[1]}
```
**Use cases**
- Lazily creating an adjacency-list bucket the first time a node is referenced
- Grouping items into buckets (e.g. group anagrams by sorted-key)

### `map.merge(k,v,fn)` — null return removes key
```
k : key   v : value if absent   fn : how to combine if present
m = {"a"=2};
m.merge("a", 1, Integer::sum); // 2 + 1
m → {"a"=3}
m.merge("b", 1, Integer::sum);
m → {"a"=3, "b"=1}
```
**Use cases**
- Incrementing a frequency counter in one call via `Integer::sum`
- Combining values for a key that may or may not already exist

### `map.values()`
```
// returns Collection of all values
m = {"a"=1, "b"=2};
m.values() → [1, 2]
```
**Use cases**
- Iterating all frequency counts to check a condition (e.g. all counts equal)
- Summing or scanning stored values without needing the keys

### `map.entrySet()`
```
// returns Set of Map.Entry pairs
for (var e : m.entrySet())
    // e.getKey(), e.getValue()
m = {"a"=1}; m.entrySet() → [a=1]
```
**Use cases**
- Iterating key-value pairs together, e.g. pushing all (freq, char) into a heap
- Rebuilding a result list from accumulated map data

### `entry.getKey()/getValue()`
```
// on a Map.Entry from entrySet()
entry = (a=1);
entry.getKey()   → "a"
entry.getValue() → 1
```
**Use cases**
- Extracting the character / count pair while iterating `entrySet()`

### `map.size()`
```
// returns int (number of keys)
m = {"a"=1, "b"=2};
m.size() → 2
```
**Use cases**
- Checking the number of distinct keys, e.g. distinct characters seen

---

## Set / HashSet
`java.util.{Set, HashSet}`

### `new HashSet<>()`
```
// empty set, O(1) add / contains, unique elements
Set<Integer> s = new HashSet<>();
s → {}
```
**Use cases**
- Tracking visited nodes / cells during BFS/DFS
- Deduplicating elements while building a result

### `new HashSet<>(coll)` — dedupe a List
```
coll : Collection — mandatory (duplicates collapse)
new HashSet<>(List.of(1, 1, 2)) → {1, 2}
```
**Use cases**
- Quickly deduplicating a List's contents in one step
- Converting a List to a Set for O(1) membership checks later

### `set.add(e)`
```
e : element — mandatory; returns false if already present
s = {};
s.add(5) → true  {5}
s.add(5) → false {5}
```
**Use cases**
- Marking a node / cell as visited
- Adding a candidate to a "seen" set for duplicate detection

### `set.contains(e)`
```
e : element — mandatory; returns boolean
s = {5};
s.contains(5) → true
s.contains(9) → false
```
**Use cases**
- O(1) membership test, e.g. "has this character been used in this path already?"
- Checking whether a cell has already been visited before recursing into it

### `set.remove(e)`
```
e : element — mandatory; returns false if absent
s = {5, 6};
s.remove(5);
s → {6}
```
**Use cases**
- Un-marking a node as visited when backtracking out of a DFS branch

---

## Queue / Deque / ArrayDeque
`java.util.{Queue, Deque, ArrayDeque, LinkedList}`

### `new ArrayDeque<>()` — doubles as stack or queue
```
// preferred stack AND queue; faster than Stack/LinkedList
Deque<Integer> dq = new ArrayDeque<>();
dq → []

// ArrayDeque also satisfies the Queue interface
Queue<Integer> queue = new ArrayDeque<>();
queue → []
```
**Use cases**
- Iterative DFS using it as a stack (push / pop)
- BFS using it as a queue (offer / poll)
- Monotonic stack / deque problems (next greater element, sliding-window max)

### `new LinkedList<>()` — as Queue, BFS
```
// implements Queue and Deque
Queue<int[]> q = new LinkedList<>();
q → []
```
**Use cases**
- Queue for level-order BFS traversal of a tree or graph

### `dq.push(e) / dq.pop()` — stack semantics
```
push adds to FRONT, pop removes FRONT → LIFO
dq.push(1); dq.push(2);
dq.pop() → 2
dq.pop() → 1
```
**Use cases**
- Iterative DFS / backtracking without recursion
- Bracket-matching / expression evaluation

### `q.offer(e) / q.poll()` — queue semantics
```
offer adds to BACK, poll removes FRONT → FIFO
// poll() returns null when empty (no exception)
q.offer(1); q.offer(2);
q.poll() → 1
q.poll() → 2

// same via a Queue-typed ArrayDeque
queue.offer(1); queue.offer(2);
queue.poll() → 1
```
**Use cases**
- Enqueuing / dequeuing nodes level by level in BFS
- Processing work items in FIFO order (topological sort via Kahn's algorithm)

### `peek()`
```
// returns front/top WITHOUT removing; null if empty
dq = [1, 2, 3];  // front = 1
dq.peek() → 1

queue = [1, 2, 3];  // front = 1
queue.peek() → 1
```
**Use cases**
- Checking the front / top element without removing it (top of monotonic stack)

### `isEmpty()`
```
// returns boolean
while (!q.isEmpty()) { ... } // drain the queue
while (!queue.isEmpty()) { ... } // same check via Queue reference
```
**Use cases**
- Loop condition for "while queue / stack not empty" traversal

### `size()`
```
// returns int
int levelSize = q.size(); // nodes on this BFS level
for (int i = 0; i < levelSize; i++) { ... }
int n = queue.size(); // same via Queue reference
```
**Use cases**
- Capturing the current level's node count in BFS before processing it

---

## PriorityQueue
`java.util.PriorityQueue`

### `new PriorityQueue<>()` — min-heap, natural order
```
// default = MIN-heap (smallest polled first)
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5); pq.offer(1); pq.offer(3);
pq.poll() → 1
```
**Use cases**
- Dijkstra's algorithm, always expanding the smallest known distance
- Finding the k smallest elements
- Merging k sorted lists by always taking the smallest head

### `new PriorityQueue<>((a,b)->...)` — custom order, e.g. max-heap
```
cmp : Comparator — reverse it for a MAX-heap
var pq = new PriorityQueue<Integer>((a, b) -> b - a);
pq.offer(5); pq.offer(1); pq.offer(3);
pq.poll() → 5
```
**Use cases**
- Max-heap for k largest elements or top-k frequent elements
- Ordering intervals by end time for greedy scheduling

### `pq.offer(x)`
```
x : element — mandatory; inserts, O(log n)
pq.offer(4); // heap re-orders automatically
```
**Use cases**
- Inserting a new candidate / distance / frequency into the heap

### `pq.poll()`
```
// removes AND returns the top (min or per comparator); null if empty
pq = min-heap {1, 3, 5};
pq.poll() → 1
```
**Use cases**
- Extracting the current min / max — e.g. next closest node in Dijkstra

### `pq.peek()`
```
// returns top WITHOUT removing; null if empty
pq = min-heap {1, 3, 5};
pq.peek() → 1
```
**Use cases**
- Checking the current top without removing it (e.g. current kth largest)

### `pq.isEmpty()`
```
// returns boolean
while (!pq.isEmpty()) { pq.poll(); }
```
**Use cases**
- Loop condition for "while heap not empty" processing

### `pq.size()`
```
// returns int
if (pq.size() > k) pq.poll(); // keep heap capped at k
```
**Use cases**
- Maintaining a heap capped at size k (poll when size exceeds k)

---

## Notes

**Coverage:** all 222 `.java` files under `src/` — Array (42), BinarySearch/BinarySearchTree/Tries (31), BinaryTree (30), DP (35), Graph/Heap (27), LinkedList/Recursion/SlidingWindowAndTwoPointer/StackQueue (56). User-defined classes and methods (e.g. `ListNode`, custom `Solution` helpers) are excluded — this is JDK API surface only.

**Notably absent anywhere in the codebase:** `java.util.stream`, `Comparator.comparingInt`-style static factories, `LinkedHashMap`/`LinkedHashSet`, `Objects`, and the standalone `Stack` class (its role is played by `ArrayDeque` throughout).
