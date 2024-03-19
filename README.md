# helidon quick benchmark
Simple perfoormance behcmark that emulates http proxy layer to upstream with configurable delay

benchmarked with help of vegeta

Explicitly using WebClient
```
echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=10s -rate=500 | vegeta report
```

                                
