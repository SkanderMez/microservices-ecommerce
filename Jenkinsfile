def SKA_CODE
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
						
						SKA_CODE = "CECI EST UN TEST"
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
		
		currentBuild.result = 'SUCCESS'
        }
		}}
        }

        failure {
	        timestamps{
		logstash{		
			script{
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
