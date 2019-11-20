# User Management:0.0.1

## 1. Setting Up Docker

### Installing Docker for Centos


For detailed installation instructions for Centos, [**see the documentation**](https://docs.docker.com/install/linux/docker-ce/centos/) .

### Installing Docker for Ubuntu

For detailed installation instructions for Centos, [**see the documentation**](https://docs.docker.com/install/linux/docker-ce/ubuntu/) .

### Docker behind Corporate Proxy
__Method 1__ :
To configure docker to use a proxy server, [**see the documentation**](https://docs.docker.com/network/proxy/) .

__Method 2__ :
Configuring environment variables

- Create a folder


        sudo mkdir /etc/systemd/system/docker.service.d
	
- Create a file with name **_/etc/systemd/system/docker.service.d/http-proxy.conf_**   that adds the HTTP_PROXY environment variable:

  

    	[Service]
    	Environment="HTTP_PROXY=http://<USERID>:<PASSWORD>@proxy.stackoasis:8080/"
    	Environment="HTTPS_PROXY=https://<USERID>:<PASSWORD>@proxy.stackoasis:8080/"
    	Environment="NO_PROXY= hostname.example.com,localhost"
	
 - Reload the systemd daemon



        sudo systemctl daemon-reload
	
 - Restart docker


        sudo systemctl restart docker


## 2. Configuration for User Management
###		Server Configuration
  Go to `src/main/resources/application.properties` .
####  Server Port Configuration


  To Change Server Port 

        server.port=8011

	    
####	Mongo DB Configuration
    spring.data.mongodb.host=ummongo
    spring.data.mongodb.port= 27017
    spring.data.mongodb.uri=mongodb://ummongo/usermanagement
          
###  Run Using Docker
#### Maven proxy configuration
Go to `settings.xml` .

Replace USERNAME with your ADID and PASSWORD with your  Password.
Replace Your Company proxy with Port.

## 3. Installing User Management App using Docker-Compose
### Build User Management App with Docker-Compose

    sudo docker-compose build --build-arg  http_proxy="http://proxy.stackoasis.com:8080" --build-arg  https_proxy="http://proxy.stackoasis.com:8080" --no-cache 


### Run User Management App with Docker-Compose

      sudo docker-compose up

### Without Docker Image

      mvn spring-boot:run
