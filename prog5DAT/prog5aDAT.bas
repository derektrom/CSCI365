1 REM Derek Trom
2 REM derek.trom@und.edu
5 REM Part 1 Program 5
10 PRINT "Welcome"
15 INPUT "What is the cost"; cost
20 INPUT "What is the amount paid"; paid
25 PRINT "The cost is: "
30 PRINT USING "  $$$$$$$#.##"; cost
35 PRINT "You paid:"
40 PRINT USING "  $$$$$$$#.##"; paid
45 cost = cost * 100
50 paid = paid * 100
55 change = paid - cost
60 IF change < 0 THEN GOTO 165 
65 printchange = change / 100
70 PRINT "Change: "
75 PRINT USING "  $$$$$$$#.##"; printchange
80 IF change > 100 THEN GOTO 86
85 IF change < 100 AND change > 24 THEN GOTO 100
86 N$ = "###"
90 dollars = INT(change\100)
95 PRINT "Dollars:  "; 
96 PRINT USING N$; dollars
100 change = change - dollars * 100
105 quarters = INT(change \ 25)
110 PRINT "Quarters: "; 
111 PRINT USING N$; quarters
115 change = change - quarters * 25
120 dimes = INT(change\10)
125 PRINT "Dimes:    ";
126 PRINT USING N$; dimes
130 change = change - dimes * 10
135 nickels = INT(change\5)
140 PRINT "Nickels:  ";
141 PRINT USING N$; nickels
145 change = change - nickels * 5
150 pennies = INT(change \ 1)
155 PRINT "Pennies:  ";
156 PRINT USING N$; pennies
160 SYSTEM
165 PRINT "INSUFFICIENT FUNDS"
170 SYSTEM
