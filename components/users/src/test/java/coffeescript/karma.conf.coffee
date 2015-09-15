module.exports = (config) ->
  config.set
    reporters: ['dots']

    preprocessors:
      '**/*.coffee': ['coffee']

    autoWatch: true
    basePath: '../'
    frameworks: ['jasmine']
    exclude: []
    port: 8080

  # Start these browsers, currently available:
  # - Chrome
  # - ChromeCanary
  # - Firefox
  # - Opera
  # - Safari (only Mac)
  # - PhantomJS
  # - IE (only Windows)
    browsers: [
      'PhantomJS'
    ]

  # Which plugins to enable
    plugins: [
      'karma-coffee-preprocessor',
      'karma-phantomjs-launcher',
      'karma-jasmine',
      'karma-spec-reporter'
    ]

  # Continuous Integration mode
  # if true, it capture browsers, run tests and exit
  # singleRun: true,
    colors: true

  # level of logging
  # possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
    logLevel: config.LOG_INFO