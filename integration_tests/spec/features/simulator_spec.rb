require File.join(File.dirname(__FILE__), '../spec_helper')

describe 'simulator', :type => :feature do
    it 'works' do
        visit 'http://localhost:8081/hi'

        expect(page).to have_content 'Hello World!'
    end
end