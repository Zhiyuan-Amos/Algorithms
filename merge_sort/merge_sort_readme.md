# Distance Between Rankings - Variant of Merge Sort

You work for a movie streaming service and you are tasked with recommending movies that users may like. When a user first registers for the service, the user is asked to rank N movies in order for the service to figure out what they like. You decide to recommend movies to users based on what similar users have watched. To do that you decide to use a measure of similarity/distance between users based on their rankings of the N movies.

You develop your distance measure as follows. Given a set of movies 1,..,N, list out all pairs of movies in a fixed order. For example, for movies 1,2,3, we can list out the pairs (1,2), (1,3), (2,3). There at N(N-1)/2 such pairs. For each pair (i,j), if i is ranked higher than j in one ranking but j is ranked higher than i in the other ranking, we say that the rankings disagree. We measure the distance between two rankings using the number of disagreements between the two rankings.

In this problem, your task is to compute the distance between two rankings as described above quickly. To make the programming easier, we transform the data by ordering the movies listed according to the ranking of the first user. After reordering the list based on the ranking of the first user, we can compute the number of disagreements using only the ranking list of the second user. Let the reordered list of the second user's rankings be T. If j > i but T[j] < T[i], then we have a disagreement as i is prefered to j according to the first user's ranking but the second user prefers j to i. The code for reordering is included in the Java template below.

Hint: It is always good to write the code using the problem definition first. It should be easier to use the definition for the reordered list. Can you then write a divide and conquer version? What can you do to speed up the divide and conquer version?

## Input format:

The first line of the input file contains the number of movies, N.

Each of the i-th next N lines contains two numbers. The first number describe the ranking of the i-th movie by the first user and the second number describe the ranking of the i-th movie by the second user.

## Constraints:

```
2 <= N <= 100000
Time limit: 1 second
Memory limit: 256MB
```

## Output format:

Print in one line the distance between the two rankings.

## Sample of Input

```
4
2 4
1 3
3 2
4 1
```

## Sample of Output

```
5
```

## Explanation:

If we list out the pairs as (1,2), (1,3), (1,4), (2,3), (2,4), (3,4). The list of agreements or disagreement is shown below:

```
(1,2) agree
(1,3) disagree
(1,4) disagree
(2,3) disagree
(2,4) disagree
(3,4) disagree
```

The number of disagreements is 5.