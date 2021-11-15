// 1. streams

// are delayed / lazy lists --- lists with items which are not evaluated until needed
// when called, contains 1 evaluated item which is the head
// need not be an infinite sequence
// tail of a stream is wrapped in a unary function
// is only evaluated when called, since functions return undefined 
// when they are not called


const alternating_ones = pair(1, () => pair(-1, () => alternating_ones));
alternating_ones; // [1, () => pair(-1, () => alternating_ones)]
tail(alternating_ones)(); // [-1, () => alternating_ones]
tail(tail(alternating_ones)()); // () => alternating_ones

const f = enum_stream(1, 5);

function mult_stream(s) {
    function helper(s, acc) {
        return is_null(s) || is_null(stream_tail(s))
               ? s
               : pair(head(s) * acc, () => helper(stream_tail(s), head(s) * acc));
    }
    return helper(s, 1);
}
mult_stream(f); // [1, () => helper(stream_tail(s), head(s) * acc)]
head(stream_tail(f)); // 2


// 2. memoisation

// if there are many "duplicates" to be computed e.g. fib(5) --> fib(2) is 
// computed thrice, we can memoise a function so that the run time is a lot faster
// by storing the already computed results into a "memory"

// usually memoised functions makes use of arrays since elems of an array can be 
// accessed in O(1) time

// we need the read and write function

const mem = [];
function read(n, k) {
    return mem[n] === undefined
           ? undefined
           : mem[n][k];
}
function write(n, k, value) {
    if (mem[n] === undefined) {
        mem[n] = [];
    }
    mem[n][k] = value;
}

function factorial(num) {
    return num === 0 || num === 1
           ? 1
           : num * factorial(num - 1);
}

function m_perm(n, k) {
    if (read(n, k) !== undefined) {
        return read(n, k);
    } else {
        const result = k > n ? "invalid input"
                       : k === 0 ? 1
                       : k === 1 ? n
                       : k === n || k - 1 === n ? factorial(n) 
                       : m_perm(n - 1, k - 1) * k +  m_perm(n -1, k);
        write(n, k, result);
        return result;
    }
}

m_perm(5, 3); // 60

// 3. environment model
