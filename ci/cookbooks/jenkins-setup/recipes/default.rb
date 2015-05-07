include_recipe 'jenkins::master'

jenkins_plugin 'git'
jenkins_plugin 'gradle'

create_test_jobs('Skeleton', 'https://github.com/jadekler/git-spring-websiteskeleton.git')

cookbook_file 'credentials.xml' do
    owner 'jenkins'
    group 'jenkins'
    mode '0644'
    path '/var/lib/jenkins/credentials.xml'
end

def create_test_jobs(app_name, git_repo)
    build_job = File.join(Chef::Config[:file_cache_path], "#{app_name}-build-job.xml")

    # PLEASE NOTE: You WILL need to set up your own credentials
    template build_job do
        source 'build-job.xml.erb'
        variables({:git_repo => git_repo})
    end

    jenkins_job "#{app_name}Build" do
        config build_job
    end

    template integration_job do
        source 'integration-job.xml.erb'
        variables({:app_name => app_name})
    end
end