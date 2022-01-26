pipeline {
  environment {
    registry = "kgassab/kubernetes"
    registryCredential = 'DockerHub'
    dockerImage = ''

            stageCompile = ':x:'
            stageDependencies = ':x:'
            stageTest = ':x:'
            stageClient = ':x:'
            stageArchive = ':x:'



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
            docker.withRegistry( '', registryCredential ) {
            dockerImage = docker.build
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


