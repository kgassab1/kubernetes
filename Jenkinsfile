pipeline {
  environment {
    registry = "kgassab/kubernetes"
    registryCredential = 'DockerHub'
    dockerImage = ''

  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/kgassab1/kubernetes'
      }
    }
    stage('Building image') {
      steps{
        script {

          dockerImage = docker.build("app.jar")
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