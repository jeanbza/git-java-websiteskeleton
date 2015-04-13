require 'sinatra'

class Simulator < Sinatra::Base
    get '/hi' do
        $simulator_response
    end
end