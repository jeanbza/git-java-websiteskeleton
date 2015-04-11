require File.join(File.dirname(__FILE__), '../spec_helper')

describe 'the products api', :type => :feature do
    describe 'GET /products' do
        it 'returns a list of products' do
            resp = HTTParty.get('http://localhost:8080/core/products')

            expect(resp.code).to eq 200
            expect(JSON.parse(resp.body)).to eq [{"name" => 'Super Glue'}, {"name" => 'Kool-Aide'}]
        end
    end
end