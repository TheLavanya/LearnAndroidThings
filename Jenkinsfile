 pipeline {
   agent any

   stages {
     stage('Making gradle wrapper executable') {
       steps {
         sh 'chmod 777 gradlew '
       }
     }
     stage('creating apk') {
       steps {
         sh './gradlew assembleRelease'
       }
     }
     stage('creating bundle') {
           steps {
             sh './gradlew bundleRelease'
           }
      }
     stage('Archiving APK') {
       steps {
         archiveArtifacts artifacts: '**/*.apk',
         followSymlinks: false
       }
     }
     stage('Archiving Bundle') {
           steps {
             archiveArtifacts artifacts: '**/*.aab',
             followSymlinks: false
           }
         }
     stage('Publishing to Play store') {
       steps {
         echo 'Hello World 4'
       }
     }
   }
 }