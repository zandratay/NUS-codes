// Instructions for students who are using this for practice:
//
// (1) Copy and paste this entire file into the editor of Source Academy
//     Playground at https://sourceacademy.nus.edu.sg/playground
// (2) Write your solution for each task in the Source Academy Playground.
// (3) Run the program to test your solution on the given testcases.


////////////////////////////////////////////////////////////
// Question 3A
////////////////////////////////////////////////////////////

function evaluate_BAE_tree(bae_tree) {

    // WRITE HERE.
    if (is_null(bae_tree)) {
        return null;
    } else if (is_number(bae_tree)) {
        return bae_tree;
    } else if (is_number(head(bae_tree)) && is_number(list_ref(bae_tree, 2))) {
        const left = head(bae_tree);
        const op = head(tail(bae_tree));
        const right = list_ref(bae_tree, 2);
        if (op === "+") {
            return left + right;
        } else if (op === "-") {
            return left - right;
        } else if (op === "*") {
            return left * right;
        } else if (op === "/") {
            return left / right;
        } else {
            const left = head(bae_tree);
            const op = head(tail(bae_tree));
            const right = list_ref(bae_tree, 2);
            if (op === "+") {
               return evaluate_BAE_tree(left) + evaluate_BAE_tree(right); 
            } else if (op === "-") {
                return evaluate_BAE_tree(left) - evaluate_BAE_tree(right);
            } else if (op === "*") {
                return evaluate_BAE_tree(left) * evaluate_BAE_tree(right);
            } else if (op === "/") {
                return evaluate_BAE_tree(left) / evaluate_BAE_tree(right);
            }    
        }
    
    }

}


////////////////////////////////////////////////////////////
// Question 3B
////////////////////////////////////////////////////////////

function build_BAE_tree(bae_list) {

    // WRITE HERE.
    if (is_null(bae_list)) {
        return null;
    } else if (length(bae_list) === 1) {
        return head(bae_list);
    } else {
        const opening = head(bae_list);
        const rev = reverse(bae_list);
        const closing = head(tail(bae_list));
        if (opening === "(" && closing === ")") {
            const x = remove(opening, bae_list);
            const y = remove(closing(bae_list));
            return accumulate(pair, null, y);
        } else {
            return accumulate(pair, null, bae_list);
        }
    }

}


////////////////////////////////////////////////////////////
// Question 3C
////////////////////////////////////////////////////////////

function evaluate_BAE(bae_list) {

    // WRITE HERE.
    if (is_null(bae_list)) {
        return null;
    } else {
        return evaluate_BAE_tree(build_BAE_tree(bae_list));
    }

}



////////////////////////////////////////////////////////////
// Question 3D
////////////////////////////////////////////////////////////
// put the first n elements of xs into a list
function take(xs, n) {
    // YOUR SOLUTION HERE
    function take_helper(list, first_value, end_value) {
        return first_value === end_value
               ? null
               : pair(list_ref(list, first_value), take_helper(xs, first_value + 1, end_value));
    }
    return take_helper(xs, 0, n);
}

// drop the first n elements from list, return rest
function drop(xs, n) {
    // YOUR SOLUTION HERE
    function drop_helper(list, first_value, end_value) {
        return first_value === end_value
               ? null
               : pair(list_ref(list, first_value), drop_helper(xs, first_value + 1, end_value));
    }
    return drop_helper(xs, n, length(xs));
}

function check_parentheses(paren_list) {

    // WRITE HERE.
    if (is_null(paren_list)) {
        return null;
    } else if (length(paren_list) % 2 !== 0) {
        return false;
    } else {
        //const paren_list = list("(", "(", ")", ")", ")", "(", "(", ")");
        const len = length(paren_list);
        const mid = length(paren_list) / 2;
        const lhs = take(paren_list, mid);
        const rhs = drop(paren_list, mid);
        const check_lhs = map(x => equal(x, "("), lhs);
        const left = length(member('false', check_lhs));
        const check_rhs = map(x => equal(x, ")"), rhs);
        const right = length(member('false', check_rhs));
        
        /*display(rhs);
        display(check_rhs);
        display(right);*/
        
        if (length(lhs) === length(rhs) && left === 0 && right === 0) {
            return true;
        } else {
            return false;
        }
    }

}



////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////


//===========================================================
// This function is provided for running the testcases
// in the Source Academy Playground.
// They are NOT part of the actual testing facility provided
// in the actual Practical Assessment.
//===========================================================
function assert(f, test_name, fnames) {
    display(test_name + ": " + (f() ? "PASS" : "FAIL <<<"));
}
//===========================================================



////////////////////////////////////////////////////////////
// Test Cases for Q3A
////////////////////////////////////////////////////////////

assert(
    () => {
        const bae_tree = 23;
        return equal(evaluate_BAE_tree(bae_tree), 23);
    },
    "Q3A-T1",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(5, "*", 6);
        return equal(evaluate_BAE_tree(bae_tree), 30);
    },
    "Q3A-T2",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(5, "*", list(7, "+", 3));
        return equal(evaluate_BAE_tree(bae_tree), 50);
    },
    "Q3A-T3",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(8, "-", 2), "*", list(7, "+", 3));
        return equal(evaluate_BAE_tree(bae_tree), 60);
    },
    "Q3A-T4",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(list(20, "/", 2), "-", 2), "*",
                            list(7, "+", 3));
        return equal(evaluate_BAE_tree(bae_tree), 80);
    },
    "Q3A-T5",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = 100;
        return equal(evaluate_BAE_tree(bae_tree), 100);
    },
    "Q3A-T6",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(70, "-", 15);
        return equal(evaluate_BAE_tree(bae_tree), 55);
    },
    "Q3A-T7",
    ['evaluate_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(list(7, "+", 5), "*", 3), "/",
                            list(list(20, "/", 2), "-", list(100, "-", 94)));
        return equal(evaluate_BAE_tree(bae_tree), 9);
    },
    "Q3A-T8",
    ['evaluate_BAE_tree']
);



////////////////////////////////////////////////////////////
// Test Cases for Q3B
////////////////////////////////////////////////////////////

assert(
    () => {
        const bae_tree = 23;
        const bae_list = list(23);
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T1",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(5, "*", 6);
        const bae_list = list("(", 5, "*", 6, ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T2",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(5, "*", list(7, "+", 3));
        const bae_list = list("(", 5, "*", "(", 7, "+", 3, ")", ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T3",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(8, "-", 2), "*", list(7, "+", 3));
        const bae_list = list("(", "(", 8, "-", 2, ")", "*",
                            "(", 7, "+", 3, ")", ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T4",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(list(20, "/", 2), "-", 2), "*",
                            list(7, "+", 3));
        const bae_list = list("(", "(", "(", 20, "/", 2, ")", "-", 2, ")", "*",
                            "(", 7, "+", 3, ")", ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T5",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = 100;
        const bae_list = list(100);
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T6",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(70, "-", 15);
        const bae_list = list("(", 70, "-", 15, ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T7",
    ['build_BAE_tree']
);

assert(
    () => {
        const bae_tree = list(list(list(7, "+", 5), "*", 3), "/",
                            list(list(20, "/", 2), "-", list(100, "-", 94)));
        const bae_list = list("(", "(", "(", 7, "+", 5, ")", "*", 3, ")", "/",
                            "(", "(", 20, "/", 2, ")", "-",
                                 "(", 100, "-", 94, ")", ")", ")");
        return equal(build_BAE_tree(bae_list), bae_tree);
    },
    "Q3B-T8",
    ['build_BAE_tree']
);



////////////////////////////////////////////////////////////
// Test Cases for Q3C
////////////////////////////////////////////////////////////

assert(
    () => {
        const bae_list = list(23);
        return equal(evaluate_BAE(bae_list), 23);
    },
    "Q3C-T1",
    ['evaluate_BAE']
);

assert(
    () => {
        const bae_list = list("(", 5, "*", 6, ")");
        return equal(evaluate_BAE(bae_list), 30);
    },
    "Q3C-T2",
    ['evaluate_BAE']
);

assert(
    () => {
        const bae_list = list("(", "(", "(", 20, "/", 2, ")", "-", 2, ")", "*",
                            "(", 7, "+", 3, ")", ")");
        return equal(evaluate_BAE(bae_list), 80);
    },
    "Q3C-T3",
    ['evaluate_BAE']
);



////////////////////////////////////////////////////////////
// Test Cases for Q3D
////////////////////////////////////////////////////////////

assert(
    () => {
        const paren_list = list();
        return equal(check_parentheses(paren_list), true);
    },
    "Q3D-T1",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", ")");
        return equal(check_parentheses(paren_list), true);
    },
    "Q3D-T2",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", "(", "(", ")", ")",
                                   "(", "(", ")", "(", ")", ")", ")");
        return equal(check_parentheses(paren_list), true);
    },
    "Q3D-T3",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list(")", "(");
        return equal(check_parentheses(paren_list), false);
    },
    "Q3D-T4",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", "(", ")", ")", ")", "(", "(", ")");
        return equal(check_parentheses(paren_list), false);
    },
    "Q3D-T5",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", "(", ")", "(");
        return equal(check_parentheses(paren_list), false);
    },
    "Q3D-T6",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", ")", "(", ")", "(", ")");
        return equal(check_parentheses(paren_list), true);
    },
    "Q3D-T7",
    ['check_parentheses']
);

assert(
    () => {
        const paren_list = list("(", "(", "(", ")", ")",
                                   "(", "(", ")", ")", ")", ")", ")");
        return equal(check_parentheses(paren_list), false);
    },
    "Q3D-T8",
    ['check_parentheses']
);
