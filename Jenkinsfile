pipeline {
         agent any
         stages {
                 stage('build stage') {
                 steps {
			timestamps {
		        logstash {	
                     sh 'cd order-service && mvn clean install'
		     sh 'cd api-gateway && mvn clean install'  		    
                     sh 'cd eureka-server && mvn clean install'
                     sh 'cd product-catalog-service && mvn clean install'
                     sh 'cd product-recommendation-service && mvn clean install'
		     sh 'cd user-service && mvn clean install'  
				        wrap([$class: 'BuildUser']) {
          sh 'echo "${BUILD_USER}"'
        }
			}}
                 }
                 
	 }
                 stage('build docker image stage ') {
                 steps {
	     
			                timestamps {
                    logstash {
	            echo 'this project contains docker'
		    echo ' sonarqube'
                    sh 'docker-compose up -d --build'


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
            currentBuild.data.kar = 'sonar & docker'
		
		currentBuild.result = 'SUCCESS'
        }
		}}
        }

        failure {
	        timestamps{
		logstash{		
        script {
		echo " failed test"
				echo "TimeStamp: ${currentBuild.duration}"
            currentBuild.data.kar = 'sonar & docker'
		
            currentBuild.result = 'FAILURE'
            }
		}}
        }

        aborted {
	        timestamps{
		logstash{		
        script {
						echo "TimeStamp: ${currentBuild.duration}/1000"			   
		echo " aborted test"
            currentBuild.data.kar = 'sonar & docker'
		
            currentBuild.result = 'ABORTED'
            }
		}}
        }
       
    }

}
