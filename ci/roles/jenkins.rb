name 'jenkins'
description 'set up jenkins for this project'
run_list(
    'recipe[jenkins-setup]'
)