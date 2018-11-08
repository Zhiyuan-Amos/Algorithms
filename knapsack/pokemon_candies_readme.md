# Ash and the Pokemon Candies - Variant of Knapsack Problem

Ash Ketchum has won the Pokemon Trainer of the Year contest. As his prize, he gets to fill up his bag with Pokemon candies.

There are N types of candies. Each type has a weight of Wi, and has an infinite amount in stock. Each candy of type i-th has a value Vi to Ash that depends on how much he needs to evolve or power up his pokemons. Ash's bag has capacity of C. That means it can hold up to a weight of C. Ash wants to bring home candies with a maximum total value S. Help him to compute S in Java.

## Input format:

First line is two numbers N and C, separated by a space.

Each line i-th of next N lines contains two numbers describe Wi and Vi (weight and value of a candy of type i-th), separated by a space.

## Output format:

Print in one line the maximum value S of all candies that Ash can bring home.

You are guaranteed that the solution fits in a 32-bit signed integer.

## Constraints:

```
2 <= N <= 8000
1 <= C <= 20000
1 <= Wi <= 10000
1 <= Vi <= 100000000
Time limit: 1 second 
Memory limit: 256MB
```

## Sample of Input

```
5 19
8 86
7 73
5 51
6 62
2 21
```

## Sample of Output

```
201
```

## Explanation:

There are 5 types of candies. Each candy of type 1 has a weight of 8, and a value of 86. Each candy of type 2 has a weight of 7 and a value of 73, and so on. 
Ash's bag has a capacity of 19. He can take candies with a maximum value as following: Take 1 candy of type 1 (weight 8, value 86), 1 candy of type 2 (weight 7, value 73) and 2 candies of type 5 (weight 2, value 21). 
The total weight of these candies is 8 + 7 + 2*2 = 19, thus his bag can hold them. The maximum value is: 86 + 73 + 2 * 21 = 201. 