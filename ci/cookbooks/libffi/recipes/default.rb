rpmforge_path = File.expand_path('../../config/rpmforge.repo', __FILE__)

file '/etc/yum.repos.d/rpmforge.repo' do
    owner 'root'
    group 'root'
    mode '0600'
    action :create
    content File.open(rpmforge_path, 'rb').read
end

execute 'Download the the rpmforge gpg key' do
    command 'rpm --import http://apt.sw.be/RPM-GPG-KEY.dag.txt'
end

execute 'Install libffi-devel via yum' do
    command 'yes | yum install libffi-devel'
end