package site.tsun.filteraspectinterceptor.filter

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class TimeFilter : Filter {
    /**
     * The `doFilter` method of the Filter is called by the container
     * each time a request/response pair is passed through the chain due to a
     * client request for a resource at the end of the chain. The FilterChain
     * passed in to this method allows the Filter to pass on the request and
     * response to the next entity in the chain.
     *
     *
     * A typical implementation of this method would follow the following
     * pattern:- <br></br>
     * 1. Examine the request<br></br>
     * 2. Optionally wrap the request object with a custom implementation to
     * filter content or headers for input filtering <br></br>
     * 3. Optionally wrap the response object with a custom implementation to
     * filter content or headers for output filtering <br></br>
     * 4. a) **Either** invoke the next entity in the chain using
     * the FilterChain object (`chain.doFilter()`), <br></br>
     * 4. b) **or** not pass on the request/response pair to the
     * next entity in the filter chain to block the request processing<br></br>
     * 5. Directly set headers on the response after invocation of the next
     * entity in the filter chain.
     *
     * @param request  The request to process
     * @param response The response associated with the request
     * @param chain    Provides access to the next filter in the chain for this
     * filter to pass the request and response to for further
     * processing
     *
     * @throws IOException if an I/O error occurs during this filter's
     * processing of the request
     * @throws ServletException if the processing fails for any other reason
     */
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        println("Before Time Filter")
        chain?.doFilter(request, response)
        println("AFter Time Filter")
    }
}