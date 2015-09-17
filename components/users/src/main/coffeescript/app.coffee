domready = require('domready')
messages = require('./messages.coffee')

domready ->
  messages.sayHi()
