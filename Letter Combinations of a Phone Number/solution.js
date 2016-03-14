var map = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z']
};

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    'use strict';
    if (digits.length < 1) {
        return [];
    } else if (digits.length === 1) {
        return map[digits];
    } else {
        let ret = [];
        for (var i = 0; i < map[digits[0]].length; ++i) {
            ret = ret.concat(letterCombinations(digits.slice(1)).map(s => map[digits[0]][i] + s));
        }
        return ret;
    }
};