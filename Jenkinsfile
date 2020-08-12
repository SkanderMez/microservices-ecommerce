pipeline {
         agent any
         stages {
                 stage('build stage') {
                 steps {
			timestamps {
		        logstash {
		
			
                     sh 'cd rder-service && mvn clean install'
		     sh 'cd api-gateway && mvn clean install'  		    
                     sh 'cd eureka-server && mvn clean install'
                     sh 'cd product-catalog-service && mvn clean install'
                     sh 'cd product-recommendation-service && mvn clean install'
		     sh 'cd user-service && mvn clean install'

                     echo 'Building Spring Boot application '
			}}
                 }
                 }
		   post { 
        failure { 
		timestamps{
		logstash{
            echo 'One of the builds has been failed !'
}}
        }
    }
                 stage('build docker image stage ') {
                 steps {
                    sh 'docker-compose up -d --build'
                    echo 'Building docker image'
			                timestamps {
                    logstash {
                        echo "hello world 2"
                    }
                }

                 }
                 }
         }
}
