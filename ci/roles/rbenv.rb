name 'rbenv'
description 'Instaal rbenv, ruby, bundler'
default_attributes(
    "rbenv" => {
        "user_installs" => {
            'user' => 'vagrant',
            'rubies' => '2.2.0',
            'global' => '2.2.0',
            'gems' => {
                '2.2.0' => [
                    {
                        'name' => 'bundler',
                        'version' => '1.9.4'
                    }
                ]
            }
        }
    }
)
run_list(
    'recipe[rbenv]'
)
# "json_class": "Chef::Role",
# "default_attributes": {
# },
# "override_attributes": {
#   "languages": {
#     "ruby": {
#       "default_version": "1.8"
#     }
#   }
# },
# "chef_type": "role",
# "run_list": [
#   "recipe[ruby]"
# ]