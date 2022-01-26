pipeline {
agent any

  environment {
    registry = "kgassab/kubernetes"
    registryCredential = 'DockerHub'
    dockerImage = ''
  }


  stages {



    stage('Cloning Git') {
      steps {
        git 'https://github.com/kgassab1/kubernetes'
      }
    }
    stage('Building image') {
      steps{
        script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage = docker.build registry + ":$BUILD_NUMBER"
           }
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


