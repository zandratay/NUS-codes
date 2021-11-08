/*

You are given a list xs consisting of lowercase English letters. 
A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on xs until we no longer can.

Return the final list after all such duplicate removals have been made.

Input: s = list("a","b","b","a","c","a")
Output: list("c","a")
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and 
this is the only possible move.  
The result of this move is that "aaca", of which only "aa" is possible, 
so the final list is list("c","a").

Input: s = list("a","z","x","x","z","y")
Output: list("a","y")
*/
function runlength_encode(L) {

    function encode(val, count, next) {
        return is_null(next)
               ? list(count === 1 ? val : pair(val, count))
               : head(next) === val
               ? encode(val, count + 1, tail(next))
               : pair(count === 1 ? val : pair(val, count),
                      encode(head(next), 1, tail(next)));
    }
    return is_null(L)
           ? null
           : encode(head(L), 1, tail(L));
}

function remove_duplicates(xs) {
    // Your solution here
    let o = list();
    const encoded_list = runlength_encode(xs);
    for (let i = 0; i < length(encoded_list); i = i + 1) {
        if (!is_pair(list_ref(xs, i))) {
            return list(o, list_ref(xs, i));
        } else if (is_pair(list_ref(xs, i))) {
            o = remove(list_ref(xs, i));
            return o;
        }
    }
    /*function iter(curr, next) {
        if (!is_pair(curr)) {
            return list(curr, iter(head(tail(xs)), tail(tail(xs))));
        } else if (is_pair(curr)) {
            const ys = remove(curr, xs);
            return list(iter(head(tail(xs)), tail(tail(xs))));
        }
    } 
    return iter(head(xs), tail(xs));*/
}

const f =list("a","b","b","a","c","a");
display(runlength_encode(f));
remove_duplicates(list("a","b","b","a","c","a"));

function pairer(xs) {
    
}




