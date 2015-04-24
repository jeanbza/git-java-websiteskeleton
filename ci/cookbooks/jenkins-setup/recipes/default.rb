include_recipe 'jenkins::master'

jenkins_plugin 'git'
jenkins_plugin 'gradle'

skeleton_build = File.join(Chef::Config[:file_cache_path], 'skeleton-build-job.xml')

template skeleton_build do
    source 'build-job.xml.erb'
    variables({
      :git_repo => 'https://github.com/jadekler/git-spring-websiteskeleton.git'
    })
end

jenkins_job 'SkeletonBuild' do
    config skeleton_build
end