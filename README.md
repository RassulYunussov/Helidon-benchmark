# helidon quick benchmark
Simple perfoormance behcmark that emulates http proxy layer to upstream with configurable delay

benchmarked with help of vegeta

dies on my machine and never recuperate (m2 macbook pro) with:

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=10s -rate=500 | vegeta report

whereas webflux - processes with no problems: https://github.com/RassulYunussov/performance-api-webflux-vs-mvc-vs-golang/tree/go-client-flux


                                
