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
        stage('archiving apk') {
            steps {
              echo 'Archiving Apk',
              archiveArtifacts artifacts: '**/*.apk'
            }
        }
        stage('archiving bundle') {
            steps {
               echo 'Archiving Bundle',
               archiveArtifacts artifacts '**/*.aab'
            }
        }
    }
}