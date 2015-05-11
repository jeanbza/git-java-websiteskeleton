# Credit for basic simulator idea goes to https://gist.github.com/juliocesar/639636

require 'sinatra'

class FooSimulator < Sinatra::Base
    set :port, 8081

    get '/hi' do
        'hello world'
    end
end