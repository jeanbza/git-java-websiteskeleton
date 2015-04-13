require 'sinatra'

class Simulator < Sinatra::Base
    get '/hi' do
        'Hello World!'
    end
end