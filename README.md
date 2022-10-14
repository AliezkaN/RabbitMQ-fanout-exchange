# To check how fanout exchange works

# First way
* Run RabbitMQ in Docker container:
```ssh
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```
* RabbitMQ web Console: http://localhost:15672/
* Run all three spring boot applications

# Second way
* Package each application with maven
* Build docker images with docker compose
```ssh
docker-compose build
```
* Run containers with docker compose
```ssh
docker-compose up
```
# Request
![image](https://user-images.githubusercontent.com/84874469/195671156-2cd389e9-40e7-44a1-bd01-ab405e28b1a5.png)
![image](https://user-images.githubusercontent.com/84874469/195930813-76ec8d84-5e30-4974-b069-6d608da5f5d8.png)
