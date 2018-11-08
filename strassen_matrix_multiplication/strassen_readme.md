# Is Strassen's algorithm Galactic?

Galactic algorithms are algorithms with good asymptotic behaviour, but are never used in practice (see https://rjlipton.wordpress.com/2010/10/23/galactic-algorithms/).

In this assignment, you will explore whether Strassen's matrix multiplication algorithm should be called a galactic algorithm. You should implement Strassen's algorithm to multiply matrices of various sizes. The simple O(n^3) matrix multiplication algorithm will not be able to multiply the larger test cases within the time limit. So if you are able to use Strassen's algorithm to pass all the test cases, you'll declare Strassen's algorithm non-galactic (in the sense that you will use it yourself if you implement your own matrix multiplication algorithm).

Hint: A naive implementation of Strassen's algorithm is likely to be too slow. Have a look at the Comments section of the article https://rjlipton.wordpress.com/2010/10/23/galactic-algorithms/.

## Input format:

The input matrices are square matrices.

The first line of the input file contains the number of rows, N, of the matrices. To make it easier to program, N is always a power of 2.

The next N rows contain the N rows of the first matrix, where each row contains N numbers.

The following N rows contain the N rows of the second matrix.

## Constraints:

```
2 <= N <= 2048, where N is a power of 2.
Each matrix entry is between 0 and 9.
Time limit: 40 second
Memory limit: 512MB
```

## Output format:

Print in one line the sum of all the entries of the product matrix.

You should use the "long" type to store the sum as it may be larger than 32 bits.

## Sample of Input

```
2
0 3
1 2
2 1
3 0
```

## Sample of Output

```
18
```

## Explanation:

The product of the two matrices is

```
9 0
8 1
```

The sum of the entries is 9 + 0 + 8 + 1 = 18.