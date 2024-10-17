pipeline {
    agent { 
        label 'ubuntu' 
    }

    environment {
        JAVA_HOME = tool name: 'JDK 17', type: 'JDK' 
    }

    stages {
        stage('Checkout code') {
            steps {
                checkout scm
            }
        }

        stage('Cache Gradle packages') {
            steps {
                script {
                
                    cache(
                        path: '.gradle/caches',
                        key: "${env.NODE_NAME}-gradle-${env.BUILD_NUMBER}",
                        restoreKeys: ["${env.NODE_NAME}-gradle-"]
                    ) {
                        echo "Gradle cache is restored"
                    }
                }
            }
        }

        stage('Build with Gradle') {
            steps {
                sh './gradlew build --no-daemon'
            }
        }

        stage('Run tests') {
            steps {
                sh './gradlew test --no-daemon'
            }
        }
    }

    post {
        always {
            junit 'build/test-results/**/*.xml'
        }

        success {
            echo 'Build and test succeeded!'
        }

        failure {
            echo 'Build or test failed!'
        }
    }
}
