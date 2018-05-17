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
 stage("Compile") {
 steps {
 	sh "mvn clean install -Dmaven.skip.test=true"
 }
}
stage("Unit test") {
 steps {
 sh "mvn test"
 }
}
 }
}