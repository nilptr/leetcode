# 

动态规划

设 ps (ps <= n) 为一个完全平方数

numSquares(n) = 1 + max( numSquares(n - 1), ..., numSquares(n - ps) );