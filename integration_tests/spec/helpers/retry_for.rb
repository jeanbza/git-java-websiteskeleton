def retry_for(seconds = 10, &block)
    begin
        block.call
        print "\r "
    rescue Exception => e
        if seconds > 0
            print "\rRetry #{seconds} more seconds.."

            sleep 1
            retry_for(seconds-1, &block)
        else
            puts 'Failed'

            raise e
        end
    end
end