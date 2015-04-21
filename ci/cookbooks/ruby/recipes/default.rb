include_recipe 'libyaml'
include_recipe 'libffi'
include_recipe 'rbenv'
include_recipe 'rbenv::ruby_build'

ruby_ver = '2.2.0'

ENV['LD_LIBRARY_PATH'] = '/usr/local/lib'

# Install ruby
rbenv_ruby ruby_ver

# Install bundler
rbenv_gem 'bundler' do
    ruby_version ruby_ver
end

execute "set ruby global version to #{ruby_ver}" do
    command "rbenv global #{ruby_ver}"
end

execute 'open up rbenv directory for jenkins to use' do
    command 'chmod -R 777 /opt/rbenv'
    user 'root'
end