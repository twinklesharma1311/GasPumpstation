/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( document ).ready(function() {

creditcardjs.onValidityChange(function(isValid) {
  if (isValid) {
    console.log('true');
    
    
  } else {
    /* prevent form submission */
    console.log('false  ');
  }
});


});



