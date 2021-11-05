// complete solutions!

// Instructions for students who are using this for practice:
//
// (1) Copy and paste this entire file into the editor of Source Academy
//     Playground at https://sourceacademy.nus.edu.sg/playground
// (2) Write your solution for each task in the Source Academy Playground.
// (3) Run the program to test your solution on the given testcases.


////////////////////////////////////////////////////////////
// Question 2A
////////////////////////////////////////////////////////////

function all_different(nums) {

    // WRITE HERE.
    function remove_dups(xs) {
            return is_null(xs)
                   ? null
                   : pair(head(xs), remove_dups(filter(x => x !== head(xs), xs)));
            }
    /*const x = list(2, 6, 1, 7, 6, 4, 3);
    display(remove_dups(x));*/
    
    let unique_list = remove_dups(nums);
    let unique_length = length(unique_list);
    let og_length = length(nums);
    return og_length === unique_length
           ? true 
           : false;
}



////////////////////////////////////////////////////////////
// Question 2B
////////////////////////////////////////////////////////////
function insert(x, xs) {
    return is_null(xs)
           ? list(x)
           : x <= head(xs)
           ? pair(x, xs)
           : pair(head(xs), insert(x, tail(xs)));
}
function insertion_sort(xs) {
    return is_null(xs) 
           ? xs
           : insert(head(xs), insertion_sort(tail(xs)));
}

function is_valid_toto_set(nums, n, min, max) {

    // WRITE HERE.
    const sorted = insertion_sort(nums);
    const rev = reverse(sorted);
    if (is_null(nums)) {
        return null;
    } else if (length(sorted) === n && head(sorted) === min && head(rev) === max && all_different(nums)) {
        return true;
    } else {
        return false;
    }
}

const nums = list(25, 13, 8, 14, 30, 3, 8);
const n = 7;
const min = 3;
const max = 30;
display(is_valid_toto_set(nums, n, min, max));

////////////////////////////////////////////////////////////
// Question 2C
////////////////////////////////////////////////////////////

function num_of_matches(numsA, numsB) {

    // WRITE HERE.
    const combined = append(numsA, numsB);
    const sorted_nums = insertion_sort(combined);
    let counter = 0;
    if (is_null(numsA) || is_null(numsB)) {
        return 0;
    } else {
        function remove_dups(xs) {
            return is_null(xs)
                   ? null
                   : pair(head(xs), remove_dups(filter(x => x !== head(xs), xs)));
            }
            const unique_list = remove_dups(combined);
            const difference = length(combined) - length(unique_list);
            return difference;
        /*for (let i = 0; i < length(sorted_nums); i = i + 1) {
            if (list_ref(sorted_nums, i) === list_ref(sorted_nums, i + 1)) {
                counter = counter + 1; 
            }
        } */
    }
    return counter;
}



////////////////////////////////////////////////////////////
// Question 2D
////////////////////////////////////////////////////////////

function check_winning_group(bet_nums, draw_nums, extra_num) {

    // WRITE HERE.
    const len = length(bet_nums);
    const extra = member(extra_num, bet_nums);
    if (is_null(bet_nums) || is_null(draw_nums) || is_null(extra_num)) {
        return null;
    } else if (num_of_matches(bet_nums, draw_nums) === len) {
        return 1;
    } else if (num_of_matches(bet_nums, draw_nums) === len - 1 && length(extra) !== 0) {
        return 2;
    } else if (num_of_matches(bet_nums, draw_nums) === len - 2 && length(extra) !== 0) {
        return 4;
    } else if (num_of_matches(bet_nums, draw_nums) === len - 1) {
        return 3;
    } else if (num_of_matches(bet_nums, draw_nums) === len - 2) {
        return 5;
    } else {
        return 0;
    }
}

const bet_nums = list(40, 30, 1, 49, 27, 15);
const draw_nums = list(23, 1, 30, 15, 40, 49);
const extra_num = 27;
display(check_winning_group(bet_nums, draw_nums, extra_num));


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
    display(test_name + ": " + (f() ? "PASS" : "FAIL <<< "));
}
//===========================================================



////////////////////////////////////////////////////////////
// Test Cases for Q2A
////////////////////////////////////////////////////////////

assert(
    () => {
        const nums = list(23);
        return equal(all_different(nums), true);
    },
    "Q2A-T1",
    ['all_different']
);

assert(
    () => {
        const nums = list(2, 5, 1, 6, 7, 4, 3);
        return equal(all_different(nums), true);
    },
    "Q2A-T2",
    ['all_different']
);

assert(
    () => {
        const nums = list(2, 6, 1, 7, 6, 4, 3);
        return equal(all_different(nums), false);
    },
    "Q2A-T3",
    ['all_different']
);

assert(
    () => {
        const nums = list(3, 2);
        return equal(all_different(nums), true);
    },
    "Q2A-T4",
    ['all_different']
);

assert(
    () => {
        const nums = list(3, 2, 1, 9, 8);
        return equal(all_different(nums), true);
    },
    "Q2A-T5",
    ['all_different']
);

assert(
    () => {
        const nums = list(2, 6, 3, 7, 6, 6, 3, 1);
        return equal(all_different(nums), false);
    },
    "Q2A-T6",
    ['all_different']
);



////////////////////////////////////////////////////////////
// Test Cases for Q2B
////////////////////////////////////////////////////////////

assert(
    () => {
        const nums = list(5, 1, 8, 49);
        const n = 6;
        const min = 1;
        const max = 49;
        return equal(is_valid_toto_set(nums, n, min, max), false);
    },
    "Q2B-T1",
    ['is_valid_toto_set']
);

assert(
    () => {
        const nums = list(25, 13, 2, 31, 30, 3, 15);
        const n = 7;
        const min = 3;
        const max = 30;
        return equal(is_valid_toto_set(nums, n, min, max), false);
    },
    "Q2B-T2",
    ['is_valid_toto_set']
);

assert(
    () => {
        const nums = list(25, 13, 8, 14, 30, 3, 8);
        const n = 7;
        const min = 3;
        const max = 30;
        return equal(is_valid_toto_set(nums, n, min, max), false);
    },
    "Q2B-T3",
    ['is_valid_toto_set']
);

assert(
    () => {
        const nums = list(25, 13, 8, 14, 30, 3, 15);
        const n = 7;
        const min = 3;
        const max = 30;
        return equal(is_valid_toto_set(nums, n, min, max), true);
    },
    "Q2B-T4",
    ['is_valid_toto_set']
);

assert(
    () => {
        const nums = list(40, 20, 30, 15, 10);
        const n = 5;
        const min = 10;
        const max = 40;
        return equal(is_valid_toto_set(nums, n, min, max), true);
    },
    "Q2B-T5",
    ['is_valid_toto_set']
);

assert(
    () => {
        const nums = list(40, 20, 30, 15, 40);
        const n = 5;
        const min = 10;
        const max = 40;
        return equal(is_valid_toto_set(nums, n, min, max), false);
    },
    "Q2B-T6",
    ['is_valid_toto_set']
);



////////////////////////////////////////////////////////////
// Test Cases for Q2C
////////////////////////////////////////////////////////////

assert(
    () => {
        const numsA = list(23, 21, 30, 15, 40);
        const numsB = list(3, 29, 40, 15, 20 );
        return equal(num_of_matches(numsA, numsB), 2);
    },
    "Q2C-T1",
    ['num_of_matches']
);

assert(
    () => {
        const numsB = list(23, 21, 30, 15, 40);
        const numsA = list(3, 29, 40, 15, 20);
        return equal(num_of_matches(numsA, numsB), 2);
    },
    "Q2C-T2",
    ['num_of_matches']
);

assert(
    () => {
        const numsA = list(23, 21, 30, 15, 40);
        const numsB = list(31, 29, 41, 16, 20);
        return equal(num_of_matches(numsA, numsB), 0);
    },
    "Q2C-T3",
    ['num_of_matches']
);

assert(
    () => {
        const numsA = list(23, 21, 30, 15, 40, 4, 2, 1);
        const numsB = list(1, 21, 23, 30, 4, 15, 2, 40);
        return equal(num_of_matches(numsA, numsB), 8);
    },
    "Q2C-T4",
    ['num_of_matches']
);

assert(
    () => {
        const numsA = list(2, 1, 30, 15);
        const numsB = list(31, 29, 41, 16);
        return equal(num_of_matches(numsA, numsB), 0);
    },
    "Q2C-T5",
    ['num_of_matches']
);

assert(
    () => {
        const numsA = list(2, 1, 30, 15);
        const numsB = list(15, 29, 2, 16);
        return equal(num_of_matches(numsA, numsB), 2);
    },
    "Q2C-T6",
    ['num_of_matches']
);

assert(
    () => {
        const numsA = list(23, 21, 30, 15, 40, 4, 2, 1, 35);
        const numsB = list(1, 21, 23, 35, 30, 4, 15, 2, 40);
        return equal(num_of_matches(numsA, numsB), 9);
    },
    "Q2C-T7",
    ['num_of_matches']
);



////////////////////////////////////////////////////////////
// Test Cases for Q2D
////////////////////////////////////////////////////////////

assert(
    () => {
        const bet_nums = list(40, 30, 1, 49, 23, 15);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 1);
    },
    "Q2D-T1",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(40, 30, 1, 49, 27, 15);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 2);
    },
    "Q2D-T2",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(40, 30, 1, 49, 17, 15);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 3);
    },
    "Q2D-T3",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(40, 27, 1, 49, 17, 15);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 4);
    },
    "Q2D-T4",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(40, 37, 1, 49, 17, 15);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 5);
    },
    "Q2D-T5",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(40, 37, 1, 49, 17, 27);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 0);
    },
    "Q2D-T6",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(21, 32, 1, 49, 27, 15, 3);
        const draw_nums = list(21, 30, 1, 49, 27, 15, 3);
        const extra_num = 32;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 2);
    },
    "Q2D-T7",
    ['check_winning_group']
);

assert(
    () => {
        const bet_nums = list(41, 37, 2, 48, 17, 27);
        const draw_nums = list(23, 1, 30, 15, 40, 49);
        const extra_num = 27;
        return equal(check_winning_group(bet_nums, draw_nums, extra_num), 0);
    },
    "Q2D-T8",
    ['check_winning_group']
);
