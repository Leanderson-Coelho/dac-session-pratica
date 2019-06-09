sudo docker-compose down
sudo docker image rm -f $(sudo docker image ls | grep dac-session-pratica)
mvn clean package
sudo docker-compose up --build
