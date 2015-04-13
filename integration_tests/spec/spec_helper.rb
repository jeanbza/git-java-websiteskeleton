require 'capybara/rspec'
require 'capybara/webkit'
require 'capybara/dsl'
require 'bundler'
require 'rubygems'

require 'sinatra'
Bundler.require :default

require 'simulator'

Capybara.app = Simulator

# Capybara.default_driver = :webkit
# Capybara.app_host = "http://localhost:8080/core"
# Capybara.app = Simulator
# Capybara.server_port = 8081
# Capybara.run_server = true

RSpec.configure do |config|
    config.filter_run :focus
    config.run_all_when_everything_filtered = true
    config.default_formatter = 'doc'
    config.order = :random
    config.include Capybara

    Kernel.srand config.seed
end