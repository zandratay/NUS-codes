// First question of week 8! (the teta(N^2) solution should be easy!)
// (but for the teta(N) solution is a fairly challenging dynamic programming problem)

// You are given an array prices where 
// prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock 
// and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

// eg 1
// input: prices = list(7,1,5,3,6,4)
// output: 5: buy stock on 1 (index 1), sell on 6 (index 4)

// eg 2
// input prices = list(7,6,5,4,3,2,1)
// output: 0: cant earn any profit at all

function largest(xs) {
    return accumulate((x,y) => (x > y ? x : y), head(xs), xs);
}
display(largest(list(7, 1, 5, 3, 6, 4)));

function smallest(xs) {
    return accumulate((x,y) => (x < y ? x : y), head(xs), xs);
}

function is_decreasing(xs) {
   
   for (let i = 0; i < length(xs); i = i + 1) {
       if (is_null(xs)) {
           return 0;
       } else if (list_ref(xs, i) > list_ref(xs, i + 1)) {
           return true;
       } else {
           return false;
       }
   }
}
display(is_decreasing(list(7,6,5,4,3,2,1)));

function is_always_decreasing(xs) {
    return is_null(xs)
           ? null
           : head(xs) > head(tail(xs))
           ? is_decreasing(tail(xs))
           : false;
}
display(is_always_decreasing(list(7,6,5,4,3,2,1)));


function max_profit(xs) {
    // Your answer here
    if (is_null(xs)) {
        return null;
    } else if (is_always_decreasing(xs)) {
        return 0;
    } else {
        const buy = smallest(xs);
        const sell = largest(xs);
        return sell - buy;
    }
}

// testing
max_profit(list(7,1,5,3,6,4));






