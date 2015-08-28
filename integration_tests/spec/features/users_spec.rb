require File.join(File.dirname(__FILE__), '../spec_helper')

describe 'the unit.users api', :type => :feature do
    describe 'GET /unit.users' do
        it 'returns a list of unit.users' do
            resp = HTTParty.get('http://localhost:8080/core/unit.users')

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