pipeline {
    agent any

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/Pranavyadav12345/Testautomationjenkins.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t api-test .'
            }
        }

        stage('Run API Tests') {
            steps {
                sh 'docker run api-test'
            }
        }

        stage('Tag Docker Image') {
            steps {
                sh 'docker tag api-test yadavpranav858/api-test:latest'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push yadavpranav858/api-test:latest'
            }
        }
    }
}