name 'ruby'
description 'Install Ruby and everything needed for capybara-webkit'
run_list(
    'recipe[yum-epel]',
    'recipe[libyaml]',
    'recipe[libffi]',
    'recipe[ruby]'
)