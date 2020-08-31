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
			}}
                 }
                 
	 }
                 stage('build docker image stage ') {
                 steps {
  	   	    echo 'this project contains docker'
                    sh 'docker-compose up -d --build'
	     
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
				echo "TimeStamp: ${currentBuild.duration}"			   

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
            currentBuild.result = 'ABORTED'
            }
		}}
        }
       
    }

}
