var domready = require("domready");
var messages = require('./messages');

domready(function () {
    messages.sayHi();
});
