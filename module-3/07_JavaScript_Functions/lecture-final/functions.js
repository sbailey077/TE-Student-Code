// function doubleSum(x, y) {
//     return (x + y) * 2;
// }


const doubleSum = function (x, y) {
    return (x + y) * 2;
}

let anotherName = doubleSum;
console.log( anotherName(2, 4) );

// const tripleSum = function (x, y) {
//     return (x + y) * 3;
// }

const tripleSum =  (x, y) => {
    return (x + y) * 3;
}
const u = tripleSum;
u(2, 3);

function doublesOutput(func, x, y) {
    return func(x, y) * 2;
}
console.log( doublesOutput(doubleSum, 2, 4) );

function thisFunctionHasAName( param1, param2 ) {
    return param1 + param2;
}

const thisFunctionDoesNotHaveAName = function (param1, param2) {
    return param1 + param2;
}

const thisFunctionDoesNotOrFunctionKeyword = (param1, param2) => {
    return param1 + param2;
}

/*
    Array forEach()
*/
const nums = [10,20,30,40,50];

let sum = 0;
for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
}
console.log("Sum " + sum);

let sum2 = 0;
const funcToSum = (value) => {
    sum2 += value;
}
nums.forEach(funcToSum);
console.log("Sum by forEach: " + sum2 );

nums.forEach( (value, index) => {
    console.log(`${value} is at index ${index}`);
} );


/*
    Array reduce()
*/
const sumByReduce = nums.reduce( (onGoingSum, currentValue) => {
    return onGoingSum += currentValue;
}, 0);
console.log("out of sumByReduce: " + sumByReduce);


const instructor = ["John", "Matt", "Steve", "Rachelle", "Dan"];
const outputOfReduce = instructor.reduce( (newString, currentValue, currentIndex) =>{
    // if ( currentIndex === 0 )
    if (!currentIndex) {
        return newString + currentValue.toUpperCase();
    } else {
        return newString + ", " + currentValue.toUpperCase();
    }
    //return newString + (currentIndex === 0 ? "" : ", ") +  currentValue.toUpperCase()
}, '' );
console.log( outputOfReduce );

/*
    Array map()
*/

/*
Create a new array that doubles every item at that index
[ 10 ]   x2       [ 20 ]
[ 20 ]   x2       [ 40 ]
[ 30 ]   x2       [ 60 ]
*/

const newArray = nums.map( (currentValue) => {
    return currentValue * 2;
});

console.log("Original Array: ")
console.table(nums);
console.log("Mapped Array of double values: ");
console.table(newArray);

function fizzBuzz() {
    const arrToFizz = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
    const fizzBuzzed = arrToFizz.map( currentValue => {
        //if (currentValue % 5 === 0 && currentValue % 3 === 0) {
        if (!(currentValue % 5) && !(currentValue % 3)) {
            return 'FizzBuzz';
        }
        // if (currentValue % 3 === 0) {
        if (!(currentValue % 3)) {
            return 'Fizz';
        }
        //if (currentValue % 5 === 0) {
        if (!(currentValue % 5)) {
            return 'Buzz';
        }
        return currentValue;
    });

    console.table(fizzBuzzed);
}

/*
    Array filter() 
*/
const arrOfNumbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

let arrayWithOnlyOdds  = arrOfNumbers.filter( currentValue => {
    if (currentValue % 2) {
        return true;
    } 
    return false;
});

console.table(arrayWithOnlyOdds);

/*
    Chaining functional methods
*/
/*
    For an Array of numbers, find the sum of all numbers in the array multiplied by 10, but
    only for numbers that are not a multiple of 3
*/
function chainingFunctionalMethods() {

    const finalSum = arrOfNumbers.filter( currentValue => {
        if (currentValue % 3 === 0) {
            return false;
        }
        return true;
    }).map( currentValue => {
        return currentValue * 10;
    }).reduce ( (ongoingSum, currentValue) => {
        return ongoingSum += currentValue;
    }, 0);

    console.log(finalSum);

}