node {
     stage ('Initialize') {
     	def dockerHome = tool 'myDocker'
     	def mavenHome  = tool 'myMaven'
     	env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
            try {
            	sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
            catch(error) {
            	echo "Exception occured while initializing ${error}"	
            }      
        }
 	stage("Checkout") {
 			try {
 				git url: 'https://github.com/starkTarg/weather-forcaster.git'
 			} catch(error) {
            	echo "Exception occured while checkout of the repo ${error}"	
            }
 		}
 	stage("Build") {
 			try {
 				sh "mvn clean install -Dmaven.skip.test=true"
 			} catch(error) {
            	echo "Exception occured while building app ${error}"	
            }
		}
	stage("Test") {
 			try {
 				sh "mvn test"
 			} catch(error) {
            	echo "Exception occured while testing app ${error}"	
            }
 		}
		
	stage("Dockerise and Push") {
			try {
					//sh "mvn package dockerfile:build"
					//sh "docker tag wf/weather-forcaster:latest 709325198486.dkr.ecr.us-east-1.amazonaws.com/weather-forcaster:latest"
					sh "docker --version"
					script {
						docker.build('demo')
						docker images
						echo "AWS Version"
						aws --version
						sh "docker push 709325198486.dkr.ecr.us-east-1.amazonaws.com/demo:latest-1"
 						echo "Pushed Image to ECR with tag latest-1"

						docker.withRegistry('https://709325198486.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:demo-aws-credentials') {
    						//docker.image('weather-forcaster').push('latest')
    						docker.image('demo').push('latest')
    						echo "Pushed Image to ECR"
    					}
 					}
 					sh "docker push 709325198486.dkr.ecr.us-east-1.amazonaws.com/demo:latest-1"
 					echo "Pushed Image to ECR with tag latest-1"
				} catch(error) {
            		echo "Exception occured while dockerising and pushing the image ${error}"	
            	}
	}
 
}