# Scheduling Processors - Variant of Activity Selection Problem

Given a set of tasks, you would like to schedule them using the fewest number of processors. Each task is specified by an interval [Si,Ti] where Si is the start time and Ti is the finish time of the task. Two tasks can be scheduled on the same processor if the intervals defining the two tasks do not overlap.

An interval [Si,Ti] includes all numbers n where Si <= n <= Ti. Two intervals [Si, Ti] and [Sj, Tj] overlap if the intersection of the two intervals is non-empty.

You may use the data structures from the Java libraries for your implementation.

## Input format:

First line is a single number N that describes the number of tasks

Each of the next i-th lines contains two numbers describing Si and Ti, separated by a space.

## Output format:

Print in one line the smallest number of processors required to run all the tasks.

You are guaranteed that the solution fits in a 32-bit signed integer.

## Constraints:

```
2 <= N <= 100,000
0 <= Si <= 24, Si are integers
0 <= Ti <= 24, Ti are integers
Time limit: 2 second 
Memory limit: 256MB
```

## Sample of Input

```
5 
3 4
1 3
2 7
5 6
1 8
```

## Sample of Output

```
4
```

## Explanation:

We need to use at least 4 processors. Intervals [1,3] and [5.6] can use the same processor with the other three intervals using their own processors. Alternatively, intervals [3,4] and [5,6] can share a processor with the other three intervals using their own processors. Note that [1,3] and [3,4] cannot share the same processor as they have 3 in common.