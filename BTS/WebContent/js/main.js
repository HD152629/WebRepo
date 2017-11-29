var $input = $('.datepicker').pickadate()

//Use the picker object directly.
var picker = $input.pickadate('picker')
// Using a string along with the parsing format (defaults to `format` option).
/* 날짜 입력 */	
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Today',
    clear: 'Clear',
    close: 'Ok',
    closeOnSelect: false, // Close upon selecting a date,
    
  });
