# Credit for basic simulator idea goes to https://gist.github.com/juliocesar/639636

require 'sinatra'

class Simulator < Sinatra::Base
    get '/hi' do
        $simulator_response
    end
end