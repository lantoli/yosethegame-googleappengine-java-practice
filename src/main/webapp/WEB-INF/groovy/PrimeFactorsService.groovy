def decomp = new Decomposition()
def factors = (params.number as String[]).collect { decomp.factorsWithErrors(it) }
response.contentType = "application/json"
json factors.size() == 1 ? factors[0] : factors
