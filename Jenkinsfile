pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git url : 'https://github.com/2023PHOENIX/HELLO_JENKINS.git'
            }
           
        }
    }
    stage("build"){
        steps{
            sh  'mvn clean install'
        }
    }

    stage("Deploy"){
        steps{
            sh 'mvn deploy'
        }
    }
}