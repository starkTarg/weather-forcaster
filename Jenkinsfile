def AWS_REGION=env.AWS_REGION
def AWS_ACCESS_KEY_ID=env.AWS_ACCESS_KEY_ID
def AWS_SECRET_ACCESS_KEY=env.AWS_SECRET_ACCESS_KEY

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
				aws configure --region $AWS_REGION --access-key $AWS_ACCESS_KEY_ID --secret-key $AWS_SECRET_ACCESS_KEY
				echo "Logging into AWS ECR"
    			echo "aws --version"
				sh "eval \$(aws ecr get-login --no-include-email | sed 's|https://||')"
 					script {
						docker.build('weather-forcaster')

						docker.withRegistry('https://709325198486.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:demo-aws-credentials') {
    						docker.image('weather-forcaster').push('latest')
    						echo "Pushed Image to ECR"
    					}
 					}
				} catch(error) {
            		echo "Exception occured while dockerising and pushing the image ${error}"	
            	}
	}
 
}