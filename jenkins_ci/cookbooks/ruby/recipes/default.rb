include_recipe 'rbenv'
include_recipe 'rbenv::ruby_build'

ruby_ver = '2.2.0'

ENV['LD_LIBRARY_PATH'] = '/usr/local/lib'

# Install qt
yum_package 'qtwebkit-devel.x86_64'

link '/usr/bin/qmake' do
    to '/usr/lib64/qt4/bin/qmake'
end

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

execute 'add LD_LIBRARY_PATH to vagrant bash profile' do
    command "echo 'export LD_LIBRARY_PATH=/usr/local/lib' >> /home/vagrant/.bash_profile"
end