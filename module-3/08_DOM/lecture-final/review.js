const addNumbers =  (x, y) => {
    return x + y;
};
console.log(addNumbers(2,3));

const anotherName = addNumbers;

anotherName(2,3);

const ourObject = {
    name: '',
    age: 0,
    addNumbers: anotherName
}

ourObject.addNumbers(2,3);

function getResult(otherFunction) {
    return otherFunction(2, 3);
}

/*
    [ 10 ]
    [ 25 ]
    [ 3  ]

    reduction to sum: 38
    reduction to max: 25
    reduction to comma separated string:  '10,25,3'
*/

const ourArray = [ 10, 25, 3 ];
// reduce to a sum of all the numbers in the array

const reductionToSum = ourArray.reduce( ( onGoingSum, nextNumber) => {
    return onGoingSum += nextNumber;
}, 0);

const ourReducedString = ourArray.reduce ( (strBeingBuilt, nextValue) => {
    if (nextValue < 20) {
        return strBeingBuilt + ',' + String(nextValue);
    }
    return strBeingBuilt;
}, 'This is the start our String: ');

console.log(ourReducedString);
