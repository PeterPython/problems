snail = function(array) {

  if(array.length > 1) {
    var area = array.length * array.length; // Total number of elements in array
    var size = array.length-1; // Size of array
    var sizeUp = array.length;    // Size when going Up
    var sizeRight = array.length;   // Size when going Right
    var sizeLeft = array.length;    // Size when going Left
    var sizeDown = array.length;    // Size when going Down
    var snail = [];   // Snail array
    var r = 0;   // row
    var c = 0;   // column
    
    // For loop runs the same number of times as the number of elements
    for(var i=0; i<area; i++) {

      // Going right
      if((c < sizeRight) && (c != sizeUp) && (sizeRight == sizeLeft)) {
        snail[i] = array[r][c];
        c++;
        if(c == sizeRight) {
          sizeUp--; // 3
          c = sizeRight-1;   // c is 3 and sizeRight is 4
        }
      }

      // Going down
      if((r < sizeDown) && (c == sizeUp) && (r != sizeRight)) {
        snail[i] = array[r][c];
        r++;
        if(r == sizeDown) {    // r and sizeDown = 4
          sizeRight--;  //  3
          r = sizeDown-1; // r is 3 and sizeDown is 4
        }// [r,c] = [3,3]
      }

      // Going left
      if((r == sizeRight) && (c > size-sizeLeft) && (sizeRight != sizeDown)) {
        snail[i] = array[r][c];
        c--;    // -1
        if(c == size-sizeLeft) { // -1 = -1
          sizeDown--; // sizeDown 3
          c = size-sizeLeft+1;    // c=0
        }
      } // [r,c] = [3,0]
    
      // Going Up
      if( (c == size-sizeLeft+1) && (r > size-sizeUp) && (sizeDown != sizeLeft)) {
        snail[i] = array[r][c];
        r--;    // 0
        if(r == size-sizeUp) { // 0 = 0
          sizeLeft--; // sizeLeft 3
          r = size-sizeUp+1;    // r=1
          c++;
        }
      }

    }
    return snail;
  } else {
    return array[0];
  }
}

// Notes
// Going right will affect the next going Up . So going up -1
// Going down will affect the next going right . So going right -1
// Going left will affect the next going down . So going down -1
// Going up will affect the next going left . So going left -1
// alert(i + "[" + r + "," + c +"]");
// alert(c +"<" + sizeRight + " " + c + "!=" +sizeUp + " " + sizeRight + "==" + sizeLeft + " ");

// var array1 =   [[1,2,3,4],
//              [12,13,14,5],
//              [11,16,15,6],
//              [10,9,8,7]];

// var array = [[1,2,3,4,5],
//          [16,17,18,19,6],
//          [15,24,25,20,7],
//          [14,23,22,21,8],
//          [13,12,11,10,9]];
