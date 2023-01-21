
# Spring Boot Kafka Example

A brief description of what this project does and who it's for

Run docker-compose file using ```docker compose up``` command, but change ip addresses in docker-compose.yml with your local ip address before using command

Run kafka-producer project, then  
### Send Request
```http
POST http://localhost:8080/kafka/produce
 ```
### Example json

```json
{
    "id": "4295",
    "code": "a36ty",
    "time": "30.12.2001"
}
```

Run kafka-consumer project, then you will see the json message in log like this

```code
2023-01-22 00:09:21.348  INFO 56374 --- [ntainer#0-0-C-1] i.d.k.service.ConsumerService : Message from topic: MESSAGE_TOPIC message: "{\"id\":\"4295\",\"code\":\"a36ty\",\"time\":\"30.12.2001\"}"
```

