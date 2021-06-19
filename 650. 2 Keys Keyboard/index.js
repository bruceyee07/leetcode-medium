/**
 * @description https://leetcode.com/problems/2-keys-keyboard/
 * @param {number} n
 * @return {number}
 */
var minSteps = function(n) {
  var steps = 0;
  var divisor = 2;

  while (n > 1) {
    while (n % divisor === 0) {
      steps += divisor;
      n /= divisor;
    }

    divisor++;
  }

  return steps;
};