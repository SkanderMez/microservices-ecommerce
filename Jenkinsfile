pipeline {
         agent any
         stages {
                 stage('build stage') {
                 steps {
			timestamps {
		        logstash {
		
						    script {
		echo "TimeStamp: ${currentBuild.startTimeInMillis}"			   
						    }
                     sh 'cd order-service && mvn clean install'
		     sh 'cd api-gateway && mvn clean install'  		    
                     sh 'cd eureka-server && mvn clean install'
                     sh 'cd product-catalog-service && mvn clean install'
                     sh 'cd product-recommendation-service && mvn clean install'
		     sh 'cd user-service && mvn clean install'

                     echo 'Building Spring Boot application '
			}}
                 }
                 
	 }
                 stage('build docker image stage ') {
                 steps {
                    sh 'docker-compose up -d --build'
                    echo 'Building docker image'
			                timestamps {
                    logstash {

                    }
                }

                 }
                 }
         }
	
	post { 
        success { 
	        timestamps{
		logstash{
        script {
		echo " success test"
            currentBuild.result = 'SUCCESS'
        }
		}}
        }

        failure {
	        timestamps{
		logstash{		
        script {
		echo " failed test"
            currentBuild.result = 'FAILURE'
            }
		}}
        }

        aborted {
	        timestamps{
		logstash{		
        script {
		echo " aborted test"
            currentBuild.result = 'ABORTED'
            }
		}}
        }
       
    }

}
