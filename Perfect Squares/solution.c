int numSquares(int n) {
    // dp cache
    int * sqs = malloc((sizeof( int)) * (n + 1));
    memset(sqs, 0, n); // init
    
    int i = 0;
    for (i = 1; i <= n; ++i) {
        int min = INT_MAX;
        int j = 0;
        for (j = 1; j * j <= i; ++j) {
            if (min > sqs[i - j * j]) min = sqs[i - j * j];
        }
        sqs[i] = min + 1;
    }

    int res = sqs[n];
    free(sqs);
    return res;
}