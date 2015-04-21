name 'rbenv'
default_attributes(
    'rbenv' => {
        'rubies' => ['2.2.0-dev'],
        'global' => '2.2.0-dev',
        'gems' => {
            '2.2.0-dev' => [
                {
                    'name' => 'bundler',
                    'version' => '1.9.4'
                }
            ]
        }
    }
)
run_list(
    'recipe[ruby_build]',
    'recipe[rbenv::system_install]'
)