# Spring Redis cache
Demo project for using Spring with Redis for cache.


Use this calls for test.  
`curl -X POST http://localhost:8080/redis/demo/add -H 'Content-Type: application/json' -d '{"emailId": "pesho@abv.bg","password": "1"}'`  

`curl -X POST http://localhost:8080/redis/demo/ -H 'Content-Type: application/json' -d '{"emailId": "pesho@abv.bg","password": 1"}'`


_* For OS Windows you must change quotes._  
`curl -X POST "http://localhost:8080/redis/demo/add" -H "Content-Type: application/json" -d "{\"emailId\": \"pesho@abv.bg\",\"password\": \"1\"}"`

`curl -X POST "http://localhost:8080/redis/demo" -H "Content-Type: application/json" -d "{\"emailId\": \"pesho@abv.bg\",\"password\": \"1\"}"`



You need Redis and MySQL running on your machine.  
Redis:  
`docker run -it --name redis-cache-name -p 6379:6379 redis:latest`  

