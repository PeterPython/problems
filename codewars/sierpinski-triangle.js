// Codewars problem: Sierpinski Triangle (Javascript)
// Link: http://www.codewars.com/kata/sierpinskis-gasket

function sierpinski(n) {
  return (sierpinskiArray(n).join('\n'));
}

// Recursive function to make Sierpinski triangle in array format
function sierpinskiArray(n) {
  var triangle = []; 
  var space;  // White space between Ls

  if(n == 0) {
    triangle[0] = "L";
    return triangle;
  } else if(n > 0) {
    triangle = sierpinskiArray(n-1); // Make a copy of triangle array from recursion
    var size = triangle.length;

    for(var i=0; i<size; i++) {
      space = " ";

      // Number of white spaces is equal to the array size-1-i
      for(var j=0; j<size-1-i; j++) {
        space += "  ";
      }

      // Concatenate copy of arrays with adjusted space in between
      triangle[i+size] = triangle[i] + space + triangle[i];
    }

      return triangle;
  }
}


// Notes
// alert(sierpinski(3));

// L
// L L
// L   L
// L L L L
// L       L
// L L     L L
// L   L   L   L
// L L L L L L L L
// L               L
// L L             L L
// L   L           L   L
// L L L L         L L L L
// L       L       L       L
// L L     L L     L L     L L
// L   L   L   L   L   L   L   L
// L L L L L L L L L L L L L L L L 