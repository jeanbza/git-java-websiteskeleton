require 'capybara/rspec'
require 'capybara/webkit'
require 'httparty'

RSpec.configure do |config|
    config.filter_run :focus
    config.run_all_when_everything_filtered = true
    config.default_formatter = 'doc'
    config.order = :random
end

Capybara.default_driver = :webkit
Capybara.app_host = "http://localhost:8080/core"