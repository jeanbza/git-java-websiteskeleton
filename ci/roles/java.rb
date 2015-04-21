name 'java'
description 'Install Oracle Java'
default_attributes(
    'java' => {
        'install_flavor' => 'oracle',
        'jdk_version' => '8',
        'oracle' => {
            'accept_oracle_download_terms' => true
        }
    }
)
run_list(
    'recipe[java]'
)