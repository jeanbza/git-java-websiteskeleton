require 'bundler'
require 'rubygems'

Bundler.require :default

require 'sinatra'

require 'helpers/retry_for'
require 'simulators/simulator_helper'
include SimulatorSpecHelper

Capybara.default_driver = :webkit
Capybara.app_host = 'http://localhost:8080/core'

RSpec.configure do |config|
    config.filter_run :focus
    config.run_all_when_everything_filtered = true
    config.default_formatter = 'doc'
    config.order = :random
    config.include Capybara::DSL

    Kernel.srand config.seed

    SimulatorSpecHelper.run_simulator
end

