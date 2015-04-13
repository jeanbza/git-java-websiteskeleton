require 'bundler'
require 'rubygems'

Bundler.require :default

require 'sinatra'
require 'simulator'

Capybara.app = Simulator
Capybara.default_driver = :webkit
Capybara.app_host = "http://localhost:8080/core"
Capybara.server_port = 8081

RSpec.configure do |config|
    config.filter_run :focus
    config.run_all_when_everything_filtered = true
    config.default_formatter = 'doc'
    config.order = :random
    config.include Capybara

    Kernel.srand config.seed
end