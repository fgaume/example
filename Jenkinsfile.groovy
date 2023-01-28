pipeline {

    agent any

    options {

        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')

    }

    stages {

        stage('Hello java') {

            steps {

                sh '''

          java -version

        '''

            }

        }

        stage('cat README') {

            when {

                branch "dev"

            }

            steps {

                sh '''

          cat README.md

        '''

            }

        }

    }

}

