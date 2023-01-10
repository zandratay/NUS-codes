function isValidNRIC(nric) {
  // parsing part of the nric string
  var firstLetter = nric.substring(0, 1); 
  var num1 = parseInt(nric.substring(1, 2));
  var num2 = parseInt(nric.substring(2, 3));
  var num3 = parseInt(nric.substring(3, 4));
  var num4 = parseInt(nric.substring(4, 5));
  var num5 = parseInt(nric.substring(5, 6));
  var num6 = parseInt(nric.substring(6, 7));
  var num7 = parseInt(nric.substring(7, 8));
  var lastLetter = nric.substring(8, 9);

  var w1 = num1 * 2;
  var w2 = num2 * 7;
  var w3 = num3 * 6;
  var w4 = num4 * 5;
  var w5 = num5 * 4;
  var w6 = num6 * 3;
  var w7 = num7 * 2;

  var sum = w1 + w2 + w3 + w4 + w5 + w6 + w7;

  var revisedSum = 0;

  if (firstLetter === "T" || firstLetter == "G") {
    revisedSum = sum + 4;
  } else {
    revisedSum = sum;
  }

  var eleven = 11;
  var remainder = revisedSum % eleven;

  var checkedLastLetter = "Z";

  if (firstLetter == "S" || firstLetter == "T") {
    checkedLastLetter = lastLetterMapperST2(remainder);
  } else { // firstLetter == "F" || "G"
    checkedLastLetter = lastLetterMapperFG2(remainder);
  }

  return checkedLastLetter == lastLetter;

  //return sum + " " + revisedSum;
}
