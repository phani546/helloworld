pipeline{
    agent any
    environment {
		dockerHome= tool 'mymaven'
		mavenHome= tool 'mydocker'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
    stages{
        stage(Checkout){
          steps{
              sh 'mvn --version'
              sh 'docker version'
          }
        }
        stage(Build){
            steps{
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps{
                echo 'Test Here'
            }
        }
        stage('Integration Test'){
            steps{
                echo 'Integration Tests'
            }
        }
        stage('Package'){
           steps{
                sh 'mvn package -DskipTests'
           }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    dockerImage = docker.build(068160335013.dkr.ecr.us-east-1.amazonaws.com/helloworld:${env.BUILD_TAG}
                }
            }
        }
        stage('Push Docker Image'){
            steps{
                script{
                    docker.withRegistry('https://068160335013.dkr.ecr.us-east-1.amazonaws.com','ecr:us-east-1:ECR-PUSH'){
                        dockerImage.push();
                        dockerImage.push('latest');
                    }
                }
            }
        }
    }
    post{
		always{
			echo 'I run always'
		}
		success{
			echo 'I run when you are successful'
		}
		failure{
			echo 'I run when failure'
		}
		changed{
			echo 'I run when u fail'
		}
	}
}