// fucntion to calculate fibonacci number
function fibonacci(n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// function to get element from list that is the lowest value
function getLowestValue(list) {
    var lowest = list[0];
    for (var i = 1; i < list.length; i++) {
        if (list[i] < lowest) {
            lowest = list[i];
        }
    }
    return lowest;
}



