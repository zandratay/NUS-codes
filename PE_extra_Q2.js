/*
House Robber
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that 
adjacent houses have security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/
function array_to_list(A) {
    const len = array_length(A);
    let L = null;
    for (let i = len - 1; i >= 0; i = i - 1) {
        L = pair(A[i], L);
    }
    return L;
}

function even_index(xs) {
    if (is_null(xs)) {
        return null;
    } else {
        return pair(head(xs), even_index(tail(tail(xs))));
    }
}

function odd_index(xs) {
    if (is_null(xs)) {
        return null;
    } else {
        return pair(head(tail(xs)), odd_index(tail(tail(xs))));
    }
}

function sum(xs) {
     return is_null(xs) ? 0 : head(xs) + sum(tail(xs));
}


const c = list(1, 2, 3, 4, 5, 6, 7, 8);
display(even_index(c));
display(odd_index(c));
display(sum(c));
const b = [1, 2, 3, 4, 5, 6, 7, 8];
display(array_to_list(b));

function robber(xs) {
        const even = even_index(xs);
        const odd = odd_index(xs);
        const even_sum = sum(even);
        const odd_sum = sum(odd);
        if (is_null(xs)) {
            return 0;
        } else if (length(xs) === 1) {
            return head(xs);
        } else if (odd_sum > even_sum) {
            return odd_sum;
        } else if (even_sum > odd_sum) {
            return even_sum;
        }
    }


function rob(arr) {
    // Your answer here
    const newlist = array_to_list(arr); // list(1, 2, 3, 1)
    display(newlist);
    //return robber(newlist);
    
    
}

rob([1,2,3,1]);
rob([2,7,9,3,1]);
robber(c);

