# istio-k8-demo
demo-1-app calls demo-2-app

kubectl apply -f /Users/mchavak/Documents/muzimil/gitHubNew/istio-k8-demo/demo1-2.yml
kubectl apply -f /Users/mchavak/Documents/muzimil/gitHubNew/istio-k8-demo/demogateway.yml





Every thing is on local docker hub. Images from local

http://localhost/demo1/getDetails

This calls second services

Second service

http://localhost/demo2/getDetails

Retry on http://localhost/demo2/getDetails/12

No retry on http://localhost/demo2/getDetails/123

Circuit Breaker I just configured on service 2
kubectl apply -f /Users/mchavak/Documents/muzimil/gitHubNew/istio-k8-demo/circuitBreak.yaml

Hit  http://localhost/demo2/getDetails/12
Then service will be out of lb for some time as per conf

