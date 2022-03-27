/*
 * Given 2 strings, return their concatenation, except omit
 * the first char of each. The strings will be at least length 1.
 *   nonStart("Hello", "There") -> "ellohere"
 */
function nonStart(word1, word2) {
 const wordOne = word1.substring(1);
 const wordTwo = word2.substring(1);
 const newWord = wordOne + wordTwo;
 return newWord;
}
