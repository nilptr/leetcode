
#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target) {
    int* arr = (int*) malloc(2 * sizeof(int));
    arr[0] = 0;
    arr[1] = 0;
    int i = 0, j = 0;
    for (i = 0; i < numsSize; ++i) {
        for (j = i + 1; j < numsSize; ++j) {
            if (nums[i] + nums[j] == target) {
                arr[0] = i + 1;
                arr[1] = j + 1;
                return arr;
            }
        }
    }
    return arr;
}

int main(int argc, char const *argv[])
{
    int nums[] = { 2, 7, 11, 15 };
    int len = sizeof(nums) / sizeof(int);
    int* result = twoSum(nums, len, 9);
    printf("%d %d\n", result[0], result[1]);
    free(result);
    return 0;
}