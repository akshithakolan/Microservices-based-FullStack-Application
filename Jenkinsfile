pipeline {
    agent any
    environment {
        PROJECT_ID = 'rancher'
        CLUSTER_NAME = 'hw33'
        LOCATION = 'us-east-1a'
        DOCKERHUB_PASS = '******'
    }
    stages {
        stage("Checkout code") {
            steps {
                checkout scm
            }
        }
        stage('BuildWAR') {
            steps {
                sh 'docker login -u akolanup -p ${DOCKERHUB_PASS}'
                sh 'docker build -t akolanup/springboot-app:latest .'
                
            }
        }
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push akolanup/springboot-app:latest'
                    
				}
			}
		}
    
        stage("UpdateDeployment") {
            steps {
					sh 'kubectl rollout restart deploy newdep'
	    }
        }
    }
}
