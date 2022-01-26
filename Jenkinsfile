pipeline {
environment {
registry = "kgassab/kubernetes"
registryCredential = 'DockerHub'
dockerImage = ''
}
agent any
stages {
stage('Cloning our Git') {
steps {
git 'https://github.com/kgassab1/kubernetes.git'
}
}
stage('Building our image') {
steps{
script {
sh "docker build -t kgassab/kubernetes --pull=true"

}
}
}
stage('Deploy our image') {
steps{
script {
docker.withRegistry( '', registryCredential ) {
sh "docker push kgassab/kubernetes"
}
}
}
}
stage('Cleaning up') {
steps{
sh "docker rmi $registry:$BUILD_NUMBER"
}
}
}
}