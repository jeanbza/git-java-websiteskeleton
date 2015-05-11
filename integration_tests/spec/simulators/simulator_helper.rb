require_relative 'foo_simulator'

module SimulatorSpecHelper
    def run_simulator
        unless $foo_simulator
            $foo_simulator = FooSimulator

            pid = fork do
                STDERR.reopen('foo-simulator.err')
                STDOUT.reopen('foo-simulator.log')
                $foo_simulator.run!
            end

            at_exit { Process.kill('TERM', pid) }

            puts 'Waiting for foo simulator to spin up..'
            retry_for(5) {
                HTTParty.get('http://localhost:8081/hi')
            }
            puts 'Foo simulator is up'
        end
    end
end