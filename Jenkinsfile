def SKA_CODE
pipeline {
	agent any
    tools {
        maven 'maven3.6.2'     
    }
	    
	stages {
        stage('build stage') {
		            steps {
			    timestamps {
		        logstash {
			wrap([$class: 'BuildUser']) {
                        sh 'echo " started by ${BUILD_USER}"'
                    }
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
		    sh ' pip3 install elasticsearch '
		
	  	    sh ' python3 test.py firsttest skander'


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
