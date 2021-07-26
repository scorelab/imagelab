Blockly.Extensions.register('file_button', function () {
  this.getField('file_browse').clickHandler_ = (() => {
    // var fileSelector = document.createElement('input');
    // fileSelector.setAttribute('type', 'file'); // another approach to include a file selector, too.
    // fileSelector.click();
    var input = document.getElementById('inputImage');
    input.click();
  })
});

Blockly.Extensions.register('folder_button', function () {
  this.getField('folder_browse').clickHandler_ = (() => {
    var output = document.getElementById('outputDirectory');
    output.click();
  })
});