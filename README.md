# AdvancedProblemSolving
Exam Completed Spring Semester 2023 by Emily Balboni 
Quinnipiac University Advanced Computation Problem Solving
Test By: Professor Duncan 

## Problem 1 Arena Seating (70-100 points) 
After a recent hockey game, the packed crowd left in such a rush
that every single seat in the arena was littered with trash. Boomer and his buddies including Jay and
Sebastian volunteered to help and clean up the area. Each of them chose a region to clean up, and
naturally they did not discuss beforehand so there were lots of overlap. Your task is to determine how
many seats at the end were not cleaned up.
Fortunately for us the seating in the arena is described as a standard rectangular grid and Boomer and
his buddies all chose rectangular regions to clean.
For example, suppose that the arena was 10 rows by 10 columns which we number as (0, 0) in the
upper left and (9, 9) in the lower right. Further suppose that Boomer chose to clean the seats from
row 1, column 2 to row 4, column 4; Sebastian cleaned from row 4, column 1 to row 6, column 7; and
Jay cleaned from row 0, column 6 to row 8, column 6. Looking at the figure below, you can see that
in the end they cleaned 36 seats (6 seats were overlapped), leaving 64 seats untouched.

### Input
The first line contains the number K of cases with 0 < K ≤ 100. This is then followed by K cases.
Each case consists of a line of numbers (separated by spaces). The first two numbers represent the
dimensions of the arena R by C. The next number is the number of workers W. This is then followed
by 4W numbers. The first four of these numbers represent the starting row SR, starting column SC ,
ending row ER and ending column EC of the first worker, followed by the 4 numbers for the second
worker, and so on.
Here are some assumptions that you can make:
• The dimensions of the arena will be between 1 and 1000: 0 < R, C ≤ 1000.
• The number of workers is no more than 10 (and at least 1): 0 < W ≤ 10.
• All regions selected by the workers will fall inside the arena dimensions. (They aren’t cleaning
the ice rink).
• All regions selected by the workers will have the start row and column values be no larger than
the end row and column. That is, 0 ≤ SR ≤ ER < R and 0 ≤ SC ≤ EC < R.
### Output & Analysis
The output consists of one line for each case, which is simply the number of uncleaned seats.
In the top comments of your submission, analyze the time and space efficiency of your solution in terms
of W, the number of workers, and A, the area of the arena (R × C).
Keep in mind that for full credit, you should give a reasoning for your bounds and not just state the
asymptotic bounds. But it does not need to be long - a few lines should suffice.

## Problem 2 Letter Scramble (70 points)
At the last hockey game of the season, Boomer gave several students a separate letter to hold up high
so that they would spell the word “BOBCAT.” Unfortunately, they did not sit in the correct order so
he had to provide them with instructions to move about and unscramble the letters. Boomer, in his
infinite wisdom, decided to make a technique out of it so that he could use it for future games and
messages as well. Here are the commands he created:
  • swap I J: The letters at index I and index J are swapped with counting starting at 0. The
  indices are guaranteed to reference specific letters in the message.
  For example, swap 0 3 would transform the string TAOBBC to BAOTBC.
  • rotate K: Rotates the string K steps to the left (negative values rotate right) with −1000 ≤ K ≤
  1000. For example, rotate 2 would transform the string BAOTBC to OTBCBA.
  And, rotate -10 would transform the string OTBCBA to BCBAOT.
  • reverse I J: The span of letters from index I to index J (inclusive of both) should be reversed.
  As before, counting starts at 0 and the indices are guaranteed to reference specific letters in the
  message and I ≤ J. For example, reverse 1 3 would transform the string BCBAOT to BABCOT.
  • move I J: Moves the letter at index I to index J by removing the letter at I and inserting it so it
  ends up at J. Again, counting starts at 0 and indices are guaranteed to reference specific letters
  in the message. For example, move 1 4 would transform the string BABCOT to BBCOAT.
  And, move 3 1 would transform the string BBCOAT to BOBCAT.
### Input 
The first line contains the number K of cases with 0 < K ≤ 100. This is then followed by K cases.
The first line of each case starts with the starting message M where M has length more than 0 and
no more than 100 and each character in M is a letter in A-Z (inclusive). The next line of each case is
the number S of instructions to perform with 0 < S ≤ 100. This is followed by S lines, with each line
being an instruction of the form described above.

### Output& Analysis
The output consists of one line per case, where the line is the message after performing the instructions.
In the top comments of your submission, analyze the performance of your solution (per case) in terms
of n, the length of the message M, and s, the number of instructions for that messaeg. Keep in mind
that for full credit, you should give a reasoning for your bounds and not just state the asymptotic
bounds. But it does not need to be long - a few lines should suffice.

# Gift Shop (80 points)
After a long day of making fans happy and earning some spending cash, Boomer decides to head to the
gift shop. After picking out the various quantities of items with differing prices at the shop, he wants
to see what is the maximum number of items he can buy with his money. Suppose that he identified
three $5 T-shirts, four $3 hats, and eight $1.50 binders. If he had $23.50 of his hard-earned money, he
could buy at most 11 items: eight binders, two hats, and a T-shirt.

### Input
The first line contains the number K of cases with 0 < K ≤ 100. This is then followed by K lines, one
line per case. Each line starts with a number of items N, 0 < N ≤ 100, which is then followed by N
pairs of values, where the first value in a pair is the quantity Qi for that item and the second value is
the price Pi of that item with 0 < Qi ≤ 100 and 0 < Pi ≤ 100.00. The price Pi
is specified in dollars
and possibly cents. These values are then followed by the amount of cash C that Boomer earned from
his work with 0 < C ≤ 1000000.00.

### Output & Analysis
The output consists of one line for each case, where the line is simply the maximum number of items
that he could purchase

In the top comments of your submission, analyze the time and space efficiency of your solution (per
case) in terms of n, the number of items, and c, the amount of cash Boomer has. Keep in mind that
for full credit, you should give a reasoning for your bounds and not just state the asymptotic bounds.
But it does not need to be long - a few lines should suffice.
