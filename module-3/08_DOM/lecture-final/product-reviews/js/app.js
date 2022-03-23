const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/*
Build this div and children for each review in the array:

<div class="review">
  <h4>Reviewer's Name</h4>
  <div class="rating">
      <img src="img/star.png" class="ratingStar" />
      <img src="img/star.png" class="ratingStar" />
      <img src="img/star.png" class="ratingStar" />
  </div>
  <h3>Title</h3>
  <p>Review itself</p>
</div> 

Attach the new review div to div#main
*/



/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
    const pageTitle = document.getElementById('page-title');
    pageTitle.querySelector('.name').innerText= name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const main = document.getElementById('main');

  reviews.forEach( review => {
    // Create a new Div
    const reviewDiv = document.createElement('div');
    // Set its class to review
    reviewDiv.classList.add('review');

    // add reviewer
    addReviewer(reviewDiv, review.reviewer);
    // add rating
    addRating(reviewDiv, review.rating);
    // add review title
    addTitle(reviewDiv, review.title);
    // add review
    addReview(reviewDiv, review.review);

    // Attach the new div as a child of main
    main.insertAdjacentElement('beforeend', reviewDiv);
  });
}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
    const reviewerH4 = document.createElement('h4');
    reviewerH4.innerText = name;
    parent.appendChild(reviewerH4);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // Create a new Div
  const ratingDiv = document.createElement('div');
  // Give the div a class rating
  ratingDiv.classList.add('rating');
  // create 1 img for each numberOfStars
  for (let n = 0; n < numberOfStars; n++) {
    const starImg = document.createElement('img');
    // set the img src to img/star.png
    starImg.src = 'img/star.png';
    // set the img class to ratingStar
    starImg.classList.add('ratingStar');
    // Attach the star img to the rating div
    ratingDiv.appendChild(starImg);
  }
  // Attach the rating div to the parent
  parent.appendChild(ratingDiv);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  // Create an h3
  const titleH3 = document.createElement('div');
  // Set the text of the new h3 to the title
  titleH3.innerText = title;
  // append the h3 to the parent div
  parent.appendChild(titleH3);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  // Create a p
  const reviewParagraph = document.createElement('p');
  // set the text of the new p to the review
  reviewParagraph.innerText = review;
  // append the new p to the parent div
  parent.appendChild(reviewParagraph);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
