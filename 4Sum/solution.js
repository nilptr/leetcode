/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    'use strict';

    let ret = [];
    nums.sort(function (a, b) {
        return a - b;
    });

    let len = nums.length;
    for (let m = 0; m < len; ++m) {
        // skip same numbers
        if (m > 0 && nums[m - 1] === nums[m]) continue;

        for (let n = m + 1; n < len; ++n) {
            if (n != m + 1 && nums[n - 1] === nums[n]) continue;
            let left = target - nums[m] - nums[n];

            for (let i = n + 1, j = len - 1; i < j;) {
                let sum = nums[i] + nums[j];
                if (sum === left) {
                    ret.push([
                        nums[m],
                        nums[n],
                        nums[i],
                        nums[j]
                    ]);
                    while (nums[i + 1] === nums[i]) i++;
                    while (nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                } else if (sum > left) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }

    return ret;
};