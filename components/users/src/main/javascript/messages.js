var config = require('./config');

module.exports = {
    greeting: "Hello from the script of JavaScript",
    sayHi: function () {
        console.log(this.greeting);
        console.log("The current apiUrl is " + config.apiUrl);
    }
};