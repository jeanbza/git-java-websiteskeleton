require File.join(File.dirname(__FILE__), '../spec_helper')

describe 'the users api', :type => :feature do
    describe 'GET /users' do
        it 'returns a list of users' do
            resp = HTTParty.get('http://localhost:8080/core/users')

            expect(resp.code).to eq 200
            expect(JSON.parse(resp.body)).to eq [{"name" => 'Bob'}, {"name" => 'Sue'}]
        end
    end
end

describe 'the home page', :type => :feature do
    describe 'GET /' do
        it 'shows the home page' do
            visit '/'
            expect(page).to have_content 'Hello world!'
        end
    end
end