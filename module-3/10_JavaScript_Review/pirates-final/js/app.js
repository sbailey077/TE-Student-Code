/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {
     
        if (event.key === 'ArrowRight') {
            moveShipRight();
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });
});


/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, down);
}

function moveShipUp() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, down);
}

function moveShip(shipElement, newElement) {
    if (isWin(newElement)) {
        win();
    } else if (isLoss(newElement)) {
        lose("You sunk!");
    } else if (canMoveToElement(newElement)) {
        shipElement.classList.remove('boat');
        newElement.classList.add('boat');
    }
}

function getElementAtSameIndex(ship, newParent) {
    let elementAtIndex = null;
    if (newParent != null) {
        const index = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParent.childNodes[index];
    }
    return elementAtIndex;
}

function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
}


function canMoveToElement(element) {
    if (element === null || element.classList.contains('pirate') 
        || element.classList.contains('iceberg')) {
        return false;
    }
    return true;
}




/*
  Win Conditions
*/
function isWin(nextLocation) {
    if (nextLocation && nextLocation.classList.contains('treasure')) {
        return true;
    }
    return false;
}

function win() {
    finishGameMessage('You win!');
}



/*
    Loss Conditions
*/
function isLoss(nextLocation) {
    if (nextLocation && (nextLocation.classList.contains('pirate') 
    || nextLocation.classList.contains('iceberg'))) {
        return true;
    }
    return false;
} 

function lose(message) {
    const lastShipLocation = finishGameMessage(message);

    lastShipLocation.classList.add('boat_explosion');
    // setTimeout( methodToCallWhenTheTimerExpires, millisecondsToWait)
    setTimeout( () => {
        lastShipLocation.classList.remove('boat_explosion');
        lastShipLocation.classList.add('boat_sunk')
    }, 500);
    
}

function finishGameMessage(message) {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = message;
    const shipLocation = getShipLocation();
    shipLocation.classList.remove('boat');
    clearInterval(clock);
    return shipLocation;
}

/**
 * Reset the Game
 */
function resetGame() {
    createObstacles();

    resetBoat();

    const announce = document.querySelector('.announce');
    announce.innerText = 'Play!';
    announce.classList.remove('winText');

    // Set the starting location of the boat
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');

    clock = setInterval(runTick, 1000);
}

function resetBoat() {
    const ship = getShipLocation();
    if (ship) {
        ship.classList.remove('boat');
    }
    const sunkShip = document.getElementById('frame').querySelector('.boat_sunk');
    if (sunkShip) {
        sunkShip.classList.remove('boat_sunk');
    }
}

/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame = document.getElementById('frame');

    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');

    // Add the row class to the row div
    row.classList.add('row');

    // Append the row div to the game board (frame)
   frame.appendChild(row);

    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square
   const square = document.createElement('div');
   // Add the square class to the div
   square.classList.add('square');
   // Insert the square at the end of the row
  row.appendChild(square);
}


function createObstacles() {
    // get a reference to the frame
    // loop through every cell and call
    //  addObstacles to determine what should be in it
    const rows = document.getElementById('frame').children;
    const rowsArray = Array.from(rows);

    rowsArray.forEach( (row, rowIndex) => {
        const square = row.children;
        Array.from(square).forEach( (cell, cellIndex) => {
            if ( !(rowIndex === 0 && cellIndex === 0) &&
                !(rowIndex === rows.length - 1 && cellIndex === square.length - 1)) {
                    addObstacles(cell);
                }
        });
    });
}

/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg');
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate');
    } 
}


/*
  Move the Pirates
*/
function runTick() {
    const pirates = document.querySelectorAll('.pirate');

    Array.from(pirates).forEach( pirate => {
        // Get a random number between 0 and 4
        const randNumber = getRandomNumber(4, true);

        // Get the new location the pirate will be going
        const newLocation = getPiratesNextPosition(pirate, directions[randNumber]);
        // Determine if the pirate won
        // Move the pirate, if they pirate can move there
        if (isPirateWin(newLocation)) {
            lose('You were sunk by a pirate');
        } else if (canPirateMoveToNewLocation(newLocation)) {
            pirate.classList.remove('pirate');
            newLocation.classList.add('pirate');
        }
    });
}

function isPirateWin(newLocation) {
    return newLocation && newLocation.classList.contains('boat');
}

function canPirateMoveToNewLocation(newLocation) {
    return canMoveToElement(newLocation) && !newLocation.classList.contains('treasure');
}

function getPiratesNextPosition(pirate, direction) {
    let newCell;

    switch(direction) {
        case 'up':
            newCell = getElementAtSameIndex(pirate, pirate.parentElement.previousElementSibling);
            break;
        case 'right':
            newCell = pirate.nextElementSibling;
            break;
        case 'down':
            newCell = getElementAtSameIndex(pirate, pirate.parentElement.nextElementSibling);
            break;
        case 'left':
            newCell = pirate.previousElementSibling;
            break;
    }

    return newCell;
}


function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
