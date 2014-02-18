
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/ping", forward: "/PingService.groovy"
get "/primeFactors", forward: "/PrimeFactorsService.groovy"
