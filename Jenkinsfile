pipeline {
    agent any
    stages {
        stage('checking') {
            steps {
                git branch: 'main', url: 'https://github.com/jiakeke/swep1_week7_inclass.git'
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test & Coverage') {
            steps {
                sh 'mvn test jacoco:report' // Run tests and generate a JaCoCo coverage report
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml' // Publish JUnit test results
                    jacoco execPattern: '**/target/jacoco.exec', // Reads JaCoCo execution file
                           classPattern: '**/target/classes',
                           sourcePattern: '**/src/main/java',
                           exclusionPattern: '**/test/**'
                }
            }

        }
    }
}
