pipeline{
    agent any

    environment{
        DOCKERHUB_CREDENTIALS = credentials('dckr_pat_aJVBCXxr0TnIYmZ_pkigGC6ax48');
    }
    stages{
        stage("checkout"){
            steps{
                git url : 'https://github.com/2023PHOENIX/HELLO_JENKINS.git'
            }
           
        }
    }
    stage("build"){
        steps{
            sh 'mvn clean install'
        }
    }
    stage("build docker image"){
        steps{
            script{
                dockerImage = docker.build("my-app:${env.BUILD_ID}")
            }
        }
    }
    stage("Push Docker image"){
        steps{
            script {
                docker.withRegistry('https://index.docker.io/v1/',"$DOCKERHUB_CREDENTIALS"){
                    dockerImage.push('latest')
                }
            }
        }
    }
    stage("Deploy"){
        steps{
             steps {
                bat '''
                docker stop my-app || exit 0
                docker rm my-app || exit 0
                docker run -d -p 8089:8089 --name my-app my-app:latest
                '''
            }
        }
    }
}