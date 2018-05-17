pipeline {
 agent any
 tools {
        maven 'Maven 3.5.0'
    }
 stages {
     stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
 	stage("Checkout") {
 			steps {
 				git url: 'https://github.com/starkTarg/weather-forcaster.git'
 			}
 		}
 	stage("Build") {
 			steps {
 				sh "mvn clean install -Dmaven.skip.test=true"
 			}
		}
	stage("Test") {
 			steps {
 				sh "mvn test"
 			}
		
	stage("Dockerise and Push") {
			steps {
					//sh "mvn package dockerfile:build"
					//sh "docker tag wf/weather-forcaster:latest 709325198486.dkr.ecr.us-east-1.amazonaws.com/weather-forcaster:latest"
					docker.build('demo')
					docker.withRegistry('https://709325198486.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:demo-aws-credentials') {
    					//docker.image('weather-forcaster').push('latest')
    					docker.image('demo').push('latest')
    					//sh "docker push 709325198486.dkr.ecr.us-east-1.amazonaws.com/weather-forcaster:latest-1"
 				}
			}
	}
 }
}