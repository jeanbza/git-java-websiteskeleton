name 'jenkins'
description 'set up jenkins for this project'
default_attributes(
    'jenkins' => {
        'master' => {
            'port' => '9090'
        }
    }
)
run_list(
    'recipe[jenkins-setup]'
)