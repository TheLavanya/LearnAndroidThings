pipeline {
    agent any

    stages {
        stage('creating apk') {
           steps {
            echo 'Creating apk',
            sh './gradlew assembleRelease'
           }
        }
        stage('creating bundle') {
           steps {
            echo 'Creating bundle',
            sh './gradlew bundleRelease'
            }
        }
    }
}