1 REM Derek Trom
2 REM derek.trom@und.edu
5 REM Part 2 Program 5
10 counter = 0
15 counter = counter + 1
30 IF counter MOD 3 = 0 THEN PRINT "Fizz";
35 IF counter MOD 5 = 0 THEN PRINT "Buzz";
40 IF counter MOD 3 <> 0 AND counter MOD 5 <> 0 THEN PRINT counter;
45 IF counter = 100 THEN GOTO 65
50 PRINT
55 GOTO 15
65 SYSTEM




