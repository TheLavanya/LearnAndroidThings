pipeline {
    agent any

    stages {
        stage('creating apk') {
           steps {
            sh 'echo "Creating apk"',
            sh './gradlew assembleRelease'
           }
        }
        stage('creating bundle') {
           steps {
            sh 'echo "Creating bundle"',
            sh './gradlew bundleRelease'
            }
        }
    }
}