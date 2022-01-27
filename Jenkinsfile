pipeline {
agent any
  environment {
    registry = "kgassab/kubernetes"
    registryCredential = 'DockerHub'
    dockerImage = ''
  }


  stages {


  checkout scm
      //env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
      stage('Package') {
          dir('RpcServerSample') {
              sh 'mvn clean package -DskipTests'
          }
      }


    stage('Cloning Git') {
      steps {
        git 'https://github.com/kgassab1/kubernetes.git'
      }
    }
    stage('Building image') {
      steps{
        script {

            dockerImage = docker.build

        }
      }
    }


    stage('Publish Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
               }
           }
        }
    }


  }
}


