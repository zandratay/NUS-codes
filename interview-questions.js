// q1: finding missing number in a given integer array
function integers_to_n(n) {
        function rev_integers_to_n(n) {
        const v = n === 0
               ? list(0)
               : pair(n, rev_integers_to_n(n - 1));
        return v;
    }
    return reverse(rev_integers_to_n(n));
}
integers_to_n(10);

const test = remove(5, integers_to_n(10));

function missing_num(xs) {
    //
}

missing_num(test);

// q2 find largest and smallest number in an unsorted integer array?
const arr = [4, 1, 5, 3, 7, 3, 2];
function accumulate_array(op, init, A) {
    let acc = op(init, A[0]);
    for (let x = 1; x < array_length(A); x = x + 1) {
        acc = op(acc, A[x]); 
    }
    return acc;
}

function largest(A) {
    return accumulate_array((x, y) => x > y ? x : y, A[0], A);
}
largest(arr); // 7

function smallest(A) {
    return accumulate_array((x, y) => x < y ? x : y, A[0], A);
}
smallest(arr); // 1