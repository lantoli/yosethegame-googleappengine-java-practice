
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/ping", forward: "/PingService.groovy"
get "/primeFactors", forward: "/PrimeFactorsService.groovy"
all "/primeFactors/ui", forward: "/WEB-INF/pages/primeFactors.gtpl"
get "/minesweeper", forward: "/WEB-INF/pages/minesweeper.gtpl"
get "/fire/geek", forward: "/FireService.groovy"
